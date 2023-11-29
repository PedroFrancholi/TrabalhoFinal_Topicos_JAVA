package com.Java.TrabalhoFinal.controller;

import com.Java.TrabalhoFinal.model.Aluno;
import com.Java.TrabalhoFinal.model.Resultado;
import com.Java.TrabalhoFinal.service.ResultadoService;
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
@RequestMapping("/resultado")
public class ResultadoController {
    @Autowired
    private ResultadoService service;

    @GetMapping()
    public List<Resultado> calculaNota(){
        return service.calcularResultado();
    }

    @GetMapping("/{id}")
    public List<Resultado> calculaNotaId(@PathVariable(value = "id") Long id){
        return service.calculaResultadoId(id);
    }

}
