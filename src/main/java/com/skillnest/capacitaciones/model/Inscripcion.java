package com.skillnest.capacitaciones.model;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Inscripcion {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Curso curso;

    @ManyToOne
    private Empleado empleado;

    private LocalDateTime fechaInscripcion;

    public Inscripcion(){}
    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}
    public Curso getCurso(){return curso;}
    public void setCurso(Curso curso){this.curso=curso;}
    public Empleado getEmpleado(){return empleado;}
    public void setEmpleado(Empleado empleado){this.empleado=empleado;}
    public LocalDateTime getFechaInscripcion(){return fechaInscripcion;}
    public void setFechaInscripcion(LocalDateTime fechaInscripcion){this.fechaInscripcion=fechaInscripcion;}
}
