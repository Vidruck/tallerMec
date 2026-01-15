package mx.ipn.upiicsa.dis.tallerMec.controlacceso.internal.bs;

import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model.Departamento; // IMPORTANTE
import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model.Usuario;
import mx.ipn.upiicsa.dis.tallerMec.controlacceso.internal.input.UsuarioInputPort;
import mx.ipn.upiicsa.dis.tallerMec.controlacceso.internal.output.UsuarioOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UsuarioService implements UsuarioInputPort {

    @Autowired
    private UsuarioOutputPort usuarioOutputPort;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Usuario registrarUsuario(Usuario usuario) {
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));

        if (usuario.getIdUsuario() == null || usuario.getIdUsuario().isEmpty()) {
            usuario.setIdUsuario(UUID.randomUUID().toString().substring(0, 8));
        }

        // Por defecto Cliente, sin departamento
        usuario.setRol("CLIENTE");
        usuario.setDepartamento(null);

        return usuarioOutputPort.guardar(usuario);
    }

    @Override
    public Usuario buscarPorEmail(String email) {
        return usuarioOutputPort.buscarPorEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con email: " + email));
    }

    @Override
    public void cambiarRolUsuario(String idUsuario, String nuevoRol, Departamento departamento) {
        Usuario u = usuarioOutputPort.buscarPorId(idUsuario)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado ID: " + idUsuario));

        if("CLIENTE".equals(nuevoRol)) {
            u.setDepartamento(null);
        } else {
            // Validamos que si es personal, traiga departamento
            if(departamento == null) throw new RuntimeException("Personal requiere departamento");
            u.setDepartamento(departamento);
        }

        u.setRol(nuevoRol);
        usuarioOutputPort.guardar(u);
    }

    @Override
    public void actualizarPerfil(String idUsuario, String nuevoNombre, String nuevoPassword) {
        Usuario u = usuarioOutputPort.buscarPorId(idUsuario)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        u.setNombre(nuevoNombre);
        if(nuevoPassword != null && !nuevoPassword.isBlank()) {
            u.setPassword(passwordEncoder.encode(nuevoPassword));
        }
        usuarioOutputPort.guardar(u);
    }

    @Override
    public List<Usuario> obtenerTodos() {
        return usuarioOutputPort.buscarTodos();
    }
}