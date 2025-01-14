package com.example.teste.turmaParticipante.Service;

import com.example.teste.turmaParticipante.Model.TurmaParticipante;
import com.example.teste.turmaParticipante.Repository.ParticipantesRepository;
import com.example.teste.turmas.Repository.TurmaRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ParticipantesService {

    private final ParticipantesRepository participanteRepository;
    private final TurmaRepository turmaRepository;

    public ParticipantesService(ParticipantesRepository participanteRepository, TurmaRepository turmaRepository) {
        this.participanteRepository = participanteRepository;
        this.turmaRepository = turmaRepository;
    }

    // Puxa os metodos dos Repositorios e aplica regra de negocio

    // Adicionar novo participante em um curso
    public void novoParticipante(int turmaID, int funcionarioID) {
        if (!turmaRepository.turmaExiste(turmaID))
            throw new IllegalStateException("Turma com ID: " +turmaID+ " não existe");
        participanteRepository.adicionarParticipante(turmaID, funcionarioID);
    }

    // Lista todos os participantes de um curso
    public List<TurmaParticipante> listarParticipantes() {
        return listarParticipantes();
    }

    // Deleta um participante de um curso
    public void deletarParticipante(int codigo) {
        if (!participanteRepository.participanteExiste(codigo))
            throw new IllegalStateException("Participante com ID: " +codigo+ " não existe");
        participanteRepository.deletarParticipante(codigo);
    }
}
