package mx.ipn.upiicsa.dis.tallerMec.controlacceso.internal.output;

import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model.OrdenServicio;
import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model.Reparacion;
import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model.Usuario;
import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model.Vehiculo;
import java.util.List;
import java.util.Optional;

/**
 * Puerto de salida para la persistencia de órdenes de servicio y reparaciones.
 */
public interface OrdenOutputPort {
    /**
     * Guarda una orden de servicio.
     *
     * @param orden Orden a guardar.
     * @return La orden guardada.
     */
    OrdenServicio saveOrden(OrdenServicio orden);

    /**
     * Guarda una reparación asociada a una orden.
     *
     * @param reparacion Reparación a guardar.
     * @return La reparación guardada.
     */
    Reparacion saveReparacion(Reparacion reparacion);

    /**
     * Busca una orden por su ID.
     *
     * @param id ID de la orden.
     * @return Un {@link Optional} con la orden si existe.
     */
    Optional<OrdenServicio> findOrdenById(Long id);

    /**
     * Busca órdenes por su estado.
     *
     * @param estado Estado de la orden.
     * @return Lista de órdenes que coinciden.
     */
    List<OrdenServicio> findOrdenesByEstado(String estado);

    /**
     * Busca un vehículo por su ID.
     *
     * @param id ID del vehículo.
     * @return Un {@link Optional} con el vehículo si existe.
     */
    Optional<Vehiculo> findVehiculoById(String id);

    /**
     * Busca un usuario (asesor) por su ID.
     *
     * @param id ID del usuario.
     * @return Un {@link Optional} con el usuario si existe.
     */
    Optional<Usuario> findUsuarioById(String id);
}