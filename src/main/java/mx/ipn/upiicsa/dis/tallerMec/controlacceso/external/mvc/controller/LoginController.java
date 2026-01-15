package mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.mvc.controller;

import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model.Usuario;
import mx.ipn.upiicsa.dis.tallerMec.controlacceso.internal.input.UsuarioInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    private UsuarioInputPort usuarioService;


    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/registro")
    public String mostrarRegistro() {
        return "registro";
    }

    @PostMapping("/registro")
    public String procesarRegistro(Usuario usuario) {
        usuarioService.registrarUsuario(usuario);
        return "redirect:/login?registroExitoso";
    }


    @GetMapping("/dashboard")
    public String dashboard(Model model, Authentication authentication) {
        return "dashboard";
    }
}