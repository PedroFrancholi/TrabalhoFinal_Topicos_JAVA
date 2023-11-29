package com.Java.TrabalhoFinal.service;

import com.Java.TrabalhoFinal.model.Disciplina;
import com.Java.TrabalhoFinal.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplinaService {
    @Autowired

    private DisciplinaRepository repository;

    public List<Disciplina> listaDisciplinas(){
        return repository.findAll();
    }

    public Optional<Disciplina> buscaDisciplinaId(Long id){
        return repository.findById(id);
    }
    public Disciplina gravaDisciplina(Disciplina disciplina){
        return repository.save(disciplina);
    }

    public void deleteDisciplina(Optional<Disciplina> disciplina){
        repository.delete(disciplina.get());
    }
}
