package com.estudos.projetoestudos.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudos.projetoestudos.business.UsuarioService;
import com.estudos.projetoestudos.entity.Usuario;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> salvarUsuario(@RequestBody Usuario user){

        return ResponseEntity.ok(usuarioService.salvarUsuario(user));

    }
}
