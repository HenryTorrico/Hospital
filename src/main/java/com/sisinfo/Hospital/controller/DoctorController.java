package com.sisinfo.Hospital.controller;

import com.sisinfo.Hospital.model.Doctor;
import com.sisinfo.Hospital.model.User;
import com.sisinfo.Hospital.service.DoctorService;
import com.sisinfo.Hospital.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.print.Doc;
import java.util.LinkedList;
import java.util.List;


@Controller
public class DoctorController {


    @Autowired
    private DoctorService doctorService;

    @RequestMapping(value = "/doctor/new", method = RequestMethod.GET)
    public String newDoctor(Model model) {
        model.addAttribute("doctor", new Doctor());
        return "newDoctor";
    }


    @RequestMapping(value = "/registerDoctor", method = RequestMethod.POST)
    public String createDoctor(@ModelAttribute("doctor") Doctor doctor, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "newDoctor";
        }
        doctorService.saveDoctor(doctor);
        return "redirect:/doctores";
    }
    @RequestMapping(value = "/doctor/edit/{id}")
    public String editDoctor(@PathVariable Integer id, Model model) {
        Doctor doctor = doctorService.findDoctor(id);
        model.addAttribute("doctor", doctor);
        return "newDoctor";
    }

    @RequestMapping(value = "/doctor/{id}", method = RequestMethod.GET)
    public String showDoctor(@PathVariable Integer id, Model model) {

        Doctor doctor = doctorService.findDoctor(id);
        model.addAttribute("doctor", doctor);
        return "showDoctor";
    }



    @RequestMapping(value = "/doctor/delete/{id}", method = RequestMethod.GET)
    public String deleteDoctor(@PathVariable Integer id, Model model) {
        doctorService.deleteDoctor(id);
        return "redirect:/doctores";
    }

    @RequestMapping(value = "/doctores", method = RequestMethod.GET)
    public String listDoctors(Model model) {
        List<Doctor> doctors = new LinkedList<>();
        for (Doctor u: doctorService.listAllDoctores()) {
            /*if (!u.getName().isEmpty() && !u.getEmail().isEmpty())*/ doctors.add(u);
        }
        model.addAttribute("doctors", doctors);
        return "doctorIndex";
    }
}
