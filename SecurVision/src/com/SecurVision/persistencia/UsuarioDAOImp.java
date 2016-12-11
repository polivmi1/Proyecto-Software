package com.SecurVision.persistencia;

import java.sql.*;
import com.SecurVision.logic.*;
import com.SecurVision.exceptions.*;
import java.util.*;

public class UsuarioDAOImp implements IUsuarioDAO {
	protected ConnectionManager connManager;
	
	public UsuarioDAOImp() throws DAOExcepcion {
		super();
		// TODO Auto-generated constructor stub
		try{
			connManager = new ConnectionManager("practica4");
		}catch (ClassNotFoundException e){
			throw new DAOExcepcion(e);
		}
	}
}
