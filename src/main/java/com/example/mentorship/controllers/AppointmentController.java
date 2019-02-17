package com.example.mentorship.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.mentorship.model.Appointment;
import com.example.mentorship.model.EHairCut;

@RestController
@RequestMapping("/book")
@CrossOrigin(origins = "http://localhost:9090", maxAge = 3600)
public class AppointmentController {

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public ModelAndView newAppointment() {
		ModelAndView model = new ModelAndView();
		model.setViewName("appointment");
		model.addObject("actions", EHairCut.values());
		model.addObject("appointment", new Appointment());
		return model;
	}

}
