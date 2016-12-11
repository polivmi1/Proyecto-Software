package com.SecurVision.persistencia;

import com.SecurVision.logic.*;
import com.SecurVision.persistenciaDTO.ZonaDTO;
import com.SecurVision.exceptions.*;

import java.util.List;

public interface IZonaDAO {

	//public Zona encontrarZonaPorCod(int cod)throws DAOExcepcion;
	public void crearZona(ZonaDTO z)throws DAOExcepcion;
	public List<ZonaDTO> listarZonas() throws DAOExcepcion;
}
