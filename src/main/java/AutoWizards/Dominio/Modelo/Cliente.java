package AutoWizards.Dominio.Modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "clientes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    @Id
    @Column(name = "id_cliente")
    private String idCliente;

    @Column(nullable = false)
    private String nombre;

    private String telefono;

    private String direccion;

    @Column(nullable = false, unique = true)
    private String correo;
}
