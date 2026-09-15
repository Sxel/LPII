package com.ucc.LPII.controller;

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
    public List<Reserva> obtenerTodasLasReservas() {
        return reservaService.obtenerTodasLasReservas();
    }

    //obtener uno por id
    @GetMapping("/{id}")
    public Reserva obtenerUnaReserva(@PathVariable("id") Long id) {
        return reservaService.obtenerUnaReserva(id);
    }

    // agregar una reserva
    @PostMapping("/add")
    public Reserva agregarReserva(@RequestBody Reserva reserva) {
        return reservaService.agregarReserva(reserva);
    }

    // modificar una reserva
    @PutMapping("/{id}")
    public Reserva modificarReserva(@PathVariable("id") Long id,
                                    @RequestBody Reserva reserva) {
        return reservaService.modificarReserva(id, reserva);
    }
    // eliminar una reserva

    @DeleteMapping("/{id}")
    public void eliminarReserva(@PathVariable("id") Long id) {
        reservaService.borrarUnaReserva(id);
    }

}
