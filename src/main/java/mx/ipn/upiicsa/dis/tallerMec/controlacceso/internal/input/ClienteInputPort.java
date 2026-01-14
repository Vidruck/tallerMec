package mx.ipn.upiicsa.dis.tallerMec.controlacceso.internal.input;

import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model.Cliente;
import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model.Vehiculo;
import java.util.List;

public interface ClienteInputPort {
    void registrarCliente(Cliente cliente);
    List<Cliente> obtenerTodos();
    Cliente buscarPorId(String id);
    void agregarVehiculo(String idCliente, Vehiculo vehiculo);
}
