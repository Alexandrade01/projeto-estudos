package com.estudos.projetoestudos.business;

import com.estudos.projetoestudos.entity.Usuario;
import com.estudos.projetoestudos.exception.ConflictException;
import com.estudos.projetoestudos.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
            throw new ConflictException("Email de usuario já cadastrado: ", e.getCause());
        }
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Optional<Usuario> findUsuario(Long id) {

        try {

            Optional<Usuario> user = usuarioRepository.findById(id);

            if (user.isEmpty()) {
                throw new ConflictException("Usuario não existe: " + id);
            }

            return user;


        } catch (ConflictException e) {
            throw new ConflictException("Usuario não existe: " + id, e.getCause());
        }

    }

    /**
     * @return
     */
    @Override
    public List<Usuario> findAllUsuario() {
        return usuarioRepository.findAll();
    }

    /**
     * @return
     */
    @Override
    public Usuario updateUsuario(Usuario usuario) {

        return usuarioRepository.save(usuario);
    }

    /**
     * @param id
     */
    @Override
    public void deleteByIdUsuario(Long id) {

        usuarioRepository.deleteById(id);
    }

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
