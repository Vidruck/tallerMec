package mx.ipn.upiicsa.dis.tallerMec.controlacceso.internal.output;

import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model.Garantia;
import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model.Reparacion;
import java.util.List;
import java.util.Optional;

public interface GarantiaOutputPort {
    Garantia save(Garantia garantia);
    Optional<Garantia> findById(String id);
    List<Garantia> findByEstado(String estado);
    Optional<Reparacion> findReparacionById(Long idReparacion);
}