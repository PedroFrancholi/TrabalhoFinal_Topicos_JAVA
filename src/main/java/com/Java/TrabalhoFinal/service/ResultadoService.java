package com.Java.TrabalhoFinal.service;

import com.Java.TrabalhoFinal.model.Aluno;
import com.Java.TrabalhoFinal.model.Curso;
import com.Java.TrabalhoFinal.model.Disciplina;
import com.Java.TrabalhoFinal.model.Resultado;
import com.Java.TrabalhoFinal.repository.AlunoRepository;
import com.Java.TrabalhoFinal.repository.CursoRepository;
import com.Java.TrabalhoFinal.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ResultadoService {
    @Autowired
    private AlunoRepository alunoRepository;
    private CursoRepository cursoRepository;
    private DisciplinaRepository disciplinaRepository;


    public List<Resultado> calcularResultado(){
        List<Aluno> alunos = alunoRepository.findAll();
        List<Resultado> resultados = new ArrayList<>();

        for (Aluno aluno : alunos){
            for (Curso curso : aluno.getCursos()){
                for (Disciplina disciplina : curso.getDisciplinas()){
                    Resultado resultado = new Resultado();
                    resultado.setNomeAluno(aluno.getNome());
                    resultado.setNomeCurso(curso.getCurso());
                    resultado.setNomeDisciplina(disciplina.getDisciplina());
                    resultado.setNota(disciplina.getNota());

                    if(resultado.getNota()!=null) {
                        if(resultado.getNota().compareTo(new BigDecimal(0)) < 0){
                            resultado.setStatus("NOTA INVÁLIDA, MENOR QUE ZERO");
                        }else if(resultado.getNota().compareTo(new BigDecimal(100)) > 0) {
                            resultado.setStatus("NOTA INVÁLIDA, MAIOR QUE 100");
                        }else if(resultado.getNota().compareTo(new BigDecimal(70)) >= 0){
                            resultado.setStatus("APROVADO");
                        }else if(resultado.getNota().compareTo(new BigDecimal(40)) >= 0){
                            resultado.setStatus("ESTÁ DE EXAME");
                        }else{
                            resultado.setStatus("REPROVADO");
                        }
                    }else{
                        resultado.setStatus("EM ABERTO");
                    }

                    resultados.add(resultado);
                }
            }
        }

        return resultados;
    }
}
