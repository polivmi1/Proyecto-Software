package com.SecurVision.userInterface;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Properties;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;

public class ControladorContrasenya {


	@FXML
	private PasswordField passOld;

	@FXML
	private PasswordField passNew;

	@FXML
	private PasswordField passNewRep;


	Frameworks frame= new Frameworks();



	public ControladorContrasenya(){
	}


	@FXML
	private void initialize() throws IOException{

	}

	@FXML
	void aceptar(ActionEvent event) throws IOException {
		Boolean doesTheKeyValuePairExist = 
				frame.checkIfKeyValuePairExists(
						"admin",passOld.getText());
		if(doesTheKeyValuePairExist)
			frame.updateCredentials(
					"admin", passNew.getText());
		else{
			System.out.println("No existe");
		}

	}
}


