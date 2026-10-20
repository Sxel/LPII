package com.ucc.LPII.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "usuarios") // opcional
// lombok
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @Column(nullable = false, unique = true)
    private String correo;
    private int edad;
    @Column(nullable = false)
    private String contrasena;
    // Getters y setters
    // Constructor vacio/conargumento

    //Authenticacion y Authorizacion

    // LOGIN - ACCESO AL BACKEND
}
