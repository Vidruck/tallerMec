package controlacceso;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "reparaciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reparacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reparacion")
    private Long idReparacion;

    @Column(nullable = false)
    private String descripcion;

    @Column(name = "doble_costo", nullable = false)
    private Double dobleCosto;

    @Column(name = "doble_subtotal", nullable = false)
    private Double dobleSubtotal;

    @Column(name = "fecha_reparacion", nullable = false)
    private LocalDateTime fechaReparacion;

    @Column(name = "cubierto_garantia", nullable = false)
    private boolean cubiertoGarantia;

    @ManyToOne
    @JoinColumn(name = "id_orden", nullable = false)
    private OrdenServicio ordenServicio;
}
