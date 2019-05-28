package com.sisinfo.Hospital.repository;


import com.sisinfo.Hospital.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
}
