package com.ucc.LPII.dto;


import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

//Esto es lo que entra, lo que manda el front/cliente, o sea no manda el id
public record ReservaRequestDTO(
        @NotNull(message = "La reserva es obligatoria")
        @Future(message = "La reserva debe ser a futuro")
        LocalDateTime fechaReserva,
        @Min(value = 1, message = "Debe haber al menos una persona")
        @Max(value = 30, message = "Existe un max de 30 personas por reserva")
        int cantidadPersonas,
        @Size(max = 200, message = "Maximo de 200 caracteres")
        String observaciones,
        @NotNull(message= "El id usuario es obligatorio.")
        Long idUsuario) {
}
