package com.skillnest.capacitaciones.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.skillnest.capacitaciones.model.Empleado;
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {}
