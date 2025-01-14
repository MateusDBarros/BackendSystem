package com.example.teste.turmaParticipante.Repository;

import com.example.teste.turmaParticipante.Model.TurmaParticipante;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ParticipantesRepository {

    private final JdbcTemplate jdbc;

    public ParticipantesRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    // Metodos para realizar as tarefas

    public void adicionarParticipante(int turmaID, int funcionarioID) {
        String sql = "INSERT INTO TurmaParticipante (Turma, Funcionario) VALUES (?, ?)";
        jdbc.update(sql, turmaID, funcionarioID);
    }

    public List<TurmaParticipante> listarParticipantes() {
        String sql = "SELECT Codigo, Turma, Funcionario FROM TurmaFuncionario";
        return jdbc.query(sql, (rs, rowNum) ->
                new TurmaParticipante(
                rs.getInt("Codigo"),
                rs.getInt("Turma"),
                rs.getInt("Funcionario")
                )
        );
    }

    public void deletarParticipante(int codigo) {
        String sql = "DELETE FROM TurmaParticipante WHERE Codigo = ?";
        jdbc.update(sql, codigo);
    }

    // Metodo para checar se existe o participante
    public boolean participanteExiste(int codigo) {
        String sql = "SELECT COUNT(*) FROM TurmaParticipante WHERE Codigo = ?";
        Integer count = jdbc.queryForObject(sql, Integer.class, codigo);
        return count != null && count > 0;
    }
}
