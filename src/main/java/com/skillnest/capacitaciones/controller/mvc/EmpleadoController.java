package com.skillnest.capacitaciones.controller.mvc;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.skillnest.capacitaciones.repository.CursoRepository;

@Controller
@RequestMapping("/empleado")
public class EmpleadoController {
    private final CursoRepository cursoRepo;
    public EmpleadoController(CursoRepository cursoRepo){ this.cursoRepo = cursoRepo; }

    @GetMapping("/cursos")
    public String verCursos(Model model){
        model.addAttribute("cursos", cursoRepo.findAll());
        return "empleado/cursos";
    }
}
