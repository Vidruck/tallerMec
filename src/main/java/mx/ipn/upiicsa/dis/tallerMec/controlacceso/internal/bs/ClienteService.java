package mx.ipn.upiicsa.dis.tallerMec.controlacceso.internal.bs;

import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model.Cliente;
import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model.Vehiculo;
import mx.ipn.upiicsa.dis.tallerMec.controlacceso.internal.input.ClienteInputPort;
import mx.ipn.upiicsa.dis.tallerMec.controlacceso.internal.output.ClienteOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Implementación de la lógica de negocio para la gestión de clientes.
 * <p>
 * Maneja el registro, consulta y modificación de clientes y sus vehículos.
 * </p>
 */
@Service
public class ClienteService implements ClienteInputPort {
    @Autowired
    private ClienteOutputPort outputPort;

    @Override
    public void registrarCliente(Cliente cliente) {
        // Regla de Negocio: Si el ID viene vacío, generar uno o validar que exista
        if (cliente.getIdCliente() == null || cliente.getIdCliente().isEmpty()) {
            cliente.setIdCliente(UUID.randomUUID().toString().substring(0, 10));
        }
        outputPort.saveCliente(cliente);
    }

    @Override
    public List<Cliente> obtenerTodos() {
        return outputPort.findAllClientes();
    }

    @Override
    public Cliente buscarPorId(String id) {
        return outputPort.findClienteById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
    }

    @Override
    public void agregarVehiculo(String idCliente, Vehiculo vehiculo) {
        Cliente cliente = buscarPorId(idCliente);
        vehiculo.setCliente(cliente);
        if (vehiculo.getIdVehiculo() == null || vehiculo.getIdVehiculo().isEmpty()) {
            vehiculo.setIdVehiculo(UUID.randomUUID().toString().substring(0, 10));
        }
        outputPort.saveVehiculo(vehiculo);
    }
}