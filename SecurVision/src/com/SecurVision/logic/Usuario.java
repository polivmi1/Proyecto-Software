package com.SecurVision.logic;

import java.util.ArrayList;

public class Usuario extends Persona{

	private String username;
	private String email;
	private String password;

	//Constructor
	public Usuario(String id, String nombre, String apellidos, ArrayList<Imagen>imagenes, String user, String email, String pass){
		super(id, nombre, apellidos, imagenes);
		this.username = user;
		this.email = email;
		this.password = pass;
	}

		//Getters and Setters
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


}
