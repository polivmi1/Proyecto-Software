package com.SecurVision.persistenciaDTO;

import java.util.ArrayList;

import com.SecurVision.logic.Checkeo;
import com.SecurVision.logic.Nivel;

public class ZonaDTO {

	private int id;
	private String description;

	private Nivel nivel;
	private ArrayList<Checkeo> checkeos = new ArrayList<Checkeo>();

		//Constructor
	public ZonaDTO(int id, String desc){
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
