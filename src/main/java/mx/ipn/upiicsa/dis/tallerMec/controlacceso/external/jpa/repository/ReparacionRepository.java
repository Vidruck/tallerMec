package mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.repository;

import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model.Reparacion;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio para la gestión de reparaciones.
 * <p>
 * Proporciona acceso a los datos de las reparaciones registradas.
 * </p>
 */
public interface ReparacionRepository extends JpaRepository<Reparacion, Long> {
}