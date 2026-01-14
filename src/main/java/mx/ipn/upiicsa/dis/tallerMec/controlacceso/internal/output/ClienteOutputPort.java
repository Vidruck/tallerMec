package mx.ipn.upiicsa.dis.tallerMec.controlacceso.internal.output;

import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model.Cliente;
import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model.Vehiculo;

import java.util.List;
import java.util.Optional;

public interface ClienteOutputPort {
    Cliente saveCliente(Cliente cliente);
    List<Cliente> findAllClientes();
    Optional<Cliente> findClienteById(String id);
    Vehiculo saveVehiculo(Vehiculo vehiculo);
}
