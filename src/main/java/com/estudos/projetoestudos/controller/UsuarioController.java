package com.estudos.projetoestudos.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.estudos.projetoestudos.business.UsuarioService;
import com.estudos.projetoestudos.dto.UsuarioDTO;
import com.estudos.projetoestudos.entity.Usuario;
import com.estudos.projetoestudos.infrastructure.security.JwtUtil;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/usuario")
@RequiredArgsConstructor
public class UsuarioController {

	private final UsuarioService usuarioService;
	private final AuthenticationManager authenticationManager;
	private final JwtUtil jwtUtil;

	@PostMapping
	public ResponseEntity<Usuario> salvarUsuario(@RequestBody Usuario user) {

		return ResponseEntity.ok(usuarioService.salvarUsuario(user));

	}

	@GetMapping("findBy/{id}")
	public ResponseEntity<Usuario> encontrarUsuarioPorId(@PathVariable Long id) {

		Usuario user = usuarioService.findUsuario(id).get();

		return ResponseEntity.ok(user);

	}

	@GetMapping("findAll")
	public ResponseEntity<List<Usuario>> encontrarTodosUsuarios() {

		List<Usuario> list = usuarioService.findAllUsuario();

		return ResponseEntity.ok(list);

	}

	@PostMapping("update")
	public ResponseEntity<Usuario> updateUsuario(@RequestBody Usuario user) {

		return ResponseEntity.ok(usuarioService.updateUsuario(user));

	}

	@DeleteMapping("deleteById/{id}")
	public ResponseEntity<String> deleteByIdUsuario(@PathVariable Long id) {

		usuarioService.deleteByIdUsuario(id);

		return ResponseEntity.ok("ok");

	}

	@PostMapping("login")
	public String login(@RequestBody UsuarioDTO usuarioDTO) {

		Authentication authentication = authenticationManager.authenticate(

				new UsernamePasswordAuthenticationToken(usuarioDTO.getEmail(), usuarioDTO.getSenha())

		);

		return "Bearer: " + jwtUtil.generateToken(authentication.getName());

	}

	@GetMapping("getByEmail")
	public ResponseEntity<Usuario> buscaUsuarioPorEmail(@RequestParam String email) {

		return ResponseEntity.ok(usuarioService.buscaUsuarioPorEmail(email));

	}
	
	@DeleteMapping("deleteByEmail/{email}")
	public ResponseEntity<String> deleteByEmail(@PathVariable String email) {

		usuarioService.deleteByEmail(email);

		return ResponseEntity.ok().body("Usuario com email " + email + " deletado !");

	}
}
