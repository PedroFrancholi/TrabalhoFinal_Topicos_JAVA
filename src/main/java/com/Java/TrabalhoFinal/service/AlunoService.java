package com.Java.TrabalhoFinal.service;

import com.Java.TrabalhoFinal.model.Aluno;
import com.Java.TrabalhoFinal.model.Curso;
import com.Java.TrabalhoFinal.model.Disciplina;
import com.Java.TrabalhoFinal.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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
    public ResponseEntity<Object> gravaAluno(Aluno aluno) {
        if (!aluno.getCursos().isEmpty()) {
            for (Curso curso : aluno.getCursos()) {

                curso.setAluno(aluno);

                List<Disciplina> disciplinas = curso.getDisciplinas();
                if (!disciplinas.isEmpty()) {
                    for (Disciplina disciplina : disciplinas) {
                        BigDecimal nota = disciplina.getNota();
                        if(nota != null) {
                            if (nota.compareTo(BigDecimal.ZERO) < 0) {
                                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("NOTA (" + nota + ") INVÁLIDA, MENOR QUE 0");
                            } else if (nota.compareTo(new BigDecimal(10)) > 0) {
                                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("NOTA (" + nota + ") INVÁLIDA, MAIOR QUE 10");
                            }
                        }
                        disciplina.setCurso(curso);
                    }
                }
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(repository.save(aluno));
    }
}
