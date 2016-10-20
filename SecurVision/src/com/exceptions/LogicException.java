package com.SecurVision.exceptions;

	@SuppressWarnings("serial")
	public class LogicException extends Exception {

		public LogicException(String message) {
			super(message);
		}

		public LogicException(Exception e) {
			super(e.getMessage());
		}
	}

	
