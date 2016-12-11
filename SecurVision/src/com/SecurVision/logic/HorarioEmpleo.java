package com.SecurVision.logic;

import java.util.ArrayList;

public class HorarioEmpleo {

	private int id;
	private String description;

	private ArrayList<FranjaHoraria> franjas = new ArrayList<FranjaHoraria>();
	private ArrayList<Persona> personas = new ArrayList<Persona>();

		//Constructor
	public HorarioEmpleo(int id, String desc){
		this.id = id;
		this.description = desc;
	}

		//Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ArrayList<FranjaHoraria> getFranjas() {
		return franjas;
	}

	public void setFranjas(ArrayList<FranjaHoraria> franjas) {
		this.franjas = franjas;
	}

	public ArrayList<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(ArrayList<Persona> personas) {
		this.personas = personas;
	}
}
