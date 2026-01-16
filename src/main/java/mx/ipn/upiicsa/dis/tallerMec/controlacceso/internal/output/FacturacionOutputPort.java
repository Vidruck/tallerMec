package mx.ipn.upiicsa.dis.tallerMec.controlacceso.internal.output;

import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model.Factura;
import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model.OrdenServicio;
import java.util.List;
import java.util.Optional;

/**
 * Puerto de salida para la persistencia de facturas.
 */
public interface FacturacionOutputPort {
    /**
     * Guarda una factura en el repositorio.
     *
     * @param factura Factura a guardar.
     * @return La factura guardada.
     */
    Factura save(Factura factura);

    /**
     * Busca facturas por el RFC del cliente.
     *
     * @param rfc RFC del cliente.
     * @return Lista de facturas encontradas.
     */
    List<Factura> findByRfc(String rfc);

    /**
     * Busca una factura por su identificador.
     *
     * @param id ID de la factura.
     * @return Un {@link Optional} con la factura si existe.
     */
    Optional<Factura> findById(String id);

    /**
     * Busca una orden de servicio por su ID para vincularla a una factura.
     *
     * @param idOrden ID de la orden.
     * @return Un {@link Optional} con la orden si existe.
     */
    Optional<OrdenServicio> findOrdenById(Long idOrden); // Necesario para vincular
}