package mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model;

import jakarta.persistence.*;
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
    @Column(name = "id_vehiculo") // <--- AQUÍ ESTABA EL ERROR (decía id_vehivulo)
    private String idVehiculo;

    @Column(name = "marca")
    private String marca;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "anio")
    private Integer anio;

    @Column(name = "color")
    private String color;

    @Column(name = "numero_serie", unique = true)
    private String numeroSerie;

    @Column(name = "placas", unique = true)
    private String placas;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;
}
