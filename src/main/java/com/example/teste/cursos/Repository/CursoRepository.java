package com.example.teste.cursos.Repository;

import com.example.teste.cursos.Model.Curso;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class CursoRepository {

    private final JdbcTemplate jdbc;

    public CursoRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    //Função para salvar novos cursos no banco de dados
    public void novoCurso(Curso curso) {
        String sql = "INSERT INTO Curso (Nome, Descricao, Duracao) VALUES (?, ?, ?)";
        jdbc.update(sql, curso.getNome(), curso.getDescricao(), curso.getDuracao());

    }


    //Função para recuperar os dados
    public List<Curso> listarCursos() {
        String sql = "SELECT Codigo, Nome, Descricao, Duracao FROM Curso";
        return jdbc.query(sql, (rs, rowNum) ->
                new Curso(
                        rs.getInt("Codigo"),
                        rs.getString("Nome"),
                        rs.getString("Descricao"),
                        rs.getInt("Duracao")
                )
        );
    }


    // Atualiza o banco de dados
    public void atualizarCurso(Curso curso) {
        String sql = "UPDATE curso SET Nome = ?, Descricao = ?, Duracao = ? WHERE Codigo = ?";
        jdbc.update(sql, curso.getNome(), curso.getDescricao(), curso.getDuracao(), curso.getCodigo());
    }

    //Metodo para apagar um curso
    public void deletarCurso(int codigo)  {
        String sql = "DELETE FROM curso WHERE Codigo = ?";
        jdbc.update(sql, codigo);
    }

    // Metodo para checar se existe um curso, para evitar repeticao de codigo
    public boolean cursoExiste(int codigo) {
        String sql = "SELECT COUNT(*) FROM Curso WHERE Codigo = ?";
        Integer count = jdbc.queryForObject(sql, Integer.class, codigo);
        return count != null && count > 0;
    }
}
