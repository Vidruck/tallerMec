package mx.ipn.upiicsa.dis.tallerMec.controlacceso.internal.bs;

import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model.OrdenServicio;
import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model.Reparacion;
import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model.Usuario;
import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model.Vehiculo;
import mx.ipn.upiicsa.dis.tallerMec.controlacceso.internal.input.OrdenInputPort;
import mx.ipn.upiicsa.dis.tallerMec.controlacceso.internal.output.OrdenOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrdenService implements OrdenInputPort {

    @Autowired
    private OrdenOutputPort outputPort;

    @Override
    @Transactional
    public OrdenServicio crearOrden(String idVehiculo, String idUsuarioAsesor, String problema) {
        Vehiculo vehiculo = outputPort.findVehiculoById(idVehiculo)
                .orElseThrow(() -> new RuntimeException("Vehículo no encontrado"));

        Usuario asesor = outputPort.findUsuarioById(idUsuarioAsesor)
                .orElseThrow(() -> new RuntimeException("Asesor no encontrado"));

        OrdenServicio orden = new OrdenServicio();
        orden.setVehiculo(vehiculo);
        orden.setAsesor(asesor);
        orden.setDescripcionProblema(problema);
        orden.setFechaIngreso(LocalDateTime.now());
        orden.setEstado("EN_TALLER"); // Estado inicial

        return outputPort.saveOrden(orden);
    }

    @Override
    @Transactional
    public OrdenServicio agregarReparacion(Long idOrden, Reparacion reparacion) {
        OrdenServicio orden = obtenerOrden(idOrden);


        reparacion.setOrdenServicio(orden);
        reparacion.setFechaReparacion(LocalDate.now());

        outputPort.saveReparacion(reparacion);
        return orden;
    }

    @Override
    public void cambiarEstado(Long idOrden, String nuevoEstado) {
        OrdenServicio orden = obtenerOrden(idOrden);
        orden.setEstado(nuevoEstado);

        if("FINALIZADO".equals(nuevoEstado)){
            orden.setFechaSalida(LocalDateTime.now());
        }

        outputPort.saveOrden(orden);
    }

    @Override
    public OrdenServicio obtenerOrden(Long idOrden) {
        return outputPort.findOrdenById(idOrden)
                .orElseThrow(() -> new RuntimeException("Orden " + idOrden + " no encontrada"));
    }

    @Override
    public List<OrdenServicio> listarPendientes() {
        return outputPort.findOrdenesByEstado("EN_TALLER");
    }
}