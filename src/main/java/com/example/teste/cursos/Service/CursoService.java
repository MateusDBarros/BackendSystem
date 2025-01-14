package com.example.teste.cursos.Service;


import com.example.teste.cursos.Model.Curso;
import com.example.teste.cursos.Repository.CursoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CursoService {

    private final CursoRepository repository;


    public CursoService(CursoRepository cursoRepository) {
        this.repository = cursoRepository;
    }

    // Puxa os metodos do repositorio para verificação e tratamento de exceçôes

    public void novoCurso(Curso curso) {
        if (curso.getNome() == null || curso.getNome().isEmpty())
            throw new IllegalStateException("Insira o nome do curso");
        if (curso.getDuracao() <= 0 )
            throw new IllegalStateException("Duração do curso precisa ser maior que 1");

        repository.novoCurso(curso);
    }

    public List<Curso> listarCurso() {
        return repository.listarCursos();
    }

    @Transactional
    public void atualizarCurso(Curso curso) {
        if (!repository.cursoExiste(curso.getCodigo())) {
            throw new IllegalStateException("O curso com o código " + curso.getCodigo() + " não existe.");
        }
        if (curso.getNome() == null || curso.getNome().isEmpty()) {
            throw new IllegalStateException("Insira o nome do curso.");
        }
        if (curso.getDuracao() < 1) {
            throw new IllegalStateException("Duração do curso precisa ser maior que 1.");
        }
        repository.atualizarCurso(curso);
    }


    public void deletarCurso(int codigo) {
        if (!repository.cursoExiste(codigo))
            throw new IllegalStateException("Este curso não existe, por favor verifique o codigo: " +codigo);

        repository.deletarCurso(codigo);
    }
}
