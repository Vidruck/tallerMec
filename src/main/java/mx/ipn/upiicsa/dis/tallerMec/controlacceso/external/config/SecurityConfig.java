package mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.config;

import jakarta.persistence.Column;
import mx.ipn.upiicsa.dis.tallerMec.controlacceso.internal.output.UsuarioOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


import java.util.Collections;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(requests -> requests
                        // Recursos públicos
                        .requestMatchers("/", "/home", "/registro", "/css/**", "/js/**", "/images/**").permitAll()

                        // Zona Administrativa (Admin y Jefes)
                        .requestMatchers("/admin/**").hasAnyRole("ADMIN", "JEFE_AREA")

                        // Zona de Trabajo (Mecánicos reportando avances)
                        .requestMatchers("/taller/**").hasAnyRole("TRABAJADOR", "JEFE_AREA")

                        // Zona de Clientes (Ver mis autos, citas)
                        .requestMatchers("/portal-cliente/**").hasRole("CLIENTE")

                        // Cualquier otra cosa requiere autenticación
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .permitAll()
                        // Redirigir según rol tras login exitoso (se puede personalizar con un Handler)
                        .defaultSuccessUrl("/dashboard", true)
                )
                .logout(logout -> logout.permitAll());

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(UsuarioOutputPort usuarioOutputPort) {
        return email -> usuarioOutputPort.buscarPorEmail(email)
                .map(u -> {
                    // Spring Security espera roles con el prefijo "ROLE_"
                    String rolSpring = "ROLE_" + u.getRol();
                    return new User(
                            u.getEmail(),
                            u.getPassword(),
                            Collections.singletonList(new SimpleGrantedAuthority(rolSpring))
                    );
                })
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
    }
}