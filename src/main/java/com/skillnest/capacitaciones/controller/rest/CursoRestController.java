package com.skillnest.capacitaciones.controller.rest;
import org.springframework.web.bind.annotation.*;
import com.skillnest.capacitaciones.repository.CursoRepository;
import com.skillnest.capacitaciones.model.Curso;
import java.util.List;

@RestController
@RequestMapping("/api/cursos")
@CrossOrigin(origins = "*")
public class CursoRestController {
    private final CursoRepository cursoRepo;
    public CursoRestController(CursoRepository cursoRepo){ this.cursoRepo = cursoRepo; }

    @GetMapping
    public List<Curso> listar(){ return cursoRepo.findAll(); }

    @GetMapping("/{id}")
    public Curso getOne(@PathVariable Long id){ return cursoRepo.findById(id).orElseThrow(); }
}
