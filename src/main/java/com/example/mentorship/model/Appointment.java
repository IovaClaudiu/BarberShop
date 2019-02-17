package com.example.mentorship.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "appointment")
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "client_name")
	private String client_name;

	@Column(name = "action_type")
	private EHairCut action_type;

	public Appointment() {
	}

	public Appointment(String nume, EHairCut typeOf) {
		this.setClient_name(nume);
		this.setAction_type(typeOf);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getClient_name() {
		return client_name;
	}

	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}

	public EHairCut getAction_type() {
		return action_type;
	}

	public void setAction_type(EHairCut action_type) {
		this.action_type = action_type;
	}
}
