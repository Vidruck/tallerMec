package AutoWizards.Dominio.Modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "facturas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_factura")
    private Long idFactura;

    @Column(name = "fecha_emision", nullable = false)
    private LocalDateTime fechaEmision;

    @Column(name = "doble_subtotal", nullable = false)
    private Double dobleSubtotal;

    @Column(name = "doble_iva", nullable = false)
    private Double dobleIva;

    @Column(name = "doble_total", nullable = false)
    private Double dobleTotal;

    @Column(name = "estado_pago", nullable = false)
    private String estadoPago;

    @OneToOne
    @JoinColumn(name = "id_orden", referencedColumnName = "id_orden")
    private OrdenServicio ordenServicio;
}
