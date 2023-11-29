package com.Java.TrabalhoFinal.controller;

import com.Java.TrabalhoFinal.model.Disciplina;
import com.Java.TrabalhoFinal.service.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/disciplina")
public class DisciplinaController {
    @Autowired

    private DisciplinaService service;

    @GetMapping()
    public ResponseEntity<List<Disciplina>> listaDisciplinas(){
        return ResponseEntity.status(HttpStatus.OK).body(service.listaDisciplinas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Disciplina>> buscaDisciplinaId(@PathVariable(value = "id")Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscaDisciplinaId(id));
    }
    @PostMapping()
    public ResponseEntity<Disciplina> gravaDisciplina(@RequestBody Disciplina disciplina){
        return ResponseEntity.status(HttpStatus.OK).body(service.gravaDisciplina(disciplina));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> alteraDisciplina(@RequestBody Disciplina disciplina, @PathVariable(value = "id") Long id){
        Optional<Disciplina> disciplinaExiste = service.buscaDisciplinaId(id);

        if(disciplinaExiste.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body("Não encontrado");
        }

        Disciplina newDisciplina = disciplinaExiste.get();
        newDisciplina.setDisciplina(disciplina.getDisciplina());
        newDisciplina.setNota(disciplina.getNota());

        return ResponseEntity.status(HttpStatus.OK).body(service.gravaDisciplina(newDisciplina));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteDisciplina(@PathVariable(value = "id") Long id){
        Optional<Disciplina> disciplinaExiste = service.buscaDisciplinaId(id);

        if(disciplinaExiste.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body("Não encontrado");
        }
        service.deleteDisciplina(disciplinaExiste);
        return ResponseEntity.status(HttpStatus.OK).body("Deletado com sucesso");
    }
}
