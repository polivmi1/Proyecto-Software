package com.SecurVision.exceptions;

public class LogicException extends Exception {
		
	private static final long serialVersionUID = -6131450490093376446L;

	public LogicException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public LogicException(Exception e) {
		super(e.getMessage());
		// TODO Auto-generated constructor stub
	}
}

	
