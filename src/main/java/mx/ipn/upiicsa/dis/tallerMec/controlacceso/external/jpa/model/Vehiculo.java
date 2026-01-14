package mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "vehiculos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehiculo {
    @Id
    @Column(name = "id_vehivulo")
    private String idVehiculo;
    @Column(name = "marca")
    private String marca;
    @Column(name = "modelo")
    private String modelo;
    @Column(name = "anio")
    private int anio;
    @Column(name = "color")
    private String color;
    @Column(name = "numero_serie")
    private String numeroSerie;
    @Column(name = "placas")
    private String placas;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "id_Cliente")
    private Cliente cliente;
}
