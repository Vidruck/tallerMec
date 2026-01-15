package mx.ipn.upiicsa.dis.tallerMec.controlacceso.internal.bs;

import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model.Garantia;
import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model.Reparacion;
import mx.ipn.upiicsa.dis.tallerMec.controlacceso.internal.input.GarantiaInputPort;
import mx.ipn.upiicsa.dis.tallerMec.controlacceso.internal.output.GarantiaOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class GarantiaService implements GarantiaInputPort {

    @Autowired
    private GarantiaOutputPort outputPort;

    @Override
    public Garantia emitirGarantia(Long idReparacion, int mesesDuracion, String cobertura) {
        Reparacion reparacion = outputPort.findReparacionById(idReparacion)
                .orElseThrow(() -> new RuntimeException("Reparación no encontrada"));

        Garantia garantia = new Garantia();
        garantia.setIdGarantia(UUID.randomUUID().toString());
        garantia.setFechaInicio(LocalDate.now());
        garantia.setFechaFin(LocalDate.now().plusMonths(mesesDuracion));
        garantia.setCobertura(cobertura);
        garantia.setEstado("ACTIVA");
        garantia.setReparacion(reparacion);

        return outputPort.save(garantia);
    }

    @Override
    public boolean validarGarantia(String idGarantia) {
        Garantia g = outputPort.findById(idGarantia)
                .orElseThrow(() -> new RuntimeException("Garantía no encontrada"));

        LocalDate hoy = LocalDate.now();
        // Regla: Si la fecha actual supera la fin, o estado no es activa -> Falso
        return g.getEstado().equals("ACTIVA") && !hoy.isAfter(g.getFechaFin());
    }

    @Override
    public List<Garantia> listarGarantiasActivas() {
        return outputPort.findByEstado("ACTIVA");
    }
}