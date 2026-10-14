package com.ucc.LPII.mapper;

import com.ucc.LPII.dto.ReservaRequestDTO;
import com.ucc.LPII.dto.ReservaResponseDTO;
import com.ucc.LPII.entity.Reserva;
import com.ucc.LPII.entity.Usuario;
import org.springframework.stereotype.Component;

@Component
public class ReservaMapper {

    private final UsuarioMapper usuarioMapper;
    public ReservaMapper(UsuarioMapper usuarioMapper) {
        this.usuarioMapper = usuarioMapper;
    }

    public ReservaResponseDTO entityToDTO (Reserva reserva){
        return new ReservaResponseDTO(
                reserva.getId(),
                reserva.getFechaReserva(),
                reserva.getCantidadPersonas(),
                reserva.getObservaciones(),
                usuarioMapper.entityToDTO(reserva.getUsuario())
        );
    }

    public Reserva dtoToEntity(ReservaRequestDTO reservaDTO, Usuario usuario){
        Reserva reserva = new Reserva ();
        reserva.setUsuario(usuario);
        reserva.setFechaReserva(reservaDTO.fechaReserva());
        reserva.setCantidadPersonas(reservaDTO.cantidadPersonas());
        reserva.setObservaciones(reservaDTO.observaciones());
        return reserva;
        // input - entrada - request - peticion
        // output - salida - response - respuesta
    }
}
