package mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
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

    @Column(name = "correo")
    private String correo;

    // CORRECCIÓN AQUÍ: fetch = FetchType.LAZY (antes decía fecth)
    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    private List<Vehiculo> vehiculos;
}