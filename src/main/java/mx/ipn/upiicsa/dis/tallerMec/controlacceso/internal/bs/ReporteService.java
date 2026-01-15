package mx.ipn.upiicsa.dis.tallerMec.controlacceso.internal.bs;

import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.repository.FacturaRepository;
import mx.ipn.upiicsa.dis.tallerMec.controlacceso.internal.input.ReporteInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ReporteService implements ReporteInputPort {

    // Inyectamos Repositorios directamente porque es un servicio de SOLO LECTURA/AGREGACIÓN
    // Si quisieras ser estricto, crearías un ReporteOutputPort
    @Autowired
    private FacturaRepository facturaRepository;

    @Override
    public Map<String, Double> obtenerIngresosMensuales() {
        // Simulación: En un caso real harías una consulta SQL nativa (GROUP BY MONTH)
        Map<String, Double> datos = new HashMap<>();
        datos.put("ENERO", 15000.0);
        datos.put("FEBRERO", 23500.0);
        datos.put("MARZO", 18200.0);
        return datos;
    }

    @Override
    public Map<String, Integer> obtenerRendimientoMecanicos() {
        Map<String, Integer> datos = new HashMap<>();
        datos.put("Juan Perez", 12);
        datos.put("Carlos Lopez", 8);
        return datos;
    }
}