package com.ucc.LPII.config;

import com.ucc.LPII.entity.Rol;
import com.ucc.LPII.entity.Usuario;
import com.ucc.LPII.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@Profile("dev") // solo se ejecuta al activar el perfil
public class AdminInitializer implements CommandLineRunner {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public AdminInitializer(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // Archivos .env (environments)
    @Override
    public void run (String... args) {
        String correo = "admin.clase@test";
        if(usuarioRepository.existsByCorreo(correo)){
            // excepcion
            return;
        }

        Usuario admin = new Usuario();
        admin.setNombre("Administrador");
        admin.setCorreo(correo);
        admin.setEdad(20);
        admin.setContrasena(passwordEncoder.encode("admin1234"));

        admin.setRol(Rol.ADMIN);
        usuarioRepository.save(admin);
    }
}
