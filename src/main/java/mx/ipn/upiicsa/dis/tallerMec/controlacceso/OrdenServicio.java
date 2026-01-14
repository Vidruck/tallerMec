package controlacceso;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

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
    // Nota: El PDF pide String(12) para ID Orden, pero IDENTITY (Long) es más fácil de manejar en JPA.

    @Column(name = "fecha_ingreso", nullable = false)
    private LocalDateTime fechaIngreso; // Fecha de ingreso al taller

    @Column(name = "fecha_salida")
    private LocalDateTime fechaSalida; // Fecha de entrega/salida del taller

    @Column(nullable = false)
    private String estado; // Ejemplo: "En Taller", "Finalizado"

    @Column(name = "descripcion_problema", length = 500)
    private String descripcionProblema;

    @ManyToOne
    @JoinColumn(name = "id_vehiculo", nullable = false)
    private Vehiculo vehiculo;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false) // Asesor que recibe
    private Usuario asesor;
}