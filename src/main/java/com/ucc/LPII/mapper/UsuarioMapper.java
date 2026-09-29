package com.ucc.LPII.mapper;

import com.ucc.LPII.dto.UsuarioDTO;
import com.ucc.LPII.entity.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {
    public UsuarioMapper() {
    }

    public UsuarioDTO entityToDTO (Usuario usuario){
        return new UsuarioDTO(
                usuario.getNombre(),
                usuario.getCorreo(),
                usuario.getEdad()
        );
    }

    public Usuario dtoToEntity(UsuarioDTO usuarioDTO){
        Usuario usuario = new Usuario();
        usuario.setNombre(usuarioDTO.nombre());
        usuario.setCorreo(usuarioDTO.correo());
        usuario.setEdad(usuarioDTO.edad());
        return usuario;
    }
}
