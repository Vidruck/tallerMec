package mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.mvc.controller;

import mx.ipn.upiicsa.dis.tallerMec.controlacceso.internal.bs.UsuarioService;
import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/perfil")
public class PerfilController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public String verPerfil(@AuthenticationPrincipal User userSecurity, Model model) {
        // Buscamos los datos completos usando el email del usuario logueado
        Usuario u = usuarioService.buscarPorEmail(userSecurity.getUsername());
        model.addAttribute("usuario", u);
        return "perfil/mis_datos";
    }

    @PostMapping("/actualizar")
    public String actualizarPerfil(@RequestParam String idUsuario,
                                   @RequestParam String nombre,
                                   @RequestParam(required = false) String password) {

        usuarioService.actualizarPerfil(idUsuario, nombre, password);
        return "redirect:/perfil?actualizado";
    }
}