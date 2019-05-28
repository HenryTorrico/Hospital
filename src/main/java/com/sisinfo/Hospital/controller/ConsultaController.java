package com.sisinfo.Hospital.controller;


import com.sisinfo.Hospital.model.Consulta;
import com.sisinfo.Hospital.model.Doctor;
import com.sisinfo.Hospital.model.User;
import com.sisinfo.Hospital.service.ConsultaService;
import com.sisinfo.Hospital.service.DoctorService;
import com.sisinfo.Hospital.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.LinkedList;
import java.util.List;

@Controller
public class ConsultaController {


    @Autowired
    public ConsultaService consultaService;
    @Autowired
    public UserService userService;

    @Autowired
    public DoctorService doctorService;

    @RequestMapping(value = "/consulta/new", method = RequestMethod.GET)
    public String newConsulta(Model model) {
        List<User> users=(List) userService.listAllUsers();
        List<Doctor> doctors=(List) doctorService.listAllDoctores();
        model.addAttribute("consulta", new Consulta());
        model.addAttribute("users",users);
        model.addAttribute("doctors",doctors);
        return "newConsulta";
    }


    @RequestMapping(value = "/registerConsulta", method = RequestMethod.POST)
    public String create(@ModelAttribute("consulta")@Valid Consulta consulta, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "newConsulta";
        }
        consultaService.saveConsulta(consulta);
        return "redirect:/consultas";
    }
    @RequestMapping(value = "/consulta/edit/{id}")
    public String editConsulta(@PathVariable Integer id, Model model) {
        List<User> users=(List) userService.listAllUsers();
        List<Doctor> doctors=(List) doctorService.listAllDoctores();
        Consulta consulta = consultaService.findConsulta(id);
        model.addAttribute("consulta", consulta);
        model.addAttribute("users",users);
        model.addAttribute("doctors",doctors);
        return "newConsulta";
    }

    @RequestMapping(value = "/consulta/{id}", method = RequestMethod.GET)
    public String showConsulta(@PathVariable Integer id, Model model) {

        Consulta consulta = consultaService.findConsulta(id);
        model.addAttribute("consulta", consulta);
        return "showConsulta";
    }



    @RequestMapping(value = "/consulta/delete/{id}", method = RequestMethod.GET)
    public String deleteConsulta(@PathVariable Integer id, Model model) {
        consultaService.deleteConsulta(id);
        return "redirect:/consultas";
    }

    @RequestMapping(value = "/consultas",method=RequestMethod.GET)
    public String listConsultas(Model model) {
        System.out.println("aiudita");
        List<Consulta> consultas = new LinkedList<>();
        for (Consulta u: consultaService.listAllConsultas()) {
            consultas.add(u);
        }
        model.addAttribute("consultas", consultas);
        return "consultaIndex";
    }

}
