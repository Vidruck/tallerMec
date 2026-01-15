package mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.mvc.controller;

import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model.OrdenServicio;
import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model.Reparacion;
import mx.ipn.upiicsa.dis.tallerMec.controlacceso.internal.input.OrdenInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/taller/ordenes")
public class OrdenController {

    @Autowired
    private OrdenInputPort ordenService;

    // Tablero principal del taller
    @GetMapping
    public String tablero(Model model) {
        model.addAttribute("ordenesPendientes", ordenService.listarPendientes());
        return "taller/tablero";
    }

    // Crear nueva orden (Formulario)
    @GetMapping("/nueva")
    public String nuevaOrden(@RequestParam String idVehiculo, Model model) {
        model.addAttribute("idVehiculo", idVehiculo);
        model.addAttribute("orden", new OrdenServicio());
        return "taller/nueva_orden";
    }

    // Guardar la orden
    @PostMapping("/guardar")
    public String guardarOrden(OrdenServicio orden,
                               @RequestParam String idVehiculo,
                               @AuthenticationPrincipal User user) {


        ordenService.crearOrden(idVehiculo, "admin", orden.getDescripcionProblema()); // "admin" temporal
        return "redirect:/taller/ordenes";
    }

    // Ver detalle y agregar reparaciones
    @GetMapping("/{id}")
    public String detalle(@PathVariable Long id, Model model) {
        model.addAttribute("orden", ordenService.obtenerOrden(id));
        model.addAttribute("nuevaReparacion", new Reparacion());
        return "taller/detalle_orden";
    }

    @PostMapping("/{id}/reparaciones")
    public String agregarReparacion(@PathVariable Long id, Reparacion reparacion) {
        ordenService.agregarReparacion(id, reparacion);
        return "redirect:/taller/ordenes/" + id;
    }

    @PostMapping("/{id}/finalizar")
    public String finalizar(@PathVariable Long id) {
        ordenService.cambiarEstado(id, "FINALIZADO");
        return "redirect:/taller/ordenes";
    }
}