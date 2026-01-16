package mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.repository;

import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model.Garantia;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * Repositorio para la gestión de garantías.
 */
public interface GarantiaRepository extends JpaRepository<Garantia, String> {
    /**
     * Busca garantías por su estado actual.
     *
     * @param estado Estado de la garantía.
     * @return Lista de garantías que coinciden con el estado.
     */
    List<Garantia> findByEstado(String estado);
}