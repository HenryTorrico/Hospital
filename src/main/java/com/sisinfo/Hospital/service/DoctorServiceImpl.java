package com.sisinfo.Hospital.service;

import com.sisinfo.Hospital.model.Consulta;
import com.sisinfo.Hospital.model.Doctor;
import com.sisinfo.Hospital.repository.ConsultaRepository;
import com.sisinfo.Hospital.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class DoctorServiceImpl implements DoctorService{

    public DoctorRepository doctorRepository;

    @Autowired
    @Qualifier(value = "doctorRepository")
    public void setDoctorRepository(DoctorRepository doctorRepository) {

        this.doctorRepository = doctorRepository;
    }

    @Override
    public Iterable<Doctor> listAllDoctores() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor findDoctor(Integer id) {
        Optional<Doctor> opt;
        opt = doctorRepository.findById(id);
        return opt.get();
    }

    @Override
    public void saveDoctor(Doctor doctor) {
        doctorRepository.save(doctor);

    }
    @Override
    public void deleteDoctor(Integer id) {
        doctorRepository.deleteById(id);

    }
}
