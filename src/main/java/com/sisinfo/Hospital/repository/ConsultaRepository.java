package com.sisinfo.Hospital.repository;

import com.sisinfo.Hospital.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;


@Transactional
public interface ConsultaRepository extends JpaRepository<Consulta,Integer> {
}
