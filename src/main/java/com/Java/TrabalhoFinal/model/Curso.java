package com.Java.TrabalhoFinal.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.NotFound;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Curso")
public class Curso implements Serializable {

    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "CURSO", nullable = false)
    private String curso;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Aluno aluno;

    @OneToMany(mappedBy = "curso")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @NotNull
    private List<Disciplina> disciplinas;
    public Curso() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }
}