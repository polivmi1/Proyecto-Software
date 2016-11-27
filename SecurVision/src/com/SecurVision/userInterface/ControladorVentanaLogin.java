package com.SecurVision.userInterface;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Optional;

import com.SecurVision.logic.Checkeo;

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
	private static final String mainWindow="view/VentanaPrincipal.fxml";

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
			Alert();
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
		}
	}
	@FXML
	void Salir() {
		Confirmation();
	}

	void registerStage(Stage stage){
		Login=stage;
	}


	private void showMainStage(ActionEvent event){
		try {
			//

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

	private void Confirmation(){
		Alert alert = new Alert(AlertType.CONFIRMATION);

		Stage dialog =(Stage)alert.getDialogPane().getScene().getWindow();
		dialog.getIcons().add(new Image(APPLICATION_ICON));

		alert.setHeaderText(null);
		alert.setTitle("Saliendo de SecurVision");
		alert.setContentText("\n¿Está seguro que desea Salir?");

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK){
			Platform.exit();
		}else{
			alert.close();
		}

	}
	private void Alert(){
		Alert alert = new Alert(AlertType.WARNING);
		
		Stage dialog =(Stage)alert.getDialogPane().getScene().getWindow();
		dialog.getIcons().add(new Image(APPLICATION_ICON));
		
		alert.setTitle("Usuario no Válido");
		alert.setHeaderText(null);
		alert.setContentText("Usuario/Contraseña Incorrecta");
		userText.clear();
		passText.clear();

		alert.showAndWait();
	}
}