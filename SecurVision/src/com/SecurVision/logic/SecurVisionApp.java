package com.SecurVision.logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.SecurVision.exceptions.DAOExcepcion;
import com.SecurVision.persistencia.DAL;
import com.SecurVision.persistenciaDTO.PersonaDTO;

public class SecurVisionApp {
	private DAL dal;
	private List<Persona> listaPersonas = new ArrayList<>();

	//Crear Persona
	public Persona crearPersona(String dni, String nombre, String apellidos, int idNivel, int idHorario) throws DAOExcepcion{
		dal.crearPersona(new PersonaDTO(dni,nombre, apellidos, idNivel, idHorario));
		Persona p = new Persona(dni, nombre, apellidos);
		return p;
	}

	//Borrar Persona
	public void borrarPersona(String dni) throws DAOExcepcion{
		dal.borrarPersona(dni);
	}

	//Listar Personas
	public List<Persona> listarPersonas() throws DAOExcepcion{
		List<PersonaDTO> list_users = dal.listarPersonas();
		for (PersonaDTO personaDTO : list_users) {
			listaPersonas.add(new Persona(personaDTO.getDni(), personaDTO.getNombre(), personaDTO.getApellidos()));
		}
		return listaPersonas;
	}
}
