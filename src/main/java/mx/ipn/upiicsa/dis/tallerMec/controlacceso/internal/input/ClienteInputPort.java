package mx.ipn.upiicsa.dis.tallerMec.controlacceso.internal.input;

import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model.Cliente;
import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model.Vehiculo;
import java.util.List;

/**
 * Puerto de entrada para la gestión de clientes.
 * <p>
 * Define los casos de uso relacionados con clientes y sus vehículos.
 * </p>
 */
public interface ClienteInputPort {
    /**
     * Registra un nuevo cliente en el sistema.
     *
     * @param cliente Objeto {@link Cliente} a registrar.
     */
    void registrarCliente(Cliente cliente);

    /**
     * Obtiene una lista de todos los clientes.
     *
     * @return Lista de clientes.
     */
    List<Cliente> obtenerTodos();

    /**
     * Busca un cliente específico por su identificador.
     *
     * @param id Identificador del cliente.
     * @return Objeto {@link Cliente} encontrado.
     */
    Cliente buscarPorId(String id);

    /**
     * Agrega un vehículo a un cliente existente.
     *
     * @param idCliente Identificador del cliente.
     * @param vehiculo  Objeto {@link Vehiculo} a agregar.
     */
    void agregarVehiculo(String idCliente, Vehiculo vehiculo);
}
