package com.SecurVision.persistencia;

import com.SecurVision.logic.*;
import com.SecurVision.exceptions.*;

import java.util.List;

public interface IZonaDAO {

	public Zona encontrarZonaPorCod(int cod)throws DAOExcepcion;
	public void crearZona(Zona z)throws DAOExcepcion;
	public List<Zona> listarZonas() throws DAOExcepcion;
}
