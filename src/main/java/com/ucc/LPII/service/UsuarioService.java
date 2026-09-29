package com.ucc.LPII.service;

import com.ucc.LPII.dto.UsuarioDTO;
import com.ucc.LPII.mapper.UsuarioMapper;
import com.ucc.LPII.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    public UsuarioService(UsuarioMapper usuarioMapper) {
        this.usuarioMapper = usuarioMapper;
    }

    public List<UsuarioDTO> obtenerTodosLosUsuarios() {
        return usuarioRepository.findAll()
                .stream()
                .map(usuarioMapper::entityToDTO)
                .toList();
    }
}
