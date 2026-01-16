package mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.dao;

import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model.Factura;
import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model.OrdenServicio;
import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.repository.FacturaRepository;
import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.repository.OrdenServicioRepository;
import mx.ipn.upiicsa.dis.tallerMec.controlacceso.internal.output.FacturacionOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Implementación del puerto de salida para la facturación.
 * <p>
 * Se encarga de la persistencia de facturas y la recuperación de órdenes de
 * servicio relacionadas.
 * </p>
 */
@Component
public class FacturaDaoImpl implements FacturacionOutputPort {

    @Autowired
    private FacturaRepository facturaRepository;

    @Autowired
    private OrdenServicioRepository ordenServicioRepository;

    @Override
    public Factura save(Factura factura) {
        return java.util.Objects.requireNonNull(facturaRepository.save(factura));
    }

    @Override
    public List<Factura> findByRfc(String rfc) {
        return java.util.Objects.requireNonNull(facturaRepository.findByRfcCliente(rfc));
    }

    @Override
    public Optional<Factura> findById(String id) {
        return java.util.Objects.requireNonNull(facturaRepository.findById(id));
    }

    @Override
    public Optional<OrdenServicio> findOrdenById(Long idOrden) {
        return java.util.Objects.requireNonNull(ordenServicioRepository.findById(idOrden));
    }
}