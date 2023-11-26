package com.Java.TrabalhoFinal.service;

import com.Java.TrabalhoFinal.model.Aluno;
import com.Java.TrabalhoFinal.model.Curso;
import com.Java.TrabalhoFinal.model.Disciplina;
import com.Java.TrabalhoFinal.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository repository;

    //GET
    public List<Aluno> listaAlunos(){
        return repository.findAll();
    }
    //GET
    public Optional<Aluno> buscaAlunoId(Long id){
        return repository.findById(id);
    }
    //POST
    public Aluno gravaAluno(Aluno aluno) {
        if (!aluno.getCursos().isEmpty()) {
            for (Curso curso : aluno.getCursos()) {

                curso.setAluno(aluno);

                List<Disciplina> disciplinas = curso.getDisciplinas();
                if(!disciplinas.isEmpty()){
                    for (Disciplina disciplina : disciplinas){
                        disciplina.setCurso(curso);
                    }
                }
            }
        }
        return repository.save(aluno);
    }
}
