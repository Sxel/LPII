package com.ucc.LPII.exception;

public class ReservaNotFoundException extends  RuntimeException {
    public ReservaNotFoundException(Long id) {
        super("No existe la reserva con id " + id);
    }
}
