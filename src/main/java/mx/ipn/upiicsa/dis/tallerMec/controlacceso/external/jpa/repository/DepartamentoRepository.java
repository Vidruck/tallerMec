package mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.repository;

import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio para la gestión de datos de la entidad {@link Departamento}.
 * <p>
 * Permite realizar operaciones de acceso a datos sobre los departamentos.
 * </p>
 */
public interface DepartamentoRepository extends JpaRepository<Departamento, Integer> {

}
