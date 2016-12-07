package com.SecurVision.userInterface;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControladorAnyadirUsuarioGuardia {

    @FXML
    private TextField txtUser;

    @FXML
    private PasswordField txtPass;

    @FXML
    private PasswordField txtPassConfirm;
    
    
	Frameworks frame=new Frameworks();

	Stage stage;
	
	private static final String user="view/VentanaUsuario.fxml";

	private static final String APPLICATION_ICON = "img/icon.png";
	

    @FXML
    void aceptar(ActionEvent event) {
    	stage=(Stage)txtPass.getScene().getWindow();
    	System.out.println("cierro ventana guardia");
    	stage.close();
    }

    @FXML
    void limpiaFields(ActionEvent event) {
    	System.out.println("limpio fields guardia");
    	txtUser.clear();
    	txtPass.clear();
    	txtPassConfirm.clear();
    }

}
