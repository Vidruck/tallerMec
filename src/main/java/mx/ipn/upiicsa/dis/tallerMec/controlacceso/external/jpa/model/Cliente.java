package mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "clientes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    @Id
    @Column(name = "id_cliente")
    private String idCliente;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "correo", unique = true)
    private String correo;

    // NUEVO CAMPO
    @Column(name = "sexo")
    private String sexo;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Vehiculo> vehiculos;
}