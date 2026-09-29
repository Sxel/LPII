package com.ucc.LPII.dto;


import java.time.LocalDateTime;

//Esto es lo que entra, lo que manda el front/cliente, o sea no manda el id
public record ReservaRequestDTO(LocalDateTime fechaReserva,
                                int cantidadPersonas,
                                String observaciones,
                                Long idUsuario) {
}
