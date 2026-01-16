package mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate;

/**
 * Entidad que representa la garantía otorgada por una reparación.
 * <p>
 * Define la vigencia y la cobertura de la garantía asociada a un trabajo
 * realizado.
 * </p>
 */
@Entity
@Table(name = "garantias")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Garantia {

    @Id
    @Column(name = "id_garantia")
    private String idGarantia;

    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin")
    private LocalDate fechaFin;

    @Column(length = 500)
    private String cobertura;

    @Column(length = 20)
    private String estado;

    @OneToOne
    @JoinColumn(name = "id_reparacion")
    private Reparacion reparacion;
}