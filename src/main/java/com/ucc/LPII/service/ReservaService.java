package com.ucc.LPII.service;

import com.ucc.LPII.entity.Reserva;
import com.ucc.LPII.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            reservaModificada.setNombre(reserva.getNombre());
            reservaModificada.setEdad(reserva.getEdad());
            reservaModificada.setCorreo(reserva.getCorreo());
            return reservaRepository.save(reservaModificada);

        }else {
            return null;
        }
    }

    public void borrarUnaReserva(Long id) {
        reservaRepository.deleteById(id);
    }
}
