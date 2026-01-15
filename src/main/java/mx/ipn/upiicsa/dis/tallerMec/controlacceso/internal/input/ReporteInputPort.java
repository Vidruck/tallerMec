package mx.ipn.upiicsa.dis.tallerMec.controlacceso.internal.input;

import java.util.Map;

public interface ReporteInputPort {
    // Retorna datos para gráficos: Mes -> Total Vendido
    Map<String, Double> obtenerIngresosMensuales();
    // Retorna datos: Mecánico -> Cantidad de Órdenes
    Map<String, Integer> obtenerRendimientoMecanicos();
}