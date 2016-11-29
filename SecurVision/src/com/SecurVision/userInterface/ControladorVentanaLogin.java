package com.SecurVision.userInterface;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class ControladorVentanaLogin {

	@FXML
	private TextField userText;

	@FXML
	private PasswordField passText;

	private static final String APPLICATION_ICON = "img/icon.png";


	private String user = "admin";
	private String pass = "1234";

	private BorderPane rootLayout;
	private Stage mainStage;
	private Stage Login;
	private static final String mainScene="view/MainLayout.fxml";
	private static final String mainWindow="view/VentanaPrincipalTest.fxml";
	
	Frameworks frame= new Frameworks();

	public ControladorVentanaLogin(){
	}


	@FXML
	private void initialize(){
		
		

	}
	@FXML
	private void Aceptar(ActionEvent event) {
		if(userText.getText().equals(user) && passText.getText().equals(pass)){
			showMainStage(event);
			showMainView();
		}else{
	    	frame.Alert(AlertType.WARNING, "Usuario Incorrecto", "Ha introducido "
	    			+ "usuario/contraseña incorrecto/s");
			userText.clear();
			passText.clear();
		}
	}

	@FXML
	public void buttonPressed(KeyEvent e)
	{

		if(e.getCode().toString().equals("ENTER")){
			System.out.println("intro");
			Aceptar(null);

		}else if(e.getCode().toString().equals("ESCAPE")){
			System.out.println("escape");
			Salir();
		}else if (e.getCode().equals(KeyCode.TAB)) {
			System.out.println("TAB");
			userText.setFocusTraversable(true);
			if(userText.isFocused())
				passText.setFocusTraversable(true);
			else if(passText.isFocused())
				userText.setFocusTraversable(true);
			
		}
	}
	@FXML
	void Salir() {
		frame.Alert(AlertType.CONFIRMATION, "Saliendo de SecurVision", "¿Está seguro que desea Salir?");
	}

	void registerStage(Stage stage){
		Login=stage;
	}


	private void showMainStage(ActionEvent event){
		try {

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ControladorVentanaLogin.class.getResource(mainScene));
			rootLayout = (BorderPane) loader.load();

			Scene scene = new Scene(rootLayout);

			mainStage = new Stage(StageStyle.UNDECORATED);
			mainStage.getIcons().add(new Image(APPLICATION_ICON));

			mainStage.setScene(scene);
			Login.hide();
			ControladorPrincipal controller = loader.getController();
			controller.registerStage(mainStage);
			mainStage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showMainView() {
		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource(mainWindow));
			AnchorPane main = (AnchorPane) loader.load();

			rootLayout.setCenter(main);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}