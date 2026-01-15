package mx.ipn.upiicsa.dis.tallerMec.controlacceso.internal.input;

import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model.Garantia;
import java.util.List;

public interface GarantiaInputPort {
    Garantia emitirGarantia(Long idReparacion, int mesesDuracion, String cobertura);
    boolean validarGarantia(String idGarantia);
    List<Garantia> listarGarantiasActivas();
}