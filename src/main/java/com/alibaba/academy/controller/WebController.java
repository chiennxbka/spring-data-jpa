package com.alibaba.academy.controller;

import com.alibaba.academy.model.Users;
import com.alibaba.academy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.alibaba.academy.model.Dog;

import java.util.List;

@Controller
public class WebController {
	
	@Autowired Dog dog;
	
	@Autowired InternalResourceViewResolver viewResolver;

	@Autowired UserRepository repository;
	
	/*
	 * private Dog dog;
	 * 
	 * private InternalResourceViewResolver viewResolver;
	 * 
	 * 
	 * public WebController(Dog dog, InternalResourceViewResolver viewResolver) {
	 * this.dog = dog; this.viewResolver = viewResolver; }
	 */

	@GetMapping(value = "/")
	public ModelAndView home(ModelMap model) {
		model.addAttribute("message", "Hello Spring MVC Framework!");
		List<Users> users = repository.findAll();
		users.forEach(System.out::println);
		return new ModelAndView("index", model);
	}

	@GetMapping(value = "/inner-page")
	public ModelAndView innerPage(ModelMap model) {
		model.addAttribute("message", "Hello Spring MVC Framework!");
		return new ModelAndView("inner-page", model);
	}

	@GetMapping(value = "/portfolio")
	public ModelAndView portfolio(ModelMap model) {
		model.addAttribute("message", "Hello Spring MVC Framework!");
		return new ModelAndView("portfolio", model);
	}
	
	
}