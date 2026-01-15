package mx.ipn.upiicsa.dis.tallerMec.controlacceso.internal.output;

import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model.Factura;
import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model.OrdenServicio;
import java.util.List;
import java.util.Optional;

public interface FacturacionOutputPort {
    Factura save(Factura factura);
    List<Factura> findByRfc(String rfc);
    Optional<Factura> findById(String id);
    Optional<OrdenServicio> findOrdenById(Long idOrden); // Necesario para vincular
}