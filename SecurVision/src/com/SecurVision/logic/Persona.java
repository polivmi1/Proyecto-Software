package com.SecurVision.logic;

import java.util.ArrayList;

public class Persona {

	private String dni;
	private String nombre;
	private String apellidos;

	private ArrayList<Imagen> imagenes;
	private ArrayList<Checkeo> checkeos = new ArrayList<Checkeo>();
	private HorarioEmpleo horario;
	private Nivel nivel;

	//Constructor
	public Persona (String dni, String nombre, String apellidos){
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.imagenes = new ArrayList<Imagen>();
		//this.horario = horario;
		//this.nivel = nivel;
	}

		//Getters and Setters
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

	public ArrayList<Imagen> getImagenes() {
		return imagenes;
	}

	public void setImagenes(ArrayList<Imagen> imagenes) {
		this.imagenes = imagenes;
	}

	public ArrayList<Checkeo> getCheckeos() {
		return checkeos;
	}

	public void setCheckeos(ArrayList<Checkeo> checkeos) {
		this.checkeos = checkeos;
	}

	public HorarioEmpleo getHorario() {
		return horario;
	}

	public void setHorario(HorarioEmpleo horario) {
		this.horario = horario;
	}

	public Nivel getNivel() {
		return nivel;
	}

	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}
}
