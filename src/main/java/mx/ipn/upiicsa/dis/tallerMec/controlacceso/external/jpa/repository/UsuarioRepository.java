package mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.repository;

import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Repositorio para la gestión de usuarios del sistema.
 */
public interface UsuarioRepository extends JpaRepository<Usuario, String> {
    /**
     * Busca un usuario por su correo electrónico.
     *
     * @param email Correo electrónico del usuario.
     * @return Un objeto {@link Optional} con el usuario si es encontrado.
     */
    Optional<Usuario> findByEmail(String email);
}
