package mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.dao;

import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model.Cliente;
import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model.Vehiculo;
import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.repository.ClienteRepository;
import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.repository.VehiculoRepository;
import mx.ipn.upiicsa.dis.tallerMec.controlacceso.internal.output.ClienteOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

/**
 * Implementación del puerto de salida para la gestión de clientes.
 * <p>
 * Utiliza {@link ClienteRepository} y {@link VehiculoRepository} para persistir
 * y recuperar datos.
 * </p>
 */
@Component
public class ClienteDaoImpl implements ClienteOutputPort {
    @Autowired
    private ClienteRepository clienteRepo;
    @Autowired
    private VehiculoRepository vehiculoRepo;

    @Override
    public Cliente saveCliente(Cliente cliente) {
        return java.util.Objects.requireNonNull(clienteRepo.save(cliente));
    }

    @Override
    public List<Cliente> findAllClientes() {
        return java.util.Objects.requireNonNull(clienteRepo.findAll());
    }

    @Override
    public Optional<Cliente> findClienteById(String id) {
        return java.util.Objects.requireNonNull(clienteRepo.findById(id));
    }

    @Override
    public Vehiculo saveVehiculo(Vehiculo vehiculo) {
        return java.util.Objects.requireNonNull(vehiculoRepo.save(vehiculo));
    }
}