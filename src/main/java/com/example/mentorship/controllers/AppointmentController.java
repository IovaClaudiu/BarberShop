package com.example.mentorship.controllers;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.mentorship.model.Appointment;
import com.example.mentorship.model.EHairCut;

@RestController
@RequestMapping("/book")
@CrossOrigin(origins = "http://localhost:9090", maxAge = 3600)
public class AppointmentController {

	@Autowired
	private JdbcTemplate template;

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public ModelAndView newAppointment(@ModelAttribute Appointment appointment) {
		ModelAndView model = new ModelAndView();
		model.setViewName("appointment");
		model.addObject("actions", EHairCut.values());
		model.addObject("appointment", appointment);
		return model;
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public ModelAndView submitAppointment(@ModelAttribute Appointment appointment, RedirectAttributes redir) {
		ModelAndView model = new ModelAndView();
		if (insertAppointment(appointment) > 0) {
			model.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			model.setViewName("redirect:add?error");
			redir.addFlashAttribute("appointment", appointment);
		} else {

		}
		return model;
	}

	private int insertAppointment(Appointment app) {
		String query = "INSERT INTO appointment (client_name,email,phone,action_type,date_app,time_app) VALUES (? ,? ,? ,? ,? ,?)";
		return template.update(query, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, app.getClientName());
				ps.setString(2, app.getEmail());
				ps.setString(3, app.getPhone());
				ps.setString(4, app.getActionType().toString());
				ps.setDate(5, app.getDate());
				ps.setTime(6, app.getTime());
			}
		});
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat forDate = new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat forTime = new SimpleDateFormat("HH:mm");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(forDate, true));
		binder.registerCustomEditor(Time.class, new CustomDateEditor(forTime, true));
	}
}
