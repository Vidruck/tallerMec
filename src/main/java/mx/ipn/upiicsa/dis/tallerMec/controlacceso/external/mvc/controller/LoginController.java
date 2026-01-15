package mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.mvc.controller;

import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model.Cliente;
import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model.Usuario;
import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.repository.ClienteRepository;
import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.repository.UsuarioRepository;
import mx.ipn.upiicsa.dis.tallerMec.controlacceso.internal.input.UsuarioInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
public class LoginController {

    @Autowired
    private UsuarioInputPort usuarioService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/")
    public String index() { return "index"; }

    @GetMapping("/login")
    public String login() { return "login"; }

    @GetMapping("/registro")
    public String mostrarRegistro() { return "registro"; }

    // --- PROCESAMIENTO MEJORADO DEL REGISTRO ---
    @PostMapping("/registro")
    public String procesarRegistro(
            @RequestParam String nombres,
            @RequestParam String apellidos,
            @RequestParam String telefono,
            @RequestParam String sexo,
            @RequestParam(required = false) String rfc,
            @RequestParam String direccion,
            @RequestParam String email,
            @RequestParam String password) {

        String nombreCompleto = nombres + " " + apellidos;

        // 1. Crear Usuario (Para Login)
        Usuario usuario = new Usuario();
        usuario.setNombre(nombreCompleto);
        usuario.setEmail(email);
        usuario.setPassword(password);
        // El servicio se encarga de encriptar y asignar rol CLIENTE
        usuarioService.registrarUsuario(usuario);

        // 2. Crear Ficha de Cliente (Para el Taller)
        Cliente cliente = new Cliente();

        // Si no dio RFC, generamos un ID interno (ej. C-A1B2C3D4)
        if (rfc == null || rfc.trim().isEmpty()) {
            String idGenerado = "C-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
            cliente.setIdCliente(idGenerado);
        } else {
            cliente.setIdCliente(rfc.toUpperCase());
        }

        cliente.setNombre(nombreCompleto);
        cliente.setTelefono(telefono);
        cliente.setDireccion(direccion);
        cliente.setCorreo(email);
        cliente.setSexo(sexo); // Guardamos el sexo

        clienteRepository.save(cliente);

        return "redirect:/login?registroExitoso";
    }

    // --- DASHBOARD CON NOMBRE REAL ---
    @GetMapping("/dashboard")
    public String dashboard(Model model, Authentication authentication) {
        String email = authentication.getName();

        // Buscamos al usuario para obtener su nombre real
        usuarioRepository.findByEmail(email).ifPresent(usuario -> {
            // Pasamos solo el primer nombre para que sea más personal ("Hola, Alejandro")
            String primerNombre = usuario.getNombre().split(" ")[0];
            model.addAttribute("nombreUsuario", primerNombre);
        });

        return "dashboard";
    }
}