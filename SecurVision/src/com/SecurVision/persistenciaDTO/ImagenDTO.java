package com.SecurVision.persistenciaDTO;

public class ImagenDTO{

	private String url;
	private String dni_persona;

		//Constructor
	public ImagenDTO(String url, String dni) {
		this.url = url;
		this.dni_persona = dni;
	}

	//Getters and Setters
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDni_persona() {
		return dni_persona;
	}

	public void setDni_persona(String dni_persona) {
		this.dni_persona = dni_persona;
	}

}
