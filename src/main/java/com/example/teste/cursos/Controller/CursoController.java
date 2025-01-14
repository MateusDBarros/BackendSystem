package com.example.teste.cursos.Controller;

import com.example.teste.cursos.Model.Curso;
import com.example.teste.cursos.Service.CursoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    private final CursoService service;

    public CursoController(CursoService service) {
        this.service = service;
    }


    // Ciração dos endpoints

    @PostMapping
    public ResponseEntity<String> postCurso(@RequestBody Curso curso) {
        service.novoCurso(curso);
        return ResponseEntity.status(HttpStatus.CREATED).body("Curso criado");
    }

    @GetMapping
    public ResponseEntity<List<Curso>> getCurso() {
        List<Curso> cursos = service.listarCurso();
        return ResponseEntity.status(HttpStatus.OK).body(cursos);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<String> putCurso(@PathVariable int codigo, @RequestBody Curso curso) {
        curso.setCodigo(codigo);
        service.atualizarCurso(curso);
        return ResponseEntity.status(HttpStatus.OK).body("Curso atualizado com sucesso.");
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<String> deleteCurso(@PathVariable int codigo) {
        service.deletarCurso(codigo);
        return ResponseEntity.status(HttpStatus.OK).body("Curso com o codigo: " + codigo + " deletado com sucesso");
    }

}
