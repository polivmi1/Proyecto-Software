package com.SecurVision.logic;

import java.util.ArrayList;

public class Zona {

	private int id;
	private String description;

	private Nivel nivel;
	private ArrayList<Checkeo> checkeos = new ArrayList<Checkeo>();

		//Constructor
	public Zona(int id, String desc){
		this.id = id;
		this.description = desc;
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

	public Nivel getNivel() {
		return nivel;
	}

	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}

	public ArrayList<Checkeo> getCheckeos() {
		return checkeos;
	}

	public void setCheckeos(ArrayList<Checkeo> checkeos) {
		this.checkeos = checkeos;
	}
}
