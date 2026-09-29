package com.ucc.LPII.controller;

import com.ucc.LPII.dto.ReservaRequestDTO;
import com.ucc.LPII.dto.ReservaResponseDTO;
import com.ucc.LPII.entity.Reserva;
import com.ucc.LPII.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservas")
// http://localhost:8080/api/reservas

public class ReservaController {
    @Autowired
    ReservaService reservaService;

    //get, post, put, delete

    // obtener todos
    @GetMapping("/all")
    public List<ReservaResponseDTO> obtenerTodasLasReservas() {
        return reservaService.obtenerTodasLasReservas();
    }

    //obtener uno por id
    @GetMapping("/{id}")
    public ReservaResponseDTO obtenerUnaReserva(@PathVariable("id") Long id) {
        return reservaService.obtenerUnaReserva(id);
    }

    // agregar una reserva
    @PostMapping("/add")
    public ReservaResponseDTO agregarReserva(@RequestBody ReservaRequestDTO dto) {
        return reservaService.agregarReserva(dto);
    }

    // modificar una reserva
    @PutMapping("/{id}")
    public ReservaResponseDTO modificarReserva(@PathVariable("id") Long id,
                                    @RequestBody ReservaRequestDTO dto) {
        return reservaService.modificarReserva(id, dto);
    }
    // eliminar una reserva
    @DeleteMapping("/{id}")
    public void eliminarReserva(@PathVariable("id") Long id) {
        reservaService.borrarUnaReserva(id);
    }

}
