package mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;

/**
 * Entidad que representa una factura generada por un servicio.
 * <p>
 * Contiene información fiscal y financiera relacionada con una orden de
 * servicio.
 * </p>
 */
@Entity
@Table(name = "facturas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Factura {

    @Id
    @Column(name = "id_factura")
    private String idFactura;

    @Column(name = "fecha_emision", nullable = false)
    private LocalDateTime fechaEmision;

    @Column(name = "monto_total", nullable = false)
    private Double montoTotal;

    @Column(name = "rfc_cliente", length = 13)
    private String rfcCliente;

    @Column(name = "archivo_pdf")
    private String archivoPdf; // Ruta simbólica

    @OneToOne
    @JoinColumn(name = "id_orden", nullable = false)
    private OrdenServicio ordenServicio;
}