package com.Java.TrabalhoFinal.repository;

import com.Java.TrabalhoFinal.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long>{
}
