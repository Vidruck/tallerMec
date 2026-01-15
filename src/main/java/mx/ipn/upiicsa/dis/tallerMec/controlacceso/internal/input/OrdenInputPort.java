package mx.ipn.upiicsa.dis.tallerMec.controlacceso.internal.input;

import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model.OrdenServicio;
import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model.Reparacion;
import java.util.List;

public interface OrdenInputPort {
    OrdenServicio crearOrden(String idVehiculo, String idUsuarioAsesor, String problema);
    OrdenServicio agregarReparacion(Long idOrden, Reparacion reparacion);
    void cambiarEstado(Long idOrden, String nuevoEstado); // "EN_PROCESO", "TERMINADO"
    OrdenServicio obtenerOrden(Long idOrden);
    List<OrdenServicio> listarPendientes();
}