package mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.repository;

import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model.OrdenServicio;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * Repositorio para la gestión de órdenes de servicio.
 */
public interface OrdenServicioRepository extends JpaRepository<OrdenServicio, Long> {
    /**
     * Busca órdenes de servicio asociadas a un vehículo por sus placas.
     *
     * @param placas Placas del vehículo.
     * @return Lista de órdenes de servicio.
     */
    List<OrdenServicio> findByVehiculo_Placas(String placas);

    /**
     * Busca órdenes de servicio por su estado.
     *
     * @param estado Estado de la orden.
     * @return Lista de órdenes de servicio.
     */
    List<OrdenServicio> findByEstado(String estado);
}