package mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data
@Table(name = "clientes")
@NoArgsConstructor
@AllArgsConstructor

public class Cliente {
    @Id
    @Column(name ="id_clente")
    private String idCliente;
    @Column(name ="nombre")
    private String nombre;
    @Column(name ="telefono")
    private String telefono;
    @Column(name ="direccion")
    private String direccion;
    @Column(name = "correo")
    private String correo;

    @OneToMany(mappedBy = "cliente", fecth = FetchType.LAZY)
    private List<Vehiculo>vehiculos;
}
