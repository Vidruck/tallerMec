package mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity
@Table(name = "departamentos")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Departamento")
    private Integer idDepartamento;

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "decripcion")
    private String decripcion;
}
