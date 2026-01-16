package mx.ipn.upiicsa.dis.tallerMec.controlacceso.internal.input;

import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model.OrdenServicio;
import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model.Reparacion;
import java.util.List;

/**
 * Puerto de entrada para la gestión de órdenes de servicio.
 */
public interface OrdenInputPort {
    /**
     * Crea una nueva orden de servicio.
     *
     * @param idVehiculo      ID del vehículo.
     * @param idUsuarioAsesor ID del asesor que crea la orden.
     * @param problema        Descripción del problema reportado.
     * @return La orden creada.
     */
    OrdenServicio crearOrden(String idVehiculo, String idUsuarioAsesor, String problema);

    /**
     * Agrega una reparación a una orden existente.
     *
     * @param idOrden    ID de la orden.
     * @param reparacion Objeto reparación con los detalles.
     * @return La orden actualizada.
     */
    OrdenServicio agregarReparacion(Long idOrden, Reparacion reparacion);

    /**
     * Cambia el estado de una orden de servicio.
     *
     * @param idOrden     ID de la orden.
     * @param nuevoEstado Nuevo estado a asignar.
     */
    void cambiarEstado(Long idOrden, String nuevoEstado);

    /**
     * Obtiene los detalles de una orden por su ID.
     *
     * @param idOrden ID de la orden.
     * @return La orden encontrada.
     */
    OrdenServicio obtenerOrden(Long idOrden);

    /**
     * Lista las órdenes que están pendientes de finalización.
     *
     * @return Lista de órdenes pendientes.
     */
    List<OrdenServicio> listarPendientes();
}