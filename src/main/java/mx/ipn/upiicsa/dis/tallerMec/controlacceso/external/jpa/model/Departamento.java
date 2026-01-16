package mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model;

import jakarta.persistence.*;
import lombok.*;

/**
 * Entidad que representa un departamento dentro de la organización.
 * <p>
 * Define las distintas áreas a las que pueden pertenecer los usuarios
 * (empleados).
 * </p>
 */
@Entity
@Table(name = "departamentos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_departamento")
    private Integer idDepartamento;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;
}