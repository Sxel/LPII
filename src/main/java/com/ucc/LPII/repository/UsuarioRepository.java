package com.ucc.LPII.repository;

import com.ucc.LPII.entity.Reserva;
import com.ucc.LPII.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> { }
