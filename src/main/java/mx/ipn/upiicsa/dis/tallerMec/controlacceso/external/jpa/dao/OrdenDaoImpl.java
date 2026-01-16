package mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.dao;

import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model.*;
import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.repository.*;
import mx.ipn.upiicsa.dis.tallerMec.controlacceso.internal.output.OrdenOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Implementación del puerto de salida para la gestión de órdenes de servicio.
 * <p>
 * Coordina el acceso a datos de órdenes, reparaciones, vehículos y usuarios
 * (asesores/mecánicos).
 * </p>
 */
@Component
public class OrdenDaoImpl implements OrdenOutputPort {

    @Autowired
    private OrdenServicioRepository ordenRepo;
    @Autowired
    private ReparacionRepository reparacionRepo;
    @Autowired
    private VehiculoRepository vehiculoRepo;
    @Autowired
    private UsuarioRepository usuarioRepo;

    @Override
    public OrdenServicio saveOrden(OrdenServicio orden) {
        return ordenRepo.save(orden);
    }

    @Override
    public Reparacion saveReparacion(Reparacion reparacion) {
        return reparacionRepo.save(reparacion);
    }

    @Override
    public Optional<OrdenServicio> findOrdenById(Long id) {
        return ordenRepo.findById(id);
    }

    @Override
    public List<OrdenServicio> findOrdenesByEstado(String estado) {
        return ordenRepo.findByEstado(estado);
    }

    @Override
    public Optional<Vehiculo> findVehiculoById(String id) {
        return vehiculoRepo.findById(id);
    }

    @Override
    public Optional<Usuario> findUsuarioById(String id) {
        return usuarioRepo.findById(id);
    }
}