package mx.ipn.upiicsa.dis.tallerMec.controlacceso.internal.output;

import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model.Usuario;

import java.util.List;
import java.util.Optional;

/**
 * Puerto de salida para la persistencia de usuarios.
 */
public interface UsuarioOutputPort {
    /**
     * Guarda un usuario en el repositorio.
     *
     * @param usuario Usuario a guardar.
     * @return El usuario guardado.
     */
    Usuario guardar(Usuario usuario);

    /**
     * Busca un usuario por su correo electrónico.
     *
     * @param email Correo electrónico.
     * @return Un {@link Optional} con el usuario si existe.
     */
    Optional<Usuario> buscarPorEmail(String email);

    /**
     * Busca un usuario por su identificador.
     *
     * @param id ID del usuario.
     * @return Un {@link Optional} con el usuario si existe.
     */
    Optional<Usuario> buscarPorId(String id);

    /**
     * Obtiene todos los usuarios registrados.
     *
     * @return Lista de todos los usuarios.
     */
    List<Usuario> buscarTodos();
}
