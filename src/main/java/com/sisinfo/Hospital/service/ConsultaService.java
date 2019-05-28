package com.sisinfo.Hospital.service;

import com.sisinfo.Hospital.model.Consulta;

public interface ConsultaService {
    Iterable<Consulta> listAllConsultas();
    Consulta findConsulta(Integer id);
    void saveConsulta(Consulta consulta);
    void deleteConsulta(Integer id);
}

