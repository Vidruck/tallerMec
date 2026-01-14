package mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.mvc.controller;

import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model.Cliente;
import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model.Vehiculo;
import mx.ipn.upiicsa.dis.tallerMec.controlacceso.internal.input.ClienteInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteInputPort clienteService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("listaClientes", clienteService.obtenerTodos());
        return "clientes/lista"; // Vista Thymeleaf
    }

    @GetMapping("/nuevo")
    public String formCliente(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "clientes/formulario";
    }

    @PostMapping("/guardar")
    public String guardarCliente(Cliente cliente) {
        clienteService.registrarCliente(cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/{id}/vehiculos/nuevo")
    public String formVehiculo(@PathVariable String id, Model model) {
        model.addAttribute("clienteId", id);
        model.addAttribute("vehiculo", new Vehiculo());
        return "clientes/formulario_vehiculo";
    }

    @PostMapping("/{id}/vehiculos/guardar")
    public String guardarVehiculo(@PathVariable String id, Vehiculo vehiculo) {
        clienteService.agregarVehiculo(id, vehiculo);
        return "redirect:/clientes";
    }
}