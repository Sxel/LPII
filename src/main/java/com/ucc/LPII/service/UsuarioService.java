package com.ucc.LPII.service;

import com.ucc.LPII.dto.UsuarioDTO;
import com.ucc.LPII.dto.UsuarioRegistroDTO;
import com.ucc.LPII.entity.Rol;
import com.ucc.LPII.entity.Usuario;
import com.ucc.LPII.exception.CorreoDuplicadoExeption;
import com.ucc.LPII.mapper.UsuarioMapper;
import com.ucc.LPII.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioMapper usuarioMapper;
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioMapper usuarioMapper, UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioMapper = usuarioMapper;
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<UsuarioDTO> obtenerTodosLosUsuarios() {
        return usuarioRepository.findAll()
                .stream()
                .map(usuarioMapper::entityToDTO)
                .toList();
    }

    public UsuarioDTO registrar(UsuarioRegistroDTO dto){
        if (usuarioRepository.existsByCorreo(dto.correo())) {
            throw new CorreoDuplicadoExeption(dto.correo());
        }

        Usuario usuario = new Usuario();
        usuario.setNombre(dto.nombre());
        usuario.setCorreo(dto.correo());
        usuario.setEdad(dto.edad());
        //Importante, no vamos a guardar la contraseña sino el hash
        usuario.setContrasena(passwordEncoder.encode(dto.contrasena()));
        usuario.setRol(Rol.USER);
        Usuario guardado = usuarioRepository.save(usuario);
        return  usuarioMapper.entityToDTO(guardado);
    }
}
