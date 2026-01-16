package mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controlador para la gestión del inventario.
 * <p>
 * Gestiona la vista del inventario de refacciones y materiales.
 * </p>
 */
@Controller
@RequestMapping("/inventario")
public class InventarioController {

    @GetMapping
    public String listar() {
        return "taller/inventario";
    }
}