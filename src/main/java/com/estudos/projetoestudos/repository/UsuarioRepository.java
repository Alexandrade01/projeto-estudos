package com.estudos.projetoestudos.repository;

import com.estudos.projetoestudos.entity.Usuario;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    boolean existsByEmail(String email);
}
