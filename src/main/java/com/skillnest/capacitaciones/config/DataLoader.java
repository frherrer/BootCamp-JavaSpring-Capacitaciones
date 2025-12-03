package com.skillnest.capacitaciones.config;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.skillnest.capacitaciones.model.*;
import com.skillnest.capacitaciones.repository.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.time.LocalDateTime;
import java.util.Set;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner initData(UsuarioRepository usuarioRepo, InstructorRepository instrRepo, CursoRepository cursoRepo, EmpleadoRepository empRepo){
        return args -> {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            if(usuarioRepo.findByUsername("admin").isEmpty()){
                Usuario admin = new Usuario();
                admin.setUsername("admin");
                admin.setPassword(encoder.encode("admin"));
                admin.setNombre("Administrador");
                admin.setRoles(Set.of(Role.ROLE_ADMIN));
                usuarioRepo.save(admin);
            }
            if(usuarioRepo.findByUsername("empleado").isEmpty()){
                Usuario empUser = new Usuario();
                empUser.setUsername("empleado");
                empUser.setPassword(encoder.encode("empleado"));
                empUser.setNombre("Empleado Ejemplo");
                empUser.setRoles(Set.of(Role.ROLE_EMPLEADO));
                usuarioRepo.save(empUser);
            }

            Instructor i1 = new Instructor(); i1.setNombre("María Pérez"); i1.setEmail("maria@empresa.com"); instrRepo.save(i1);
            Instructor i2 = new Instructor(); i2.setNombre("Juan Gómez"); i2.setEmail("juan@empresa.com"); instrRepo.save(i2);

            Empleado e1 = new Empleado(); e1.setNombre("Carlos Ruiz"); e1.setEmail("carlos@empresa.com"); empRepo.save(e1);
            Empleado e2 = new Empleado(); e2.setNombre("Ana Torres"); e2.setEmail("ana@empresa.com"); empRepo.save(e2);

            Curso c1 = new Curso(); c1.setTitulo("Seguridad en el trabajo"); c1.setDescripcion("Buenas prácticas"); c1.setFechaInicio(LocalDateTime.now().plusDays(3)); c1.setFechaFin(LocalDateTime.now().plusDays(4)); c1.setCupo(20); c1.setInstructor(i1); cursoRepo.save(c1);
            Curso c2 = new Curso(); c2.setTitulo("Atención al cliente"); c2.setDescripcion("Taller práctico"); c2.setFechaInicio(LocalDateTime.now().plusDays(7)); c2.setFechaFin(LocalDateTime.now().plusDays(8)); c2.setCupo(15); c2.setInstructor(i2); cursoRepo.save(c2);
        };
    }
}
