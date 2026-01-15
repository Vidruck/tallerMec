package mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.config;

import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model.Usuario;
import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.UUID;

@Configuration
public class DataInitializer {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public CommandLineRunner initAdmin() {
        return args -> {
            // Verificamos si ya existe el admin para no duplicarlo
            if (usuarioRepository.findByEmail("admin@autowizards.com").isEmpty()) {
                Usuario admin = new Usuario();
                admin.setIdUsuario(UUID.randomUUID().toString().substring(0, 8));
                admin.setNombre("Administrador Sistema");
                admin.setEmail("admin@autowizards.com");
                admin.setPassword(passwordEncoder.encode("admin")); // Password inicial
                admin.setRol("ADMIN");

                // El Admin pertenece al depto ADMINISTRACION (ID 1 en tu SQL anterior)
                // Nota: Asegúrate de que el Depto 1 exista en la BD o manéjalo aquí

                usuarioRepository.save(admin);
                System.out.println(">>> USUARIO ADMIN CREADO: admin@autowizards.com / admin");
            }
        };
    }
}
