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
import com.SecurVision.persistenciaDTO.NivelDTO;
import com.SecurVision.persistenciaDTO.PersonaDTO;
import com.SecurVision.persistenciaDTO.ZonaDTO;

public class SecurVisionApp {
	private DAL dal;
	private static SecurVisionApp instance;

	private HashMap<String, Persona>mapPersonas;
	private HashMap<Integer, Nivel>mapNiveles;
	private HashMap<Integer, Zona> mapZonas;


	/**
	 * PERSONA
	 **/
	//Crear Persona
	public Persona crearPersona(String dni, String nombre, String apellidos, int idNivel, int idHorario) throws DAOExcepcion{
		dal.crearPersona(new PersonaDTO(dni,nombre, apellidos, idNivel, idHorario));
		Persona p = new Persona(dni, nombre, apellidos);
		mapPersonas.put(dni,p);
//dff
		return p;
	}

	//contiene DNI
	public boolean containsPersona(String dni) throws DAOExcepcion, LogicException{
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
			if(!mapPersonas.containsKey(personaDTO.getDni())){
				mapPersonas.put(personaDTO.getDni(), new Persona(personaDTO.getDni(), personaDTO.getNombre(), personaDTO.getApellidos()));
			}
		}

		/*Set keys = mapPersonas.keySet();
		for (Iterator i = keys.iterator(); i.hasNext();) {
			String key =  (String) i.next();
			String value = mapPersonas.get(key).getNombre()+" "+mapPersonas.get(key).getApellidos() ;
			System.out.println(key + " = " + value);
		}*/
		return mapPersonas;
	}

	//Subir imagen
	public Imagen subirImagen(String url, String dni) throws DAOExcepcion{
			dal.subirImagen(new ImagenDTO(url, dni));
			Persona p = mapPersonas.get(dni);
			Imagen image = new Imagen(url, p);
			return image;
	}

	/**
	 * NIVEL
	 **/

	//Crear Nivel
	public Nivel crearNivel(int id, String desc) throws DAOExcepcion{
		dal.crearNivel(new NivelDTO(id, desc));
		Nivel n = new Nivel(id, desc);
		mapNiveles.put(id,n);
		return n;
	}

	//Borrar Nivel
	public void borrarNivel(int id) throws DAOExcepcion{
		Nivel n = mapNiveles.get(id);
		dal.borrarNivel(id);
		mapNiveles.remove(id, n);
	}

	//Listar Niveles
	public HashMap<Integer, Nivel> listarNiveles() throws DAOExcepcion{
		List<NivelDTO> list_niveles = dal.listarNiveles();

		for (NivelDTO nivelDTO : list_niveles) {
			if(!mapNiveles.containsKey(nivelDTO.getId())){
				mapNiveles.put(nivelDTO.getId(), new Nivel(nivelDTO.getId(), nivelDTO.getDescripcion()));
			}
		}

		return mapNiveles;
	}

	/**
	 * ZONA
	 **/

	//Crear Zona
	public Zona crearZona(int id, String desc) throws DAOExcepcion{
		dal.crearZona(new ZonaDTO(id, desc));
		Zona z = new Zona(id, desc);
		mapZonas.put(id, z);
		return z;
	}

	//Borrar Nivel
	public void borrarZona(int id) throws DAOExcepcion{
		Zona z = mapZonas.get(id);
		dal.borrarZona(id);
		mapZonas.remove(id, z);
	}

	//Listar Niveles
	public HashMap<Integer, Zona> listarZonas() throws DAOExcepcion{
		List<ZonaDTO> list_zonas = dal.listarZonas();

		for (ZonaDTO zonaDTO : list_zonas) {
			if(!mapZonas.containsKey(zonaDTO.getId())){
				mapZonas.put(zonaDTO.getId(), new Zona(zonaDTO.getId(), zonaDTO.getDescription()));
			}
		}

		return mapZonas;
	}


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

		//Inicializar los par�metros

		mapPersonas = new HashMap<>();
		mapNiveles = new HashMap<>();
		cargarSistema();
	}

	private void cargarSistema() throws DAOExcepcion {
		// TODO Auto-generated method stub
		listarPersonas();
	}


}
