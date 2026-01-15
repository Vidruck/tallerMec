package mx.ipn.upiicsa.dis.tallerMec.controlacceso.internal.bs;

import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model.Factura;
import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model.OrdenServicio;
import mx.ipn.upiicsa.dis.tallerMec.controlacceso.internal.input.FacturacionInputPort;
import mx.ipn.upiicsa.dis.tallerMec.controlacceso.internal.output.FacturacionOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class FacturacionService implements FacturacionInputPort {

    @Autowired
    private FacturacionOutputPort outputPort;

    @Override
    public Factura generarFactura(Long idOrden, String rfc) {
        OrdenServicio orden = outputPort.findOrdenById(idOrden)
                .orElseThrow(() -> new RuntimeException("Orden no encontrada"));

        // Lógica de negocio: Verificar que la orden esté finalizada antes de facturar
        if (!"FINALIZADO".equalsIgnoreCase(orden.getEstado())) {
            throw new IllegalStateException("Solo se pueden facturar órdenes finalizadas.");
        }

        Factura factura = new Factura();
        factura.setIdFactura(UUID.randomUUID().toString());
        factura.setFechaEmision(LocalDateTime.now());
        factura.setOrdenServicio(orden);
        factura.setRfcCliente(rfc);
        factura.setMontoTotal(1500.00); 
        factura.setArchivoPdf("/facturas/" + factura.getIdFactura() + ".pdf");

        return outputPort.save(factura);
    }

    @Override
    public List<Factura> obtenerFacturasPorCliente(String rfc) {
        return outputPort.findByRfc(rfc);
    }

    @Override
    public Factura obtenerFactura(String idFactura) {
        return outputPort.findById(idFactura)
                .orElseThrow(() -> new RuntimeException("Factura no existe"));
    }
}