package com.example.mentorship.model;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "appointment")
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "client_name", nullable = false)
	private String clientName;

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "phone", nullable = false)
	private String phone;

	@Enumerated(EnumType.STRING)
	@Column(name = "action_type", nullable = false)
	private EHairCut actionType;

	@Column(name = "date_app", nullable = false)
	private Date date;

	@Column(name = "time_app", nullable = false)
	private Time time;

	public Appointment() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = Date.valueOf(LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-MM-yyyy")));
	}

	public Time getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = Time.valueOf(LocalTime.parse(time));
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public EHairCut getActionType() {
		return actionType;
	}

	public void setActionType(EHairCut actionType) {
		this.actionType = actionType;
	}
}
