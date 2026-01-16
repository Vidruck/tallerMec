package mx.ipn.upiicsa.dis.tallerMec.controlacceso.internal.output;

import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model.Cliente;
import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model.Vehiculo;

import java.util.List;
import java.util.Optional;

/**
 * Puerto de salida para la persistencia de datos de clientes.
 * <p>
 * Abstrae el acceso a datos para clientes y vehículos.
 * </p>
 */
public interface ClienteOutputPort {
    /**
     * Guarda o actualiza un cliente.
     *
     * @param cliente Cliente a guardar.
     * @return El cliente guardado.
     */
    Cliente saveCliente(Cliente cliente);

    /**
     * Obtiene todos los clientes registrados.
     *
     * @return Lista de clientes.
     */
    List<Cliente> findAllClientes();

    /**
     * Busca un cliente por su ID.
     *
     * @param id Identificador del cliente.
     * @return Un {@link Optional} con el cliente si se encuentra.
     */
    Optional<Cliente> findClienteById(String id);

    /**
     * Guarda un vehículo asociado a un cliente.
     *
     * @param vehiculo Vehículo a guardar.
     * @return El vehículo guardado.
     */
    Vehiculo saveVehiculo(Vehiculo vehiculo);
}
