package mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.dao;
import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model.Cliente;
import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model.Vehiculo;
import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.repository.ClienteRepository;
import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.repository.VehiculoRepository;
import mx.ipn.upiicsa.dis.tallerMec.controlacceso.internal.input.ClienteInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
@Component
public class ClienteDaoImpl  implements ClienteInputPort {
    @Autowired private ClienteRepository clienteRepo;
    @Autowired private VehiculoRepository vehiculoRepo;

    @Override public Cliente savenCliente(Cliente cliente){return clienteRepo.save(cliente);}
    @Override public List<Cliente> findAllClientes(){return clienteRepo.findAll();}
    @Override public Optional<Cliente> findClienteById(String id){return clienteRepo.findById(id);}
    @Override public Vehiculo saveVehiculo(Vehiculo vehiculo){return vehiculoRepo.save(vehiculo);}
}
