package mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.repository;

import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model.Garantia;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface GarantiaRepository extends JpaRepository<Garantia, String> {
    List<Garantia> findByEstado(String estado);
}