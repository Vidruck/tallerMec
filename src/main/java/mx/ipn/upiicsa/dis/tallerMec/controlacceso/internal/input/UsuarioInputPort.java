package mx.ipn.upiicsa.dis.tallerMec.controlacceso.internal.input;

import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model.Departamento;
import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model.Usuario;
import java.util.List;

public interface UsuarioInputPort {
    Usuario registrarUsuario(Usuario usuario);
    Usuario buscarPorEmail(String email);

    // Estos son los que faltaban y causan error en los controladores:
    void cambiarRolUsuario(String idUsuario, String nuevoRol, Departamento departamento);
    void actualizarPerfil(String idUsuario, String nuevoNombre, String nuevoPassword);
    List<Usuario> obtenerTodos(); // Necesario para el AdminController
}