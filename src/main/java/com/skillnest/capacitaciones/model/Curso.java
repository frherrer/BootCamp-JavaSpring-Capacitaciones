package com.skillnest.capacitaciones.model;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Curso {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descripcion;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private Integer cupo;

    @ManyToOne
    private Instructor instructor;

    @OneToMany(mappedBy = "curso")
    private List<Inscripcion> inscripciones;

    public Curso(){}
    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}
    public String getTitulo(){return titulo;}
    public void setTitulo(String titulo){this.titulo=titulo;}
    public String getDescripcion(){return descripcion;}
    public void setDescripcion(String descripcion){this.descripcion=descripcion;}
    public LocalDateTime getFechaInicio(){return fechaInicio;}
    public void setFechaInicio(LocalDateTime fechaInicio){this.fechaInicio=fechaInicio;}
    public LocalDateTime getFechaFin(){return fechaFin;}
    public void setFechaFin(LocalDateTime fechaFin){this.fechaFin=fechaFin;}
    public Integer getCupo(){return cupo;}
    public void setCupo(Integer cupo){this.cupo=cupo;}
    public Instructor getInstructor(){return instructor;}
    public void setInstructor(Instructor instructor){this.instructor=instructor;}
}
