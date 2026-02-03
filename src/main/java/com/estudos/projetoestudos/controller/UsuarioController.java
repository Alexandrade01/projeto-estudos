package com.estudos.projetoestudos.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.estudos.projetoestudos.business.UsuarioService;
import com.estudos.projetoestudos.entity.Usuario;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping(value = "/usuario/")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping("save/")
    public ResponseEntity<Usuario> salvarUsuario(@RequestBody Usuario user){

        return ResponseEntity.ok(usuarioService.salvarUsuario(user));

    }

    @GetMapping("findBy/{id}")
    public ResponseEntity<Usuario> encontrarUsuarioPorId(@PathVariable Long id){

        Usuario user = usuarioService.findUsuario(id).get();

        return ResponseEntity.ok(user);


    }

    @GetMapping("findAll/")
    public ResponseEntity<List<Usuario>> encontrarTodosUsuarios(){

        List<Usuario> list = usuarioService.findAllUsuario();

        return ResponseEntity.ok(list);

    }

    @PostMapping("update/")
    public ResponseEntity<Usuario> updateUsuario(@RequestBody Usuario user){

        return ResponseEntity.ok(usuarioService.updateUsuario(user));

    }

    @DeleteMapping("deleteById/{id}")
    public ResponseEntity<String> deleteByIdUsuario(@PathVariable Long id){

        usuarioService.deleteByIdUsuario(id);

        return ResponseEntity.ok("ok");

    }
}
