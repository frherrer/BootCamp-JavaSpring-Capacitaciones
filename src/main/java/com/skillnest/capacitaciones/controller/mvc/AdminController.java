package com.skillnest.capacitaciones.controller.mvc;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.skillnest.capacitaciones.repository.CursoRepository;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final CursoRepository cursoRepo;
    public AdminController(CursoRepository cursoRepo){ this.cursoRepo = cursoRepo; }

    @GetMapping("/cursos")
    public String gestionarCursos(Model model){
        model.addAttribute("cursos", cursoRepo.findAll());
        return "admin/cursos";
    }
}
