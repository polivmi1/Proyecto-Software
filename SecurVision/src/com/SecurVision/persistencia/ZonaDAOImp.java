package com.SecurVision.persistencia;

import java.sql.*;

import com.SecurVision.logic.*;
import com.SecurVision.exceptions.*;

import java.util.*;

public class ZonaDAOImp implements IZonaDAO {
	protected ConnectionManager connManager;
	
	public ZonaDAOImp() throws DAOExcepcion {
		super();
		// TODO Auto-generated constructor stub
		try{
			connManager = new ConnectionManager("practica4");
		}catch (ClassNotFoundException e){
			throw new DAOExcepcion(e);
		}
	}
	public void crearZona(Zona in) throws DAOExcepcion {
		// TODO Auto-generated method stub
		try{
			connManager.connect();
			connManager.updateDB("insert into Zona (id, descripcion) values ('" 
			+ in.getId() + "' , '" + in.getDescription() + "')");
			connManager.close();
			System.out.println("Zona creada");
		}catch (Exception e){
			throw new DAOExcepcion(e);
		}
	}
	
	public Zona encontrarZonaPorCod(int cod)throws DAOExcepcion{
		// TODO Auto-generated method stub
		try{
			connManager.connect();
			ResultSet rs = connManager.queryDB("select descripcion from Zona where id = '"+cod+"'");
			connManager.close();
			if (rs.next())
				return new Zona(cod,rs.getString("descripcion"));
			else
				return null;
		}catch (SQLException e){
			throw new DAOExcepcion(e);
		}
	}
	
	@Override
	public List<Zona> listarZonas() throws DAOExcepcion{
		try{
			connManager.connect();
			ResultSet rs=connManager.queryDB("select * from ASESOR");						
			connManager.close();

			List<Zona> listaZonas = new ArrayList<Zona>();
			try{				
				while (rs.next()){
					Zona z = encontrarZonaPorCod(rs.getInt("id"));	 
					listaZonas.add(z);
				}
				return listaZonas;
			}catch (Exception e){
				throw new DAOExcepcion(e);
			}
		}catch (DAOExcepcion e){
			throw e;
		}	
	}
}