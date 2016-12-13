package com.SecurVision.persistencia;

import com.SecurVision.persistenciaDTO.UsuarioDTO;
import com.SecurVision.exceptions.*;

public interface IUsuarioDAO {
	public void crearUsuario(UsuarioDTO p)throws DAOExcepcion;
	public void borrarUsuario(String dni)throws DAOExcepcion;

}
