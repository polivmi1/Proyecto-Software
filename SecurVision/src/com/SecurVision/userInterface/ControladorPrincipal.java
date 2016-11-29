package com.SecurVision.userInterface;

import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ControladorPrincipal {

	@FXML
	private MenuBar menu;

	Frameworks frame = new Frameworks();

	@FXML
	private Menu btnMinimize;

	private Stage mainStage;
	
	private static final String user="view/VentanaUsuario.fxml";


	public ControladorPrincipal(){
	}


	@FXML
	private void initialize(){

	}
	@FXML
	private void Cerrar(){
		Platform.exit();
	}

	@FXML
	private void btnMinimize(){
		System.out.println("minimizo");
		mainStage.setIconified(true);
	}


	@FXML
	private void VentanaUsuario(ActionEvent event){
		System.out.println("ventana Usuario");
		frame.showNewStage(event,user);
	}
	
    @FXML
    void Zona(ActionEvent event) {
    	frame.Alert(AlertType.INFORMATION, "Ventana Zona", "Este Apartado será desarrollado "
    			+ "en el tercer Sprint");
    }
    
    @FXML
    void Nivel(ActionEvent event) {
    	frame.Alert(AlertType.INFORMATION, "Ventana Nivel", "Este Apartado será desarrollado "
    			+ "en el tercer Sprint");
    }
    
    @FXML
    void Ayuda(ActionEvent event) {
    	frame.Alert(AlertType.INFORMATION, "Ayuda", "Este Apartado será desarrollado "
    			+ "en el tercer Sprint");
    }

	public void registerStage(Stage stage) {
		mainStage=stage;
		Frameworks.makeDraggable(stage,menu);
	}


}
