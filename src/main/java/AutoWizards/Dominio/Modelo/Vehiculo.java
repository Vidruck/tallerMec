package AutoWizards.Dominio.Modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "vehiculos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehiculo {

    @Id
    @Column(name = "id_vehiculo")
    private String idVehiculo;

    private String marca;

    private String modelo;

    private int anio;

    @Column(name = "numero_serie", length = 17, unique = true, nullable = false)
    private String numeroSerie;

    @Column(unique = true, nullable = false)
    private String placas;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;
}
