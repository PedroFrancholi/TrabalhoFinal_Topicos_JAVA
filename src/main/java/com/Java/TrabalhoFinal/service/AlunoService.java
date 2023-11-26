package com.Java.TrabalhoFinal.service;

import com.Java.TrabalhoFinal.model.Aluno;
import com.Java.TrabalhoFinal.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository repository;

    public List<Aluno> listaAlunos(){
        return repository.findAll();
    }
}
