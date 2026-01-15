package mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.dao;

import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model.Garantia;
import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.model.Reparacion;
import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.repository.GarantiaRepository;
import mx.ipn.upiicsa.dis.tallerMec.controlacceso.external.jpa.repository.ReparacionRepository;
import mx.ipn.upiicsa.dis.tallerMec.controlacceso.internal.output.GarantiaOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class GarantiaDaoImpl implements GarantiaOutputPort {

    @Autowired
    private GarantiaRepository garantiaRepository;

    @Autowired
    private ReparacionRepository reparacionRepository;

    @Override
    public Garantia save(Garantia garantia) {
        return garantiaRepository.save(garantia);
    }

    @Override
    public Optional<Garantia> findById(String id) {
        return garantiaRepository.findById(id);
    }

    @Override
    public List<Garantia> findByEstado(String estado) {
        return garantiaRepository.findByEstado(estado);
    }

    @Override
    public Optional<Reparacion> findReparacionById(Long idReparacion) {
        return reparacionRepository.findById(idReparacion);
    }
}