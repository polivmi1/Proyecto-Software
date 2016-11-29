package com.SecurVision.persistenciaDTO;

import java.io.File;

public class ImagenDTO extends File{

	private String dni_persona;

		//Constructor
	public ImagenDTO(File parent, String child, String dni) {
		super(parent, child);
		this.dni_persona = dni;
	}

		//Getters and Setters
	public String getDni_persona() {
		return dni_persona;
	}

	public void setDni_persona(String dni_persona) {
		this.dni_persona = dni_persona;
	}

}
