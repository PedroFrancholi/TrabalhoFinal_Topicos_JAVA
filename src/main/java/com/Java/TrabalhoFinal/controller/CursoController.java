package com.Java.TrabalhoFinal.controller;

import com.Java.TrabalhoFinal.model.Curso;
import com.Java.TrabalhoFinal.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<Optional<Curso>> buscaCursoId(@PathVariable(value = "id") Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscaCursoId(id));
    }
}
