package mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.config;

import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model.Usuario;
import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.UUID;

/**
 * Configuración inicial de datos para la aplicación.
 * <p>
 * Esta clase se encarga de precargar datos necesarios en la base de datos al
 * inicio de la ejecución.
 * </p>
 */
@Configuration
public class DataInitializer {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Bean que se ejecuta al inicio de la aplicación para crear un usuario
     * administrador si no existe.
     *
     * @return CommandLineRunner que ejecuta la lógica de inicialización.
     */
    @Bean
    public CommandLineRunner initAdmin() {
        return args -> {
            // Verificamos si ya existe el admin para no duplicarlo
            if (usuarioRepository.findByEmail("admin@autowizards.com").isEmpty()) {
                Usuario admin = new Usuario();
                admin.setIdUsuario(UUID.randomUUID().toString().substring(0, 8));
                admin.setNombre("Administrador Sistema");
                admin.setEmail("admin@autowizards.com");
                admin.setPassword(passwordEncoder.encode("admin"));
                admin.setRol("ADMIN");
                usuarioRepository.save(admin);
                System.out.println(">>> USUARIO ADMIN CREADO: admin@autowizards.com / admin");
            }
        };
    }
}
