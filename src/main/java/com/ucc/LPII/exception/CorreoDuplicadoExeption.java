package com.ucc.LPII.exception;

public class CorreoDuplicadoExeption extends RuntimeException {
    public CorreoDuplicadoExeption(String correo) {
        super("El correo " + correo + " ya está en uso.");
    }
}
