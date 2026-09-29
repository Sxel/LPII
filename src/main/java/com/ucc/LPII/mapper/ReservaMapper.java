package com.ucc.LPII.mapper;

import com.ucc.LPII.dto.ReservaRequestDTO;
import com.ucc.LPII.dto.ReservaResponseDTO;
import com.ucc.LPII.entity.Reserva;
import org.springframework.stereotype.Component;

@Component
public class ReservaMapper {

    public ReservaMapper() {
    }

    public ReservaResponseDTO entityToDTO (Reserva reserva){
        return new ReservaResponseDTO(
                reserva.getId(),
                reserva.getFechaReserva(),
                reserva.getCantidadPersonas(),
                reserva.getObservaciones(),
                reserva.getIdUsuario()
        );
    }

    public Reserva dtoToEntity(ReservaRequestDTO reservaDTO){
        Reserva reserva = new Reserva ();
        reserva.setIdUsuario(reservaDTO.idUsuario());
        reserva.setFechaReserva(reservaDTO.fechaReserva());
        reserva.setCantidadPersonas(reservaDTO.cantidadPersonas());
        reserva.setObservaciones(reservaDTO.observaciones());
        return reserva;
        // input - entrada - request - peticion
        // output - salida - response - respuesta
    }
}
