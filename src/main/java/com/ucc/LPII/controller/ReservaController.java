package com.ucc.LPII.controller;

import com.ucc.LPII.dto.ReservaRequestDTO;
import com.ucc.LPII.dto.ReservaResponseDTO;
import com.ucc.LPII.entity.Reserva;
import com.ucc.LPII.mapper.UsuarioMapper;
import com.ucc.LPII.repository.UsuarioRepository;
import com.ucc.LPII.service.ReservaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservas")
// http://localhost:8080/api/reservas

public class ReservaController {

    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    //get, post, put, delete

    //2xx: salio bien por ej 200, 201
    //4xx: el cliente pidio algo mal ej: 400, 404
    //5xx: error del servidor ej: 500, 503
    // obtener todos
    @GetMapping()
    public ResponseEntity<List<ReservaResponseDTO>> obtenerTodasLasReservas(){
        return ResponseEntity.ok(reservaService.obtenerTodasLasReservas());
    }

    //obtener uno por id
    @GetMapping("/{id}")
    public ResponseEntity<ReservaResponseDTO> obtenerUnaReserva(@PathVariable("id") Long id){
        return ResponseEntity.ok(reservaService.obtenerUnaReserva(id));
    }

    // obtener reservas por idUsuario
    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<List<ReservaResponseDTO>> obtenerReservasByUsuario(
            @PathVariable("idUsuario") Long idUsuario){
        List<ReservaResponseDTO> reservas = reservaService.obtenerReservasByUsuario(idUsuario);
        return ResponseEntity.ok(reservas);
    }

    // agregar una reserva
    @PostMapping()
    public ResponseEntity<ReservaResponseDTO>agregarReserva(@Valid @RequestBody ReservaRequestDTO dto){
        ReservaResponseDTO creada = reservaService.agregarReserva(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(creada);
    }

    // modificar una reserva
    @PutMapping("/{id}")
    public ResponseEntity<ReservaResponseDTO> modificarReserva (@PathVariable("id") Long id, @RequestBody ReservaRequestDTO dto){

        ReservaResponseDTO modificada = reservaService.modificarReserva(id, dto);
        if (modificada == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(modificada);
    }

    // eliminar una reserva
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarReserva(@PathVariable("id") Long id) {
        reservaService.borrarUnaReserva(id);
        return ResponseEntity.noContent().build();
    }
}
