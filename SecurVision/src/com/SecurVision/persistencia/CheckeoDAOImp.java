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
			connManager = new ConnectionManager("bd");
		}catch (ClassNotFoundException e){
			throw new DAOExcepcion(e);
		}
	}
	
	public Checkeo encontrarCheckeoPorId(int id) throws DAOExcepcion{
		// TODO Auto-generated method stub
		try{
			connManager.connect();
			ResultSet rs = connManager.queryDB("select hora, valido, Persona_dni, Zona_id "
					+ "from Checkeo where idCheckeo = '"+id+"'");
			connManager.close();
			if (rs.next())
				return new Checkeo(id, rs.getString("Persona_dni"), rs.getInt("Zona_id"),
						rs.getDate("hora"),rs.getBoolean("valido"));
			else
				return null;
		}catch (SQLException e){
			throw new DAOExcepcion(e);
		}
	}
	
	@Override
	public List<Checkeo> listarCheckeos() throws DAOExcepcion{
		try{
			connManager.connect();
			ResultSet rs=connManager.queryDB("select * from Checkeo");						
			connManager.close();

			List<Checkeo> listaCheckeoView = new ArrayList<Checkeo>();
			try{				
				while (rs.next()){
					Checkeo chk = encontrarCheckeoPorId(rs.getInt("IdCheckeo"));	 
					listaCheckeoView.add(chk);
				}
				return listaCheckeoView;
			}catch (Exception e){
				throw new DAOExcepcion(e);
			}
		}catch (DAOExcepcion e){
			throw e;
		}	
	}
	
}
