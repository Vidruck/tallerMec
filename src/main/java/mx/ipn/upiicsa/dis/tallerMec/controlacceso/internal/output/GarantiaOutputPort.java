package mx.ipn.upiicsa.dis.tallerMec.controlacceso.internal.output;

import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model.Garantia;
import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model.Reparacion;
import java.util.List;
import java.util.Optional;

/**
 * Puerto de salida para la persistencia de garantías.
 */
public interface GarantiaOutputPort {
    /**
     * Guarda una garantía en el repositorio.
     *
     * @param garantia Garantía a guardar.
     * @return La garantía guardada.
     */
    Garantia save(Garantia garantia);

    /**
     * Busca una garantía por su ID.
     *
     * @param id ID de la garantía.
     * @return Un {@link Optional} con la garantía si existe.
     */
    Optional<Garantia> findById(String id);

    /**
     * Busca garantías por su estado.
     *
     * @param estado Estado de la garantía.
     * @return Lista de garantías que coinciden.
     */
    List<Garantia> findByEstado(String estado);

    /**
     * Busca una reparación por su ID para vincularla a una garantía.
     *
     * @param idReparacion ID de la reparación.
     * @return Un {@link Optional} con la reparación si existe.
     */
    Optional<Reparacion> findReparacionById(Long idReparacion);
}