package com.Java.TrabalhoFinal.service;

import com.Java.TrabalhoFinal.model.Curso;
import com.Java.TrabalhoFinal.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {
    @Autowired

    private CursoRepository repository;

    public Curso gravaCurso(Curso curso){
        return repository.save(curso);
    }
    public List<Curso> listaCursos(){
        return repository.findAll();
    }

    public Optional<Curso> buscaCursoId(Long id){
        return repository.findById(id);
    }

    public void deleteCurso(Optional<Curso> curso){
        repository.delete(curso.get());
    }

}
