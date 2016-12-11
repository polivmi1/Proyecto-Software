package com.SecurVision.logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.SecurVision.exceptions.DAOExcepcion;
import com.SecurVision.exceptions.LogicException;
import com.SecurVision.persistencia.DAL;
import com.SecurVision.persistenciaDTO.ImagenDTO;
import com.SecurVision.persistenciaDTO.PersonaDTO;

public class SecurVisionApp {
	private DAL dal;

	private HashMap<String,Persona>mapPersonas;
	private static SecurVisionApp instance;

	//Crear Persona

	public Persona crearPersona(String dni, 
			String nombre, 
			String apellidos, 
			int idNivel, 
			int idHorario) throws DAOExcepcion{


		dal.crearPersona(new PersonaDTO(dni,nombre, 
				apellidos, idNivel, idHorario));
		Persona p = new Persona(dni, nombre, apellidos);

		mapPersonas.put(dni,p);

		return p;
	}
	//contiene DNI
	public boolean containsPersona(String dni) throws DAOExcepcion, LogicException{
		/*
		 * Pese a que la estructura del hashmap el correcta [key=value,...]
		 * no funciona el containsKey
		 */

		boolean result=false;

		for(String key : mapPersonas.keySet()){
			if(dni.equals(key)){
				System.out.println("encontrado ->"+key);
				result=true;
			}else
				System.out.println(key+" no igual a "+dni );
		}


		return result;
	}


	//Borrar Persona
	public void borrarPersona(String dni) throws DAOExcepcion{
		Persona p= mapPersonas.get(dni);
		dal.borrarPersona(dni);
		mapPersonas.remove(dni, p);
	}

	//	Listar Personas

	public HashMap<String, Persona> listarPersonas() throws DAOExcepcion{
		List<PersonaDTO> list_users = dal.listarPersonas();

		for (PersonaDTO personaDTO : list_users) {
			for(int i=0; i<list_users.size(); i++){
				if(!mapPersonas.containsKey(personaDTO.getDni())){
					mapPersonas.put(personaDTO.getDni(), new Persona(personaDTO.getDni(), personaDTO.getNombre(), personaDTO.getApellidos()));
				}
			}
		}
		Set keys = mapPersonas.keySet();
		for (Iterator i = keys.iterator(); i.hasNext();) {
			String key =  (String) i.next();
			String value = mapPersonas.get(key).getNombre()+" "+mapPersonas.get(key).getApellidos() ;
			System.out.println(key + " = " + value);
		}
		return mapPersonas;
	}

	//Subir imagen
	//	public Imagen subirImagen(String url, String dni) throws DAOExcepcion{
	//		dal.subirImagen(new ImagenDTO(url, dni));
	//
	//		Persona p = listaPersonas.get(0);
	//		Imagen image = new Imagen(url, p);
	//		return image;
	//	}




	//Patron Singleton
	public static SecurVisionApp getInstance() throws DAOExcepcion, LogicException{
		if(instance==null){
			System.out.println("Creo Instacia SecurVision");
			instance = new SecurVisionApp();
		}
		return instance;
	}

	@SuppressWarnings("static-access")
	public SecurVisionApp() throws DAOExcepcion, LogicException{
		//obtener el DAL
		this.dal = dal.dameDAL();

		//Inicializar los parámetros

		mapPersonas= new HashMap<>();
		cargarSistema();
	}

	private void cargarSistema() throws DAOExcepcion {
		// TODO Auto-generated method stub
		listarPersonas();
	}


}
