package com.SecurVision.logic;

import java.util.ArrayList;

public class Checkeo {

	//Cambio prueba github
	private int id;
	private String description;

	private Persona persona;
	private ArrayList<Zona> zonas = new ArrayList<Zona>();

	//Constructor
	public Checkeo( int id, String description){
		this.id = id;
		this.description = description;
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

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public ArrayList<Zona> getZonas() {
		return zonas;
	}

	public void setZonas(ArrayList<Zona> zonas) {
		this.zonas = zonas;
	}
}
