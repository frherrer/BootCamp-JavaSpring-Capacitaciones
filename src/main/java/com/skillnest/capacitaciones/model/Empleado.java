package com.skillnest.capacitaciones.model;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Empleado {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;

    @OneToMany(mappedBy = "empleado")
    private List<Inscripcion> inscripciones;

    public Empleado(){}
    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}
    public String getNombre(){return nombre;}
    public void setNombre(String nombre){this.nombre=nombre;}
    public String getEmail(){return email;}
    public void setEmail(String email){this.email=email;}
}
