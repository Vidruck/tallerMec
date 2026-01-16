package mx.ipn.upiicsa.dis.tallerMec.controlacceso.internal.input;

import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model.Departamento;
import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model.Usuario;
import java.util.List;

/**
 * Puerto de entrada para la gestión de usuarios.
 * <p>
 * Define las operaciones disponibles para la administración de usuarios.
 * </p>
 */
public interface UsuarioInputPort {
    /**
     * Registra un nuevo usuario en el sistema.
     *
     * @param usuario Usuario a registrar.
     * @return Usuario registrado.
     */
    Usuario registrarUsuario(Usuario usuario);

    /**
     * Busca un usuario por su correo electrónico.
     *
     * @param email Correo electrónico.
     * @return Usuario encontrado.
     */
    Usuario buscarPorEmail(String email);

    /**
     * Cambia el rol de un usuario.
     *
     * @param idUsuario    ID del usuario.
     * @param nuevoRol     Nuevo rol a asignar.
     * @param departamento Departamento asignado (si aplica).
     */
    void cambiarRolUsuario(String idUsuario, String nuevoRol, Departamento departamento);

    /**
     * Actualiza el perfil de un usuario.
     *
     * @param idUsuario     ID del usuario.
     * @param nuevoNombre   Nuevo nombre.
     * @param nuevoPassword Nueva contraseña (opcional).
     */
    void actualizarPerfil(String idUsuario, String nuevoNombre, String nuevoPassword);

    /**
     * Obtiene todos los usuarios registrados.
     *
     * @return Lista de todos los usuarios.
     */
    List<Usuario> obtenerTodos(); // Necesario para el AdminController
}