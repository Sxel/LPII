package com.ucc.LPII.dto;

import java.time.LocalDateTime;

public record ReservaResponseDTO(
        Long id,
        LocalDateTime fechaReserva,
        int cantidadPersonas,
        String observaciones,
        Long idUsuario
) {
}
