package com.SecurVision.logic;

import java.time.LocalDateTime;
import java.util.HashMap;

import com.SecurVision.persistencia.DAL;

public class SecurVisionApp {
	private DAL dal;
	private HashMap<String, Persona> listaPersonas;

	public HashMap<String, Persona> getListaPersonas() {
		return listaPersonas;
	}

	//Crear Persona
	public Persona crearPersona(String dni, String nombre, String apellidos, int idNivel, int idHorario){
		Persona p = new Persona(dni, nombre, apellidos);

		System.out.println("\nLista de clientes: " + listaPersonas.size() +" clientes");
		return p;
	}

	//Method HashMap listaPersonas
	public void anyadirSucursal(Persona persona){
		listaPersonas.put(persona.getDni(), persona);
	}

	public Persona eliminarSucursal(int id){
		return listaPersonas.remove(id);
	}

	public Persona buscarSucursal(int id){
		return listaPersonas.get(id);
	}

	//Getters HashMap
	public void setListaPersonas(HashMap<String, Persona> listaPersonas) {
		this.listaPersonas = listaPersonas;
	}

}
