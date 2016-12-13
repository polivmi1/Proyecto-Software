package com.SecurVision.persistenciaDTO;

public class UsuarioDTO {
	private String dni;
	private String nombre;
	private String apellidos;
	private String username;
	private String password;

		//Constructor
	public UsuarioDTO (String dni, String nombre, String apellidos,String username, String password){
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.username = username;
		this.password = password;
	}


	//Getters and Setter
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
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

