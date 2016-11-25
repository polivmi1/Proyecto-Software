package com.SecurVision.userInterface;

import java.net.URL;
import java.time.LocalDateTime;

import java.time.LocalTime;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import com.SecurVision.logic.*;

public class ControladorLogginAdmin extends ControladorCasoDeUso{
	
	
	@Override
	 public void initialize(URL location, ResourceBundle resources) {
	 stage = new Stage(StageStyle.DECORATED);
	 stage.setTitle("Loggin");
	
	 //Invocamos el servicio encargado de Loggin Administrador
		 
	try {
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	

	 stage.close();
	 };
	 }
