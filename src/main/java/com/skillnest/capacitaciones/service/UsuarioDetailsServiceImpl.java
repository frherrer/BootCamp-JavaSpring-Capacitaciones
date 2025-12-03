package com.skillnest.capacitaciones.service;

import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import com.skillnest.capacitaciones.repository.UsuarioRepository;
import com.skillnest.capacitaciones.model.Usuario;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.util.stream.Collectors;

@Service
public class UsuarioDetailsServiceImpl implements UserDetailsService {
    private final UsuarioRepository repo;
    public UsuarioDetailsServiceImpl(UsuarioRepository repo){ this.repo = repo; }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario u = repo.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("No existe usuario"));
        return new org.springframework.security.core.userdetails.User(
            u.getUsername(),
            u.getPassword(),
            u.getRoles().stream().map(r -> new SimpleGrantedAuthority(r.name())).collect(Collectors.toList())
        );
    }
}
