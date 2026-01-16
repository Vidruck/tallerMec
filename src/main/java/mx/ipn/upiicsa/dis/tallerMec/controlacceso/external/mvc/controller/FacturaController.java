package mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.mvc.controller;

import mx.ipn.upiicsa.dis.tallerMec.controlacceso.internal.input.FacturacionInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.repository.ClienteRepository;
import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.repository.FacturaRepository;
import java.util.List;

/**
 * Controlador para la visualización de facturas.
 * <p>
 * Permite a los clientes consultar sus facturas.
 * </p>
 */
@Controller
@RequestMapping("/facturas")
public class FacturaController {

    @Autowired
    private FacturacionInputPort facturacionService;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private FacturaRepository facturaRepository;

    @GetMapping("/mis-facturas")
    public String misFacturas(Model model, Authentication authentication) {
        String email = authentication.getName();

        // Buscar cliente y sus facturas
        clienteRepository.findByCorreo(email).ifPresentOrElse(
                cliente -> {
                    // Asumiendo que guardamos el RFC o ID Cliente en la factura
                    model.addAttribute("facturas", facturaRepository.findByRfcCliente(cliente.getIdCliente()));
                },
                () -> model.addAttribute("facturas", List.of()));

        return "clientes/mis_facturas";
    }
}