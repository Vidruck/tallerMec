package mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.mvc.controller;

import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model.Departamento;
import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model.Usuario;
import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.repository.DepartamentoRepository;
import mx.ipn.upiicsa.dis.tallerMec.controlacceso.internal.input.UsuarioInputPort;
// Nota: Deberías exponer el método de cambio de rol en la interfaz InputPort o castear el servicio (mejor ponerlo en interfaz)
import mx.ipn.upiicsa.dis.tallerMec.controlacceso.internal.bs.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UsuarioService usuarioService; 

    @Autowired
    private UsuarioInputPort usuarioInputPort;

    @Autowired
    private DepartamentoRepository deptoRepo; 

    // Listar todos los usuarios para administrar
    @GetMapping("/usuarios")
    public String gestionarUsuarios(Model model) {
        
      
        model.addAttribute("departamentos", deptoRepo.findAll());
        return "admin/gestion_usuarios";
    }

    // Procesar cambio de rol
    @PostMapping("/promover")
    public String promoverUsuario(@RequestParam String idUsuario,
                                  @RequestParam String nuevoRol,
                                  @RequestParam(required = false) Integer idDepartamento) {

        Departamento depto = null;
        if(idDepartamento != null) {
            depto = deptoRepo.findById(idDepartamento).orElse(null);
        }

        usuarioService.cambiarRolUsuario(idUsuario, nuevoRol, depto);
        return "redirect:/admin/usuarios?exito";
    }
}