package com.Java.TrabalhoFinal.controller;

import com.Java.TrabalhoFinal.model.Aluno;
import com.Java.TrabalhoFinal.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
    @Autowired

    private AlunoService service;

    @GetMapping()
    public ResponseEntity<List<Aluno>> listaAlunos(){
        return ResponseEntity.status(HttpStatus.OK).body(service.listaAlunos());
    }
}
