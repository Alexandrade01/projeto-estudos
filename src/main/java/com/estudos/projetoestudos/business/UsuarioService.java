package com.estudos.projetoestudos.business;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.estudos.projetoestudos.entity.Usuario;

@Service
public interface UsuarioService {

	public Usuario salvarUsuario(Usuario usuario);

	public Optional<Usuario> findUsuario(Long id);

	public List<Usuario> findAllUsuario();

	public Usuario updateUsuario(Usuario usuario);

	public void deleteByIdUsuario(Long id);

	public boolean verificaEmailExistente(String email);

	Usuario buscaUsuarioPorEmail(String email);

	void deleteByEmail(String email);

}
