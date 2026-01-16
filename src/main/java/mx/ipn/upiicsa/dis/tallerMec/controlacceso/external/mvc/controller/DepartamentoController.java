package mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.mvc.controller;

import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model.Departamento;
import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador para la gestión de departamentos.
 * <p>
 * Permite listar y registrar departamentos en el sistema.
 * </p>
 */
@Controller
@RequestMapping("/admin/departamentos")
public class DepartamentoController {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("departamentos", departamentoRepository.findAll());
        model.addAttribute("nuevoDepto", new Departamento()); // Para el formulario modal
        return "admin/departamentos";
    }

    @PostMapping("/guardar")
    public String guardar(Departamento departamento) {
        departamentoRepository.save(java.util.Objects.requireNonNull(departamento));
        return "redirect:/admin/departamentos?exito";
    }
}