package com.example.demoroles.controller;

import com.example.demoroles.model.Usuario;
import com.example.demoroles.model.enums.RolEnum;
import com.example.demoroles.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/{id}")
    public ResponseEntity<?> guardarUsuario(@Valid @RequestBody Usuario usuario, BindingResult result, @PathVariable Long id){
        List<String> mensajesError = new ArrayList<>();
        for(ObjectError error: result.getAllErrors()){
            mensajesError.add(error.getDefaultMessage());
        }

        if (result.hasErrors()){
            return  new ResponseEntity<>(mensajesError, HttpStatus.BAD_REQUEST);
        }

        Usuario usuarioEncontrado = usuarioService.buscarUsuario(id);

        if (usuarioEncontrado == null){
            return new ResponseEntity<>("El usuario especificado no existe", HttpStatus.NO_CONTENT);
        }

        if (usuarioEncontrado.getRol().equals(RolEnum.ADMIN)){
            Usuario usuarioGuardado = usuarioService.guardarUsuario(usuario);
            return new ResponseEntity<>(usuarioGuardado, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("El usuario especificado no existe", HttpStatus.NO_CONTENT);
        }
    }
}
