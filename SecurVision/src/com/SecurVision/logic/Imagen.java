package com.SecurVision.logic;

import java.io.File;

public class Imagen extends File{

	private Persona persona;

		//Constructor
	public Imagen(File arg0, String arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

		//Getters and Setters
	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
}
