package com.SecurVision.logic;

import java.util.ArrayList;

public class Usuario extends Persona{

	private String username;
	private String password;

	//Constructor
	public Usuario(String id, String nombre, String apellidos, String user, String pass){
		super(id, nombre, apellidos);
		this.username = user;
		this.password = pass;
	}

		//Getters and Setters
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


}
