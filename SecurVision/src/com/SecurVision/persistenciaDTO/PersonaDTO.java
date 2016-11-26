package com.SecurVision.persistenciaDTO;

import java.util.ArrayList;

import com.SecurVision.logic.Imagen;


public class PersonaDTO {
	private String dni;
	private String nombre;
	private String apellidos;
	private int idNivel;
	private int idHorario;

		//Constructor
	public PersonaDTO (String dni, String nombre, String apellidos, int idN, int idH){
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.idNivel = idN;
		this.idHorario = idH;
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
	public int getIdNivel() {
		return idNivel;
	}
	public void setIdNivel(int idNivel) {
		this.idNivel = idNivel;
	}
	public int getIdHorario() {
		return idHorario;
	}
	public void setIdHorario(int idHorario) {
		this.idHorario = idHorario;
	}
}
