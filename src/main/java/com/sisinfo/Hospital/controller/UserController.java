package com.sisinfo.Hospital.controller;


import com.sisinfo.Hospital.model.User;
import com.sisinfo.Hospital.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.LinkedList;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/new", method = RequestMethod.GET)
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "newUser";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        return "login";
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String create(@ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "newUser";
        }
        userService.saveUser(user);
        return "redirect:/users";
    }
    @RequestMapping(value = "/user/edit/{id}")
    public String editUser(@PathVariable Integer id, Model model) {
        User user = userService.findUser(id);
        model.addAttribute("user", user);
        return "newUser";
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String showUser(@PathVariable Integer id, Model model) {

        User user = userService.findUser(id);
        model.addAttribute("user", user);
        return "showUser";
    }



    @RequestMapping(value = "/user/delete/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable Integer id, Model model) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String list(Model model) {
        List<User> users = new LinkedList<>();
        for (User u: userService.listAllUsers()) {
            /*if (!u.getName().isEmpty() && !u.getEmail().isEmpty())*/ users.add(u);
        }
        model.addAttribute("users", users);
        return "userIndex";
    }
}

