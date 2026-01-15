package mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.repository;
import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository <Cliente, String> {
    Optional<Cliente> findByCorreo(String correo);
}
