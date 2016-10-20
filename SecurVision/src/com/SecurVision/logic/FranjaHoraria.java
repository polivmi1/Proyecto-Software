package com.SecurVision.logic;

import java.util.Date;

public class FranjaHoraria {

	private Date entrada;
	private Date salida;

		//Constructor
	public FranjaHoraria(Date e, Date s){
		this.entrada = e;
		this.salida = s;
	}

		//Getters and Setters
	public Date getEntrada() {
		return entrada;
	}

	public void setEntrada(Date entrada) {
		this.entrada = entrada;
	}

	public Date getSalida() {
		return salida;
	}

	public void setSalida(Date salida) {
		this.salida = salida;
	}
}
