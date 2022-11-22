package com.alibaba.academy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.academy.model.Contact;

@Controller
public class ContactController {

	@PostMapping(value = "/contact")
	public ModelAndView contact(ModelMap model, @ModelAttribute("contact") Contact contact, BindingResult result) {
		System.out.println(contact);
		return new ModelAndView("index", model);
	}
}
