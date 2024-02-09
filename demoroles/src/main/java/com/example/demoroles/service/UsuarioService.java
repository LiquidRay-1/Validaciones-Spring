package com.example.demoroles.service;

import com.example.demoroles.model.Usuario;
import com.example.demoroles.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario guardarUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Usuario buscarUsuario(Long id){
        return usuarioRepository.findById(id).orElse(null);
    }
}
