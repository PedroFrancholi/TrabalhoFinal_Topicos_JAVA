package com.Java.TrabalhoFinal.controller;

import com.Java.TrabalhoFinal.model.Disciplina;
import com.Java.TrabalhoFinal.service.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/disciplina")
public class DisciplinaController {
    @Autowired

    private DisciplinaService service;

    @GetMapping()
    public ResponseEntity<List<Disciplina>> listaDisciplinas(){
        return ResponseEntity.status(HttpStatus.OK).body(service.listaDisciplinas());
    }
}
