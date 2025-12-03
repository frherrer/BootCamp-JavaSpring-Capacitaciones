package com.skillnest.capacitaciones.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.skillnest.capacitaciones.model.Instructor;
public interface InstructorRepository extends JpaRepository<Instructor, Long> {}
