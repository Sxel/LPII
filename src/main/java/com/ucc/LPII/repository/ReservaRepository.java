package com.ucc.LPII.repository;

import com.ucc.LPII.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    // Select * from reserva where id_usuario= {idUsuario}
    List<Reserva> findByUsuario_Id(Long idUsuario);
}
