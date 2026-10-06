package com.ucc.LPII.exception;


import com.ucc.LPII.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice //escucha todas las excepciones de todos los controladores
public class GlobalExceptionHandler {

    @ExceptionHandler(ReservaNotFoundException.class)
    public ResponseEntity<ErrorDTO> manejarReservaNoEncontrada(ReservaNotFoundException ex){
        ErrorDTO error = new ErrorDTO(404, ex.getMessage(), java.time.LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
