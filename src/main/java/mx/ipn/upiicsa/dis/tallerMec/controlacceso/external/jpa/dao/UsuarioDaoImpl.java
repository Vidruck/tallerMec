package mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.dao;

import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model.Usuario;
import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.repository.UsuarioRepository;
import mx.ipn.upiicsa.dis.tallerMec.controlacceso.internal.output.UsuarioOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
@Component
public class UsuarioDaoImpl implements UsuarioOutputPort {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Override
    public Usuario guardar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
    @Override
    public Optional<Usuario> buscarPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }
    @Override
    public Optional<Usuario> buscarPorId(String id) {
        return usuarioRepository.findById(id);
    }
    @Override
    public List<Usuario> buscarTodos() {
        return usuarioRepository.findAll();
    }
}
