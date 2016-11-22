package com.SecurVision.exceptions;

public class DAOExcepcion extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DAOExcepcion(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	public DAOExcepcion(Exception e) {
		super(e.getMessage());
		// TODO Auto-generated constructor stub
	}

}
