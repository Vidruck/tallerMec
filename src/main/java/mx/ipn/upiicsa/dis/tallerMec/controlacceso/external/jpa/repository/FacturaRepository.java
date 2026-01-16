package mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.repository;

import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * Repositorio para la gestión de datos de la entidad {@link Factura}.
 */
public interface FacturaRepository extends JpaRepository<Factura, String> {
    /**
     * Busca las facturas asociadas a un cliente mediante su RFC.
     *
     * @param rfc RFC del cliente.
     * @return Lista de facturas encontradas.
     */
    List<Factura> findByRfcCliente(String rfc);
}