package com.skillnest.capacitaciones.controller.rest;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import com.skillnest.capacitaciones.repository.*;
import com.skillnest.capacitaciones.model.*;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/inscripciones")
@CrossOrigin(origins = "*")
public class InscripcionRestController {
    private final InscripcionRepository insRepo;
    private final CursoRepository cursoRepo;
    private final EmpleadoRepository empRepo;

    public InscripcionRestController(InscripcionRepository insRepo, CursoRepository cursoRepo, EmpleadoRepository empRepo){
        this.insRepo = insRepo; this.cursoRepo = cursoRepo; this.empRepo = empRepo;
    }

    @PostMapping
    public ResponseEntity<?> inscribir(@RequestBody InscripcionRequest req){
        Curso c = cursoRepo.findById(req.getCursoId()).orElseThrow();
        Empleado e = empRepo.findById(req.getEmpleadoId()).orElseThrow();
        Inscripcion i = new Inscripcion();
        i.setCurso(c); i.setEmpleado(e); i.setFechaInscripcion(LocalDateTime.now());
        insRepo.save(i);
        return ResponseEntity.ok(i);
    }

    public static class InscripcionRequest {
        private Long cursoId;
        private Long empleadoId;
        public Long getCursoId(){return cursoId;}
        public void setCursoId(Long cursoId){this.cursoId=cursoId;}
        public Long getEmpleadoId(){return empleadoId;}
        public void setEmpleadoId(Long empleadoId){this.empleadoId=empleadoId;}
    }
}
