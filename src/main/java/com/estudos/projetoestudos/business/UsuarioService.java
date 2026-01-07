package com.estudos.projetoestudos.business;

import com.estudos.projetoestudos.entity.Usuario;
import com.estudos.projetoestudos.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UsuarioService {

    public Usuario salvarUsuario(Usuario usuario);

    public Usuario findUsuario(Long id);

    public List<Usuario> findAllUsuario();

    public Usuario updateUsuario(Long id);

    public void deleteUsuario();

    public boolean verificaEmailExistente(String email);


}
