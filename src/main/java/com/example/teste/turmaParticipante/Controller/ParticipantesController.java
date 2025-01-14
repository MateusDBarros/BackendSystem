package com.example.teste.turmaParticipante.Controller;

import com.example.teste.turmaParticipante.Model.TurmaParticipante;
import com.example.teste.turmaParticipante.Service.ParticipantesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/turmas/{turmaID}/participantes")
public class ParticipantesController {

    private final ParticipantesService service;

    public ParticipantesController(ParticipantesService service) {
        this.service = service;
    }

    // Criação dos 3 ultimos endpoints

    @PostMapping
    public ResponseEntity<String> postParticipante(@PathVariable int turmaID, @RequestParam int funcionarioID) {
        service.novoParticipante(turmaID, funcionarioID);
        return ResponseEntity.status(HttpStatus.CREATED).body("Participante adicionado");
    }

    @GetMapping
    public ResponseEntity<List<TurmaParticipante>> getParticipantes() {
        List<TurmaParticipante> participantes = service.listarParticipantes();
        return ResponseEntity.status(HttpStatus.OK).body(participantes);
    }

    @DeleteMapping("{codigo}")
    public ResponseEntity<String> deleteParticipante(@PathVariable int codigo) {
        service.deletarParticipante(codigo);
        return ResponseEntity.status(HttpStatus.OK).body("Funcionario com ID: " +codigo+ " excluido com sucesso");
    }
}
