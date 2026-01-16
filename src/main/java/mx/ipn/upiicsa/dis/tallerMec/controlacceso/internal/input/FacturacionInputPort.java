package mx.ipn.upiicsa.dis.tallerMec.controlacceso.internal.input;

import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model.Factura;
import java.util.List;

/**
 * Puerto de entrada para el módulo de facturación.
 * <p>
 * Define las operaciones para generar y consultar facturas.
 * </p>
 */
public interface FacturacionInputPort {
    /**
     * Genera una factura para una orden de servicio.
     *
     * @param idOrden Identificador de la orden de servicio.
     * @param rfc     RFC del cliente al que se factura.
     * @return La factura generada.
     */
    Factura generarFactura(Long idOrden, String rfc);

    /**
     * Obtiene las facturas asociadas a un cliente.
     *
     * @param rfc RFC del cliente.
     * @return Lista de facturas.
     */
    List<Factura> obtenerFacturasPorCliente(String rfc);

    /**
     * Obtiene una factura específica por su ID.
     *
     * @param idFactura Identificador de la factura.
     * @return La factura encontrada.
     */
    Factura obtenerFactura(String idFactura);
}