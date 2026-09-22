package com.ucc.LPII.service;

import com.ucc.LPII.dto.ReservaResponseDTO;
import com.ucc.LPII.entity.Reserva;
import com.ucc.LPII.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {
    @Autowired
    ReservaRepository reservaRepository;

    public List<Reserva> obtenerTodasLasReservas() {
        return reservaRepository.findAll();
    }

    public Reserva obtenerUnaReserva(Long id) {
        Optional<Reserva> reservaOpt = reservaRepository.findById(id);
        if(reservaOpt.isPresent()){
            return reservaOpt.get();
        }else {
            return null;
        }
    }

    public Reserva agregarReserva(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    public Reserva modificarReserva(Long id, Reserva reserva){
        Optional<Reserva> reservaOpt = reservaRepository.findById(id);
        if(reservaOpt.isPresent()){
            Reserva reservaModificada = reservaOpt.get();
            reservaModificada.setCantidadPersonas(reserva.getCantidadPersonas());
            reservaModificada.setFechaReserva(reserva.getFechaReserva());
            reservaModificada.setIdUsuario(reserva.getIdUsuario());
            reservaModificada.setObservaciones(reserva.getObservaciones());
            return reservaRepository.save(reservaModificada);

        }else {
            return null;
        }
    }

    public void borrarUnaReserva(Long id) {
        reservaRepository.deleteById(id);
    }


    // -------MAPPERS ( A MANO PARA QUE VEAN QUE NO HAY MAGIA ) ---------

    private ReservaResponseDTO toDTO (Reserva reserva){
        return new ReservaResponseDTO(
                reserva.getId(),
                reserva.getFechaReserva(),
                reserva.getCantidadPersonas(),
                reserva.getObservaciones(),
                reserva.getIdUsuario()
        );
    }

    private Reserva toEntity(ReservaResponseDTO reservaDTO){
        Reserva reserva = new Reserva ();

        reserva.setIdUsuario(reservaDTO.idUsuario());
        reserva.setFechaReserva(reservaDTO.fechaReserva());
        reserva.setCantidadPersonas(reservaDTO.cantidadPersonas());
        reserva.setObservaciones(reservaDTO.observaciones());
        return reserva;
    }
}
