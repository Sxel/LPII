package com.ucc.LPII.controller;

import com.ucc.LPII.dto.UsuarioDTO;
import com.ucc.LPII.dto.UsuarioRegistroDTO;
import com.ucc.LPII.entity.Usuario;
import com.ucc.LPII.mapper.UsuarioMapper;
import com.ucc.LPII.repository.UsuarioRepository;
import com.ucc.LPII.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
// si quiero consultar desde el front
// http://localhost:8080/api/usuarios
public class UsuarioController {
    @Autowired // inyectar dependencias
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioMapper usuarioMapper;

    //  definir get, post, put, delete
    // http://localhost:8080/api/usuarios/all
    @GetMapping("/all")
    public List<UsuarioDTO> obtenerTodosLosUsuarios() {
        //ej; sql; SELECT * FROM usuarios;
        return usuarioService.obtenerTodosLosUsuarios();
    }

    @PostMapping("/registro")
    public ResponseEntity<UsuarioDTO> registrar(@Valid @RequestBody UsuarioRegistroDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.registrar(dto));
    }

    // put / delete
}


