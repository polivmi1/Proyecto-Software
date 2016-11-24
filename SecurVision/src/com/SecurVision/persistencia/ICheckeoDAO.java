package com.SecurVision.persistencia;

import com.SecurVision.logic.*;
import com.SecurVision.exceptions.*;
import java.util.List;

public interface ICheckeoDAO {

	public Checkeo encontrarCheckeoPorId(int id)throws DAOExcepcion;
	public List<Checkeo> listarCheckeos() throws DAOExcepcion;
}

