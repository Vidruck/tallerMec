package mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.dao;

import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model.Usuario;
import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.repository.UsuarioRepository;
import mx.ipn.upiicsa.dis.tallerMec.controlacceso.internal.output.UsuarioOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Implementación del puerto de salida para la gestión de usuarios.
 * <p>
 * Implementa las operaciones definidas en {@link UsuarioOutputPort} utilizando
 * {@link UsuarioRepository}.
 * </p>
 */
@Component
public class UsuarioDaoImpl implements UsuarioOutputPort {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario guardar(Usuario usuario) {
        return java.util.Objects.requireNonNull(usuarioRepository.save(usuario));
    }

    @Override
    public Optional<Usuario> buscarPorEmail(String email) {
        return java.util.Objects.requireNonNull(usuarioRepository.findByEmail(email));
    }

    @Override
    public Optional<Usuario> buscarPorId(String id) {
        return java.util.Objects.requireNonNull(usuarioRepository.findById(id));
    }

    @Override
    public List<Usuario> buscarTodos() {
        return java.util.Objects.requireNonNull(usuarioRepository.findAll());
    }
}
