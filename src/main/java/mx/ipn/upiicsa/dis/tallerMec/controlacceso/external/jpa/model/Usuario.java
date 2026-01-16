package mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model;

import jakarta.persistence.*;
import lombok.*;

/**
 * Entidad que representa un usuario del sistema.
 * <p>
 * Puede ser un administrador, un mecánico, un asesor o un cliente.
 * </p>
 */
@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @Column(name = "id_usuario")
    private String idUsuario;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "rol")
    private String rol; // "Asesor", "Mecanico", "Admin"
    // Relacion opcional (un cliente no tiene un departamento pero un mecanico si)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_departamento")
    private Departamento departamento;
}