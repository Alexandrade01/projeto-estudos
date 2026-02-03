package com.estudos.projetoestudos.business;

import com.estudos.projetoestudos.entity.Usuario;
import com.estudos.projetoestudos.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UsuarioService {

    public Usuario salvarUsuario(Usuario usuario);

    public Optional<Usuario> findUsuario(Long id);

    public List<Usuario> findAllUsuario();

    public Usuario updateUsuario(Usuario usuario);

    public void deleteByIdUsuario(Long id);

    public boolean verificaEmailExistente(String email);


}
