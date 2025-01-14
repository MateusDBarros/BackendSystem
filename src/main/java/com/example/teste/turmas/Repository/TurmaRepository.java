package com.example.teste.turmas.Repository;

import com.example.teste.turmas.Model.Turma;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TurmaRepository {

    private final JdbcTemplate jdbc;


    public TurmaRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    // Criação dos metodos que serão usados pelo service

    // Metodo para criar turma
    public void criarTurma(Turma turma){
        String sql = "INSERT INTO  Turma (Inicio, Fim, Local, Curso) VALUES (?, ?, ?, ?)";
        jdbc.update(sql, turma.getInicio(), turma.getFim(), turma.getLocal(), turma.getCursoID());
    }

    // Metodo para fazer a listagem de todas as turmas
    public List<Turma> listarTurmas() {
        String sql = "SELECT Codigo, Inicio, Fim, Local, Curso FROM Turma";
        return jdbc.query(sql, (rs, rowNum) ->
                new Turma(
                        rs.getInt("Codigo"),
                        rs.getDate("Inicio").toLocalDate(),
                        rs.getDate("Fim").toLocalDate(),
                        rs.getString("Local"),
                        rs.getInt("Curso")
                )
        );
    }

    // metodo para atualizar
    public void atualizarTurma(Turma turma) {
        String sql = "UPDATE Turma SET Inicio = ?, Fim = ?, Local = ?, Curso = ? WHERE Codigo = ?";
        jdbc.update(sql, turma.getInicio(), turma.getFim(), turma.getLocal(), turma.getCursoID(), turma.getCodigo());
    }

    // Metodo para deletar
    public void deletarTurma(int codigo) {
        String sql = "DELETE FROM Turma WHERE Codigo = ?";
        jdbc.update(sql, codigo);
    }

    // Metodo para chcar a existencia da turma, igual como foi com o curso e evitar repetiçoes
    public boolean turmaExiste(int codigo) {
        String sql = "SELECT COUNT(*) FROM Turma WHERE Codigo = ?";
        Integer count = jdbc.queryForObject(sql, Integer.class, codigo);
        return count != null && count > 0;
    }

}
