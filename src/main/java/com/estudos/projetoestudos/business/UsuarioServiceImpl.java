package com.estudos.projetoestudos.business;

import com.estudos.projetoestudos.entity.Usuario;
import com.estudos.projetoestudos.exception.ConflictException;
import com.estudos.projetoestudos.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    /**
     * @param usuario
     * @return
     */
    @Override
    public Usuario salvarUsuario(Usuario usuario) {

        try {

            validadorEmail(usuario.getEmail());

            return usuarioRepository.save(usuario);
        } catch (ConflictException e) {
            throw new ConflictException("Email de usuario já cadastrado: ",e.getCause());
        }
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Usuario findUsuario(Long id) {
        return null;
    }

    /**
     * @return
     */
    @Override
    public List<Usuario> findAllUsuario() {
        return List.of();
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Usuario updateUsuario(Long id) {
        return null;
    }

    /**
     *
     */
    @Override
    public void deleteUsuario() {

    }

    /**
     * @param email
     * @return
     */
    @Override
    public boolean verificaEmailExistente(String email) {
        return usuarioRepository.existsByEmail(email);
    }

    public void validadorEmail(String email) {

        try {
            boolean existe = verificaEmailExistente(email);

            if (existe) {
                throw new ConflictException("Email de usuario já cadastrado: " + email);
            }
        } catch (ConflictException e) {


            throw new ConflictException("Email de usuario já cadastrado: " + email, e.getCause());
        }

    }
}
