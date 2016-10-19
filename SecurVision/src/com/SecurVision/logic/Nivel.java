package com.SecurVision.logic;

import java.util.ArrayList;

public class Nivel {

	private int id;
	private String description;

	private ArrayList<Zona> zonas = new ArrayList<Zona>();
	private ArrayList<Persona> personas = new ArrayList<Persona>();

	//Constructor
	public Nivel(int id, String desc){
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

	public ArrayList<Zona> getZonas() {
		return zonas;
	}

	public void setZonas(ArrayList<Zona> zonas) {
		this.zonas = zonas;
	}

	public ArrayList<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(ArrayList<Persona> personas) {
		this.personas = personas;
	}
}
