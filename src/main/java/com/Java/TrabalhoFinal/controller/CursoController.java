package com.Java.TrabalhoFinal.controller;

import com.Java.TrabalhoFinal.model.Curso;
import com.Java.TrabalhoFinal.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/curso")
public class CursoController {
    @Autowired

    private CursoService service;

    @GetMapping()
    public ResponseEntity<List<Curso>> listaCursos(){
        return ResponseEntity.status(HttpStatus.OK).body(service.listaCursos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Curso>> buscaCursoId(@PathVariable(value = "id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscaCursoId(id));
    }

    @PostMapping()
    public ResponseEntity<Curso> gravaCurso(@RequestBody Curso curso){
        return ResponseEntity.status(HttpStatus.OK).body(service.gravaCurso(curso));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> alteraCurso(@RequestBody Curso curso, @PathVariable(value = "id") Long id){
        Optional<Curso> cursoExiste = service.buscaCursoId(id);

        if(cursoExiste.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body("Não encontrado!");
        }

        Curso newCurso = cursoExiste.get();
        newCurso.setCurso(curso.getCurso());
        newCurso.setAluno(curso.getAluno());

        return ResponseEntity.status(HttpStatus.OK).body(service.gravaCurso(newCurso));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCurso(@PathVariable(value = "id") Long id){
        Optional<Curso> cursoExiste = service.buscaCursoId(id);

        if (cursoExiste.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body("Não encontrado");
        }

        service.deleteCurso(cursoExiste);

        return ResponseEntity.status(HttpStatus.OK).body("Deletado com sucesso");

    }
}
