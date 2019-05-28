package com.sisinfo.Hospital.service;

import com.sisinfo.Hospital.model.Doctor;

public interface DoctorService {

    Iterable<Doctor> listAllDoctores();
    Doctor findDoctor(Integer id);
    void saveDoctor(Doctor doctor);
    void deleteDoctor(Integer id);
}
