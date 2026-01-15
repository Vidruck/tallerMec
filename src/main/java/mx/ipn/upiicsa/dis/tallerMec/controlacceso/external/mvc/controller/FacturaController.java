package mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.mvc.controller;

import mx.ipn.upiicsa.dis.tallerMec.controlacceso.internal.input.FacturacionInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication; // Importante
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/facturas")
public class FacturaController {

    @Autowired
    private FacturacionInputPort facturacionService;

    // Generar nueva factura (Acción administrativa o post-pago)
    @PostMapping("/generar")
    public String generar(@RequestParam Long idOrden, @RequestParam String rfc) {
        facturacionService.generarFactura(idOrden, rfc);
        return "redirect:/taller/ordenes/" + idOrden; // Regresa a la orden
    }

    // VISTA FALTANTE: Ver mis facturas (Para el Cliente)
    @GetMapping("/mis-facturas")
    public String misFacturas(Model model, Authentication authentication) {

        String usuarioActual = authentication.getName();


        return "clientes/mis_facturas";
    }
}