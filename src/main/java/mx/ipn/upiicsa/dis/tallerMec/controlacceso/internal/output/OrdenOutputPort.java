package mx.ipn.upiicsa.dis.tallerMec.controlacceso.internal.output;

import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model.OrdenServicio;
import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model.Reparacion;
import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model.Usuario;
import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model.Vehiculo;
import java.util.List;
import java.util.Optional;

public interface OrdenOutputPort {
    OrdenServicio saveOrden(OrdenServicio orden);
    Reparacion saveReparacion(Reparacion reparacion);
    Optional<OrdenServicio> findOrdenById(Long id);
    List<OrdenServicio> findOrdenesByEstado(String estado);

    // Auxiliares para validar existencia
    Optional<Vehiculo> findVehiculoById(String id);
    Optional<Usuario> findUsuarioById(String id);
}