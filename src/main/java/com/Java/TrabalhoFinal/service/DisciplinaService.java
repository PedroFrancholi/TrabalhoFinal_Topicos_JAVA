package com.Java.TrabalhoFinal.service;

import com.Java.TrabalhoFinal.model.Disciplina;
import com.Java.TrabalhoFinal.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplinaService {
    @Autowired

    private DisciplinaRepository repository;

    public List<Disciplina> listaDisciplinas(){
        return repository.findAll();
    }
}
