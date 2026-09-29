package com.ucc.LPII.controller;

import com.ucc.LPII.dto.UsuarioDTO;
import com.ucc.LPII.entity.Usuario;
import com.ucc.LPII.repository.UsuarioRepository;
import com.ucc.LPII.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
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
    //  definir get, post, put, delete
    // http://localhost:8080/api/usuarios/all
    @GetMapping("/all")
    public List<UsuarioDTO> obtenerTodosLosUsuarios() {
        //ej; sql; SELECT * FROM usuarios;
        return usuarioService.obtenerTodosLosUsuarios();
    }

    @PostMapping("/add")
    public Usuario agregarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        usuario.setNombre(usuarioDTO.nombre());
        usuario.setCorreo(usuarioDTO.correo());
        usuario.setEdad(usuarioDTO.edad());
        return usuarioRepository.save(usuario);
    }

    // put / delete
}


