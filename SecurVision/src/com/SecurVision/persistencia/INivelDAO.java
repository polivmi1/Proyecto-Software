package com.SecurVision.persistencia;

import com.SecurVision.persistenciaDTO.NivelDTO;
import com.SecurVision.exceptions.*;
import java.util.List;

public interface INivelDAO {
	public void crearNivel(NivelDTO n) throws DAOExcepcion;
	public void borrarNivel(int id) throws DAOExcepcion;
	public List<NivelDTO> listarNiveles() throws DAOExcepcion;
}
