package com.SecurVision.persistencia;

import java.sql.*;

import com.SecurVision.logic.*;
import com.SecurVision.exceptions.*;

import java.util.*;

public class CheckeoDAOImp implements ICheckeoDAO {
	protected ConnectionManager connManager;
	
	public CheckeoDAOImp() throws DAOExcepcion {
		super();
		// TODO Auto-generated constructor stub
		try{
			connManager = new ConnectionManager("practica4");
		}catch (ClassNotFoundException e){
			throw new DAOExcepcion(e);
		}
	}
	public void crearCheckeo(Checkeo in) throws DAOExcepcion {
		// TODO Auto-generated method stub
		try{
			
		}catch (Exception e){
			throw new DAOExcepcion(e);
		}
	}
	
	
}
