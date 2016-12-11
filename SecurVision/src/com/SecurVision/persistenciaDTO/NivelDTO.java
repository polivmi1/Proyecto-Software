package com.SecurVision.persistenciaDTO;

public class NivelDTO {

	private int id;
	private String descripcion;

	//Constructor
	public NivelDTO(int id, String desc){
		this.id = id;
		this.descripcion = desc;
	}

	//Getters and Setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
