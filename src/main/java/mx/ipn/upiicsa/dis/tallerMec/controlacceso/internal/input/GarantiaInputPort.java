package mx.ipn.upiicsa.dis.tallerMec.controlacceso.internal.input;

import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model.Garantia;
import java.util.List;

/**
 * Puerto de entrada para el manejo de garantías.
 */
public interface GarantiaInputPort {
    /**
     * Emite una garantía para una reparación.
     *
     * @param idReparacion  ID de la reparación.
     * @param mesesDuracion Duración en meses.
     * @param cobertura     Descripción de la cobertura.
     * @return La garantía creada.
     */
    Garantia emitirGarantia(Long idReparacion, int mesesDuracion, String cobertura);

    /**
     * Valida si una garantía sigue vigente.
     *
     * @param idGarantia ID de la garantía.
     * @return true si es válida, false en caso contrario.
     */
    boolean validarGarantia(String idGarantia);

    /**
     * Lista todas las garantías que se encuentran activas.
     *
     * @return Lista de garantías activas.
     */
    List<Garantia> listarGarantiasActivas();
}