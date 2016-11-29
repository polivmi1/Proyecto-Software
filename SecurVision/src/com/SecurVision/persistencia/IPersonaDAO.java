package com.SecurVision.persistencia;

import com.SecurVision.persistenciaDTO.PersonaDTO;
import com.SecurVision.exceptions.*;

import java.util.List;

public interface IPersonaDAO {
	public void crearPersona(PersonaDTO p)throws DAOExcepcion;
	public void borrarPersona(String dni)throws DAOExcepcion;
	public List<PersonaDTO> listarPersonas() throws DAOExcepcion;

}
