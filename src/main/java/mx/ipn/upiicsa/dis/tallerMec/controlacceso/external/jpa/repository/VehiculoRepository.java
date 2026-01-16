package mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.repository;

import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * Repositorio para la gestión de vehículos.
 */
public interface VehiculoRepository extends JpaRepository<Vehiculo, String> {
    /**
     * Busca vehículos asociados a un cliente específico.
     *
     * @param IdCliente Identificador del cliente.
     * @return Lista de vehículos del cliente.
     */
    List<Vehiculo> findByCliente_IdCliente(String IdCliente);
}
