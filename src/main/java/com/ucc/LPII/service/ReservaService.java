package com.ucc.LPII.service;

import com.ucc.LPII.dto.ReservaRequestDTO;
import com.ucc.LPII.dto.ReservaResponseDTO;
import com.ucc.LPII.entity.Reserva;
import com.ucc.LPII.mapper.ReservaMapper;
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

    private final ReservaMapper reservaMapper;

    public ReservaService(ReservaMapper reservaMapper) {
        this.reservaMapper = reservaMapper;
    }

    public List<ReservaResponseDTO> obtenerTodasLasReservas() {
        return reservaRepository.findAll()
                .stream()
                .map(reservaMapper::entityToDTO)
                .toList();
    }

    public ReservaResponseDTO obtenerUnaReserva(Long id) {
        Optional<Reserva> reservaOpt = reservaRepository.findById(id);
        if(reservaOpt.isPresent()){
            Reserva reserva = reservaOpt.get();
            return reservaMapper.entityToDTO(reserva);
        }else {
            return null;
        }
    }

    public ReservaResponseDTO agregarReserva(ReservaRequestDTO dto) {
        Reserva reserva = reservaMapper.dtoToEntity(dto);
        Reserva reservaGuardada = reservaRepository.save(reserva);
        return reservaMapper.entityToDTO(reservaGuardada);
    }

    public ReservaResponseDTO modificarReserva(Long id, ReservaRequestDTO dto){
        Optional<Reserva> reservaOpt = reservaRepository.findById(id);
        if(reservaOpt.isPresent()){
            Reserva reservaModificada = reservaOpt.get();
            reservaModificada.setCantidadPersonas(dto.cantidadPersonas());
            reservaModificada.setFechaReserva(dto.fechaReserva());
            reservaModificada.setIdUsuario(dto.idUsuario());
            reservaModificada.setObservaciones(dto.observaciones());

            Reserva reservaGuardada = reservaRepository.save(reservaModificada);
            return reservaMapper.entityToDTO(reservaGuardada);
        }else {
            return null;
        }
    }

    public void borrarUnaReserva(Long id) {
        reservaRepository.deleteById(id);
    }


}
