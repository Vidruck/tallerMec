package mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.mvc.controller;

import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model.Cliente;
import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model.OrdenServicio;
import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.repository.ClienteRepository;
import mx.ipn.upiicsa.dis.tallerMec.controlacceso.internal.input.OrdenInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Controlador para la gestión de citas.
 * <p>
 * Permite a los clientes solicitar citas de servicio.
 * </p>
 */
@Controller
@RequestMapping("/citas")
public class CitaController {

    @Autowired
    private ClienteRepository clienteRepository; // Para buscar los autos del cliente

    @Autowired
    private OrdenInputPort ordenService;

    @GetMapping("/solicitar")
    public String formularioCita(Model model, Authentication authentication) {
        // 1. Buscar al cliente por su email (usuario logueado)
        String email = authentication.getName();
        Optional<Cliente> clienteOpt = clienteRepository.findByCorreo(email);

        if (clienteOpt.isPresent()) {
            model.addAttribute("vehiculos", clienteOpt.get().getVehiculos());
            model.addAttribute("cliente", clienteOpt.get());
            return "citas/solicitar"; // La vista que crearemos abajo
        } else {
            // Si el usuario no está registrado como Cliente (ej. es solo Usuario web)
            return "redirect:/perfil?error=NoCliente";
        }
    }

    @PostMapping("/guardar")
    public String guardarCita(@RequestParam String idVehiculo,
            @RequestParam String problema,
            Authentication authentication) {
        // 2. Creamos la orden con estado "EN_ESPERA" o "CITA_WEB"
        // Usamos un ID de asesor genérico o "admin" ya que es autoservicio
        OrdenServicio orden = ordenService.crearOrden(idVehiculo, "admin", "CITA WEB: " + problema);

        // Cambiamos el estado para diferenciarla de las que están ya en taller
        ordenService.cambiarEstado(orden.getIdOrden(), "CITA_SOLICITADA");

        return "redirect:/dashboard?exito=CitaSolicitada";
    }
}