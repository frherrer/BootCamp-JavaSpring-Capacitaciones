package com.skillnest.capacitaciones.controller.rest;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import com.skillnest.capacitaciones.config.JwtUtils;
import com.skillnest.capacitaciones.repository.UsuarioRepository;
import com.skillnest.capacitaciones.model.Usuario;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthenticationManager authManager;
    private final JwtUtils jwtUtils;
    private final UsuarioRepository usuarioRepo;

    public AuthController(AuthenticationManager authManager, JwtUtils jwtUtils, UsuarioRepository usuarioRepo){
        this.authManager = authManager; this.jwtUtils = jwtUtils; this.usuarioRepo = usuarioRepo;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest req){
        Authentication auth = authManager.authenticate(new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword()));
        Usuario u = usuarioRepo.findByUsername(req.getUsername()).orElseThrow();
        var roles = u.getRoles().stream().map(r -> r.name()).collect(Collectors.toSet());
        String token = jwtUtils.generateToken(u.getUsername(), roles);
        return ResponseEntity.ok(new AuthResponse(token));
    }

    public static class AuthRequest { public String username; public String password; public String getUsername(){return username;} public String getPassword(){return password;} }
    public static class AuthResponse { public String token; public AuthResponse(String token){this.token = token;} public String getToken(){return token;} }
}
