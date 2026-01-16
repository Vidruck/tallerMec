package mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.repository;

import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Repositorio para la gestión de datos de la entidad {@link Cliente}.
 * <p>
 * Provee métodos para realizar operaciones CRUD y consultas personalizadas.
 * </p>
 */
public interface ClienteRepository extends JpaRepository<Cliente, String> {
    /**
     * Busca un cliente por su correo electrónico.
     *
     * @param correo Dirección de correo electrónico del cliente.
     * @return Un objeto {@link Optional} que contiene el cliente si existe, o
     *         vacío.
     */
    Optional<Cliente> findByCorreo(String correo);
}
