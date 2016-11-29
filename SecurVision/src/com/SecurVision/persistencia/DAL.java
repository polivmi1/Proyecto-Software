package com.SecurVision.persistencia;

import java.util.*;
import com.SecurVision.logic.*;
import com.SecurVision.persistenciaDTO.PersonaDTO;
import com.SecurVision.exceptions.*;

public class DAL {
		 private static DAL dal;
		 private ICheckeoDAO checkeoDAO;
		 private IPersonaDAO personaDAO;
		 private IUsuarioDAO usuarioDAO;
		 private IZonaDAO zonaDAO;
		 private INivelDAO nivelDAO;

		 //private IFranjaHoraria franjaHorariaDAO;

		 // constructor privado
		 private DAL() throws DAOExcepcion {
			 // Objectos para comunicarse con la capa de acceso a datos
			 checkeoDAO = new CheckeoDAOImp();
			 personaDAO = new PersonaDAOImp();
			 usuarioDAO = new UsuarioDAOImp();
			 zonaDAO = new ZonaDAOImp();
			 nivelDAO = new NivelDAOImp();

			 //franjaHorariaDAO = new FranjaHorariaDAOImp();

		 }

		 // Patron Singleton
		 public static DAL dameDAL() throws DAOExcepcion {
			 if(dal==null)
				 dal = new DAL();
			 return dal;
		 }


		 /****	Metodos para listar objetos	****/
		 /*
		 public List<Checkeo> listarCheckeos() throws DAOExcepcion{
			 return checkeoDAO.listarCheckeos();
		 }

		 public List<Persona> listarPersonas() throws DAOExcepcion{
			 return personaDAO.listarPersonas();
		 }
		 */


		 /****	Metodos para encontrar objetos por su ID	****/

		 /*
		 public Checkeo encontrarCheckeoPorCod(String cod) throws DAOExcepcion{
			 return checkeoDAO.encontrarCheckeoPorCod(cod);
		 }

		 public Persona encontrarPersonaPorCod(String cod) throws DAOExcepcion{
			 return personaDAO.encontrarPersonaPorCod(cod);
		 }


		 public Zona encontrarZonaPorCod(int cod) throws DAOExcepcion{
			 return zonaDAO.encontrarZonaPorCod(cod);
		 }*/

		 /****	Metodos de PersonaDAO	****/

		 public void crearPersona(PersonaDTO p) throws DAOExcepcion{
			 personaDAO.crearPersona(p);
		 }

		 public void borrarPersona(String dni) throws DAOExcepcion{
			 personaDAO.borrarPersona(dni);
		 }

		 public List<PersonaDTO> listarPersonas() throws DAOExcepcion{
			 return personaDAO.listarPersonas();
		 }

}
