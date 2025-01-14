package com.example.teste.turmas.Controller;

import com.example.teste.turmas.Model.Turma;
import com.example.teste.turmas.Service.TurmaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turmas")
public class TurmaController {

    private final TurmaService service;


    public TurmaController(TurmaService service) {
        this.service = service;
    }

    // Criação dos endpoints

    @PostMapping
    public ResponseEntity<String> postTurma(@RequestBody Turma turma) {
        service.novaTurma(turma);
        return ResponseEntity.status(HttpStatus.CREATED).body("Turma criada");
    }

    @GetMapping
    public ResponseEntity<List<Turma>> getTurma() {
        List<Turma> turmas = service.listarTurmas();
        return ResponseEntity.status(HttpStatus.OK).body(turmas);
    }

    @PutMapping("{codigo}")
    public ResponseEntity<String> putTurmas (@PathVariable int codigo,@RequestBody Turma turma) {
        turma.setCodigo(codigo);
        service.atualizarTurma(turma);
        return ResponseEntity.status(HttpStatus.OK).body("Turma atualizada");
    }

    @DeleteMapping("{codigo}")
    public ResponseEntity<String> deleteTurma (@PathVariable int codigo) {
        service.deletarTurma(codigo);
        return ResponseEntity.status(HttpStatus.OK).body("Turma com o codigo: " +codigo+ " excluido com sucesso");
    }
}
