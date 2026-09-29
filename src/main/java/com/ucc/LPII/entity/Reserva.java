package com.ucc.LPII.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
// lombok
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idUsuario; //En la proxima clase veremos como relacionar las dos tablas
    private LocalDateTime fechaReserva; // fecha + hora de la reserva
    private int cantidadPersonas;
    private String observaciones; //Opcional - por ej: 5 adultos y un niño/bebe
}
