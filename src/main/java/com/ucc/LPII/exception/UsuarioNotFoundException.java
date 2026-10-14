package com.ucc.LPII.exception;

public class UsuarioNotFoundException extends RuntimeException {
    public UsuarioNotFoundException(Long id) {
        super(id == null ? "Debe indicar un usuario para la reserva" :
                "No existe el usuario con id " + id);
    }
}
