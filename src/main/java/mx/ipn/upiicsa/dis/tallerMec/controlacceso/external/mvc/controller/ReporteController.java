package mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.mvc.controller;

import mx.ipn.upiicsa.dis.tallerMec.controlacceso.internal.input.ReporteInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/reportes")
public class ReporteController {

    @Autowired
    private ReporteInputPort reporteService;

    @GetMapping("/dashboard")
    public String verDashboard(Model model) {
        model.addAttribute("ingresos", reporteService.obtenerIngresosMensuales());
        model.addAttribute("rendimiento", reporteService.obtenerRendimientoMecanicos());
        return "admin/reportes_dashboard";
    }
}