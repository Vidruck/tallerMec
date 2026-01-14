package mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.repository;
import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface VehiculoRepository extends JpaRepository<Vehiculo, String> {
    List<Vehiculo> findByCliente_IdCliente(String IdCliente);
}
