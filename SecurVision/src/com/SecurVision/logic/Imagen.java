package com.SecurVision.logic;

import java.io.File;

public class Imagen{

	private Persona persona;
	private String url;

		//Constructor
	public Imagen(String url, Persona persona) {
		this.url = url;
		this.persona = persona;
	}

		//Getters and Setters
	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
}
