package com.skillnest.capacitaciones.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.skillnest.capacitaciones.model.Curso;
public interface CursoRepository extends JpaRepository<Curso, Long> {}
