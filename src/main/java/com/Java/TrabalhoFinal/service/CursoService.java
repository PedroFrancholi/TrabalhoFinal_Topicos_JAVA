package com.Java.TrabalhoFinal.service;

import com.Java.TrabalhoFinal.model.Curso;
import com.Java.TrabalhoFinal.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {
    @Autowired

    private CursoRepository repository;

    public List<Curso> listaCursos(){
        return repository.findAll();
    }
}
