package com.sisinfo.Hospital.service;

import com.sisinfo.Hospital.model.Consulta;
import com.sisinfo.Hospital.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ConsultaServiceImpl implements ConsultaService{
    public ConsultaRepository consultaRepository;

    @Autowired
    @Qualifier(value = "consultaRepository")
    public void setConsultaRepository(ConsultaRepository consultaRepository) {
        this.consultaRepository = consultaRepository;
    }

    @Override
    public Iterable<Consulta> listAllConsultas() {
        return consultaRepository.findAll();
    }

    @Override
    public Consulta findConsulta(Integer id) {
        Optional<Consulta> opt;
        opt = consultaRepository.findById(id);
        return opt.get();
    }

    @Override
    public void saveConsulta(Consulta consulta) {
        consultaRepository.save(consulta);

    }
    @Override
    public void deleteConsulta(Integer id) {
        consultaRepository.deleteById(id);

    }
}
