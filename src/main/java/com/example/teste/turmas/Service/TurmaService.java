package com.example.teste.turmas.Service;

import com.example.teste.cursos.Repository.CursoRepository;
import com.example.teste.turmas.Model.Turma;
import com.example.teste.turmas.Repository.TurmaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurmaService {

    private final TurmaRepository turmaRepository; // Para usar os metodos
    private final CursoRepository cursoRepository; // Para usar a funçao de checagem da existencia do curso

    public TurmaService(TurmaRepository turmaRepository, CursoRepository cursoRepository) {
        this.turmaRepository = turmaRepository;
        this.cursoRepository = cursoRepository;
    }

    // Puxa os metodos do repositorio e verifica e trata de exceçôes

    // Criação de novas turmas e tratamento de exceções para evitar erros
    public void novaTurma(Turma turma) {
        if (!cursoRepository.cursoExiste(turma.getCursoID()))
            throw new IllegalStateException("O curso selecionado não existe");
        if (turma.getFim().isBefore(turma.getInicio()))
            throw new IllegalStateException("Data com valores inconcistente, verifique a data de inicio e do fim");

        turmaRepository.criarTurma(turma);
    }

    // Listagem das turmas
    public List<Turma> listarTurmas() {
        return turmaRepository.listarTurmas();
    }

    // Atualizar turma e trata exceções para evitar erros
    public void atualizarTurma(Turma turma) {
        // Exceções para previnir e alertar no caso de erros
        if (!cursoRepository.cursoExiste(turma.getCursoID()))
            throw new IllegalStateException("O curso selecionado não exisee");
        if (!turma.getInicio().isBefore(turma.getFim()))
            throw new IllegalStateException("Data com valores inconscistente, verifique a data de inicio e do fim");
        if (turma.getLocal() == null || turma.getLocal().isEmpty())
            throw new IllegalStateException("O curso precisa ter um local definido.");

        turmaRepository.atualizarTurma(turma);
    }

    // Deletar uma turma, assim como todos os participantes dela
    public void deletarTurma(int codigo) {
        if(!turmaRepository.turmaExiste(codigo))
            throw new IllegalStateException("Turma selecionada nao existe");
        turmaRepository.deletarTurma(codigo);
    }
}
