package com.SecurVision.logic;

import java.util.HashMap;
import java.util.List;

import com.SecurVision.exceptions.DAOExcepcion;
import com.SecurVision.persistencia.DAL;
import com.SecurVision.persistenciaDTO.ImagenDTO;
import com.SecurVision.persistenciaDTO.PersonaDTO;

public class SecurVisionApp {
	private DAL dal;
	private HashMap<String,Persona> listaPersonas = new HashMap<>();

	//Crear Persona
	public Persona crearPersona(String dni, String nombre, String apellidos, int idNivel, int idHorario) throws DAOExcepcion{
		dal.crearPersona(new PersonaDTO(dni,nombre, apellidos, idNivel, idHorario));
		Persona p = new Persona(dni, nombre, apellidos);
		listaPersonas.put(dni, p);
		return p;
	}

	//Borrar Persona
	public void borrarPersona(String dni) throws DAOExcepcion{
		dal.borrarPersona(dni);
		listaPersonas.remove(dni);

	}

	//Listar Personas
	public HashMap<String, Persona> listarPersonas() throws DAOExcepcion{
		List<PersonaDTO> list_users = dal.listarPersonas();

		for (PersonaDTO personaDTO : list_users) {
			for(int i=0; i<listaPersonas.size(); i++){
				if(!listaPersonas.containsKey(personaDTO.getDni())){
					listaPersonas.put(personaDTO.getDni(), new Persona(personaDTO.getDni(), personaDTO.getNombre(), personaDTO.getApellidos()));
				}
			}
		}

		return listaPersonas;
	}

	//Subir imagen
	public Imagen subirImagen(String url, String dni) throws DAOExcepcion{
		dal.subirImagen(new ImagenDTO(url, dni));

		Persona p = listaPersonas.get(dni);
		Imagen image = new Imagen(url, p);
		return image;
	}
}
