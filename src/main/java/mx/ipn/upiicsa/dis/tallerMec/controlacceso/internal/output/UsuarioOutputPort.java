package mx.ipn.upiicsa.dis.tallerMec.controlacceso.internal.output;

import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioOutputPort {
    Usuario guardar(Usuario usuario);
    Optional <Usuario> buscarPorEmail(String email);
    Optional <Usuario> buscarPorId(String id);
    List<Usuario> buscarTodos();

}
