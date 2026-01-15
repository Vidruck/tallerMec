package mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.repository;

import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model.OrdenServicio;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OrdenServicioRepository extends JpaRepository<OrdenServicio, Long> {
    List<OrdenServicio> findByVehiculo_Placas(String placas);
    List<OrdenServicio> findByEstado(String estado);
}