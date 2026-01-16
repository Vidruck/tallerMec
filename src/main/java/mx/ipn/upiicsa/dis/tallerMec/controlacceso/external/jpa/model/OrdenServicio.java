package mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;

/**
 * Entidad que representa una orden de servicio.
 * <p>
 * Contiene los detalles del servicio solicitado, el vehículo involucrado,
 * el asesor responsable y el estado actual del servicio.
 * </p>
 */
@Entity
@Table(name = "ordenes_servicio")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrdenServicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_orden")
    private Long idOrden;

    @Column(name = "fecha_ingreso", nullable = false)
    private LocalDateTime fechaIngreso;

    @Column(name = "fecha_salida")
    private LocalDateTime fechaSalida;

    @Column(nullable = false, length = 20)
    private String estado; // "En Taller", "Finalizado", etc.

    @Column(name = "descripcion_problema", length = 500)
    private String descripcionProblema;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_vehiculo", nullable = false)
    private Vehiculo vehiculo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario asesor;
}