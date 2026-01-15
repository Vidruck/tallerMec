package mx.ipn.upiicsa.dis.tallerMec.controlacceso.internal.input;

import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model.Factura;
import java.util.List;

public interface FacturacionInputPort {
    Factura generarFactura(Long idOrden, String rfc);
    List<Factura> obtenerFacturasPorCliente(String rfc);
    Factura obtenerFactura(String idFactura);
}