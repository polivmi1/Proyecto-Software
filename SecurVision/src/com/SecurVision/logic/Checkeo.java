package com.SecurVision.logic;

import java.util.ArrayList;
import java.util.Date;

import javafx.beans.property.*;

public class Checkeo {

	private IntegerProperty idCheckeo;
	private StringProperty PersonaDni;		//actualizar a tipo Persona
	private IntegerProperty ZonaId;				//actualizar a tipo Zona
	private ObjectProperty<Date> Hora;
	private BooleanProperty Valido;

	//Constructor
	public Checkeo( int idCheckeo, String PersonaDni, int ZonaId, Date Hora, boolean Valido){
		this.idCheckeo = new SimpleIntegerProperty(idCheckeo);
		this.PersonaDni = new SimpleStringProperty(PersonaDni);
		this.ZonaId = new SimpleIntegerProperty(ZonaId);
		this.Hora = new SimpleObjectProperty<Date>(Hora);
		this.Valido = new SimpleBooleanProperty(Valido);
	}

		//Getters and Setters
	public int getIdCheckeo() {
		return idCheckeo.get();
	}
	public void setIdCheckeo(int idCheckeo) {
		this.idCheckeo.set(idCheckeo);
	}
	public IntegerProperty idCheckeoProperty() {
        return idCheckeo;
    }
	
	public String getPersonaDni() {
		return PersonaDni.get();
	}
	public void setPersonaDni(String PersonaDni) {
		this.PersonaDni.set(PersonaDni);
	}
	public StringProperty PersonaDniProperty() {
        return PersonaDni;
    }

	public int getZonaId() {
		return ZonaId.get();
	}
	public void setZonaId(int ZonaId) {
		this.ZonaId.set(ZonaId);
	}
	public IntegerProperty ZonaIdProperty() {
        return ZonaId;
    }
	
	public Date getHora() {
		return Hora.get();
	}
	public void setHora(Date Hora) {
		this.Hora.set(Hora);
	}
	public ObjectProperty<Date> HoraProperty() {
        return Hora;
    }
	
	public boolean getValido() {
		return Valido.get();
	}
	public void setValido(boolean Valido) {
		this.Valido.set(Valido);
	}
	public BooleanProperty ValidoProperty() {
        return Valido;
    }
	
}
