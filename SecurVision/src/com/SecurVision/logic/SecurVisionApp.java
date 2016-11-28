package com.SecurVision.logic;

import java.util.HashMap;

import com.SecurVision.exceptions.DAOExcepcion;
import com.SecurVision.persistencia.DAL;
import com.SecurVision.persistenciaDTO.PersonaDTO;

public class SecurVisionApp {
	private DAL dal;
	private HashMap<String, Persona> listaPersonas;

	public HashMap<String, Persona> getListaPersonas() {
		return listaPersonas;
	}

	//Crear Persona
	public Persona crearPersona(String dni, String nombre, String apellidos, int idNivel, int idHorario) throws DAOExcepcion{
		dal.crearPersona(new PersonaDTO(dni,nombre, apellidos, idNivel, idHorario));

		Persona p = new Persona(dni, nombre, apellidos);
		listaPersonas.put(dni,p);

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
