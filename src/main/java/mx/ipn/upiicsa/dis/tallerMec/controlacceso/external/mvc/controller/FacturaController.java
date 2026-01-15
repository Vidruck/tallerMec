package mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.mvc.controller;

import mx.ipn.upiicsa.dis.tallerMec.controlacceso.internal.input.FacturacionInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/facturas")
public class FacturaController {

    @Autowired
    private FacturacionInputPort facturacionService;

    @PostMapping("/generar")
    public String generar(@RequestParam Long idOrden, @RequestParam String rfc) {
        facturacionService.generarFactura(idOrden, rfc);
        return "redirect:/facturas/mis-facturas?rfc=" + rfc;
    }

    // ... otros métodos de visualización
}