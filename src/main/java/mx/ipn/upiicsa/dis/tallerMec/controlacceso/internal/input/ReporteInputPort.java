package mx.ipn.upiicsa.dis.tallerMec.controlacceso.internal.input;

import java.util.Map;

/**
 * Puerto de entrada para la generación de reportes y métricas.
 */
public interface ReporteInputPort {
    /**
     * Obtiene los ingresos mensuales del taller.
     *
     * @return Mapa con el mes y el total vendido.
     */
    Map<String, Double> obtenerIngresosMensuales();

    /**
     * Obtiene el rendimiento de los mecánicos basado en las órdenes atendidas.
     *
     * @return Mapa con el nombre del mecánico y la cantidad de órdenes.
     */
    Map<String, Integer> obtenerRendimientoMecanicos();
}