package com.skillnest.capacitaciones.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.skillnest.capacitaciones.model.Usuario;
import java.util.Optional;
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByUsername(String username);
}
