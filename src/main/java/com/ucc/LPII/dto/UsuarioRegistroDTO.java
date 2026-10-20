package com.ucc.LPII.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

//Aca es donde entra cuando se hace un register, es el unico dto que maneja contraseña
public record UsuarioRegistroDTO(

    @NotBlank(message = "El nombre es obligatorio")
    String nombre,

    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "El correo debe ser válido")
    String correo,

    @Min(value = 18, message = "La edad debe ser mayor o igual a 18")
    int edad,

    @NotBlank(message = "La contraseña es obligatoria")
    @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres")
    String contrasena

) {
}