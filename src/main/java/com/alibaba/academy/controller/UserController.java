package com.alibaba.academy.controller;

import com.alibaba.academy.model.Users;
import com.alibaba.academy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
public class UserController {

    @Autowired UserRepository repository;

    @GetMapping("/listUser")
    public ModelAndView usersList(ModelMap model){
        List<Users> users = repository.findAll();
        model.addAttribute("users", users);
        return new ModelAndView("listUser", model);
    }

    @GetMapping("/save-user")
    public ModelAndView save(){
        Users users = new Users("Nguyen Van", "Hung","hung.gma@gmail.com", "123123");
        repository.save(users);
        return new ModelAndView("redirect:listUser");
    }
    @GetMapping("/remove-user")
    public ModelAndView remove(){
        repository.deleteAllByIdInBatch(Arrays.asList(6, 7));
        return new ModelAndView("redirect:listUser");
    }

    @GetMapping("/search")
    public ModelAndView findByEmail(@RequestParam String email, ModelMap model){
        List<Users> users = repository.findByEmail(email);
        model.addAttribute("users", users);
        return new ModelAndView("listUser");
    }
}
