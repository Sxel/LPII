package com.ucc.LPII.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    // JWT TOKENS / JSON WEB TOKEN
    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {
        http
                //1. Api Rest sin formularios ni cookies por eso desactivamos el csrf
                .csrf(csrf -> csrf.disable())
                //2. Sin sesion, cada request tiene que llevar sus credenciales
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                //3. Reglas de acceso: estas se evaluan de arriba hacia abajo
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.GET, "/api/reservas").hasRole("USER")
                        .requestMatchers(HttpMethod.DELETE,"/api/reservas/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/usuarios/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/api/usuarios/registro").permitAll()
                        .requestMatchers("/error").permitAll()
                        .anyRequest().authenticated()
                )
                //4. Login basic auth (usuario y contraseña en el header de la authorization)
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }

    //5. transforma la contraseña en un hash
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
