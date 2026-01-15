package mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "departamentos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_departamento") // Asegúrate también de que coincida (schema.sql usa id_departamento)
    private Integer idDepartamento;

    @Column(name = "nombre")
    private String nombre;

    // CORRECCIÓN AQUÍ: Agregamos la 's' faltante
    @Column(name = "descripcion")
    private String descripcion;
}