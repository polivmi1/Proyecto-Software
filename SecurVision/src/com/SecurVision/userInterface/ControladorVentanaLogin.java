package com.SecurVision.userInterface;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

import com.SecurVision.logic.Checkeo;

public class ControladorVentanaLogin {

	@FXML
	private TextField UserIn;
	@FXML
	private TextField PassIn;

	private String user = "admin";
	private String pass = "1234";

	private Frameworks frame;

	private BorderPane rootLayout;
	private Stage mainStage;

	private static final String mainScene="view/MainLayout.fxml";
	private static final String mainWindow="view/VentanaPrincipal.fxml";
	
	double x, y;

	private void addDragListeners(final Node n, Stage primaryStage){

	    n.setOnMousePressed((MouseEvent mouseEvent) -> {
	        this.x = n.getScene().getWindow().getX() - mouseEvent.getScreenX();
	        this.y = n.getScene().getWindow().getY() - mouseEvent.getScreenY();
	    });

	    n.setOnMouseDragged((MouseEvent mouseEvent) -> {
	        primaryStage.setX(mouseEvent.getScreenX() + this.x);
	        primaryStage.setY(mouseEvent.getScreenY() + this.y);
	    });
	}


	public ControladorVentanaLogin(){
	}


	@FXML
	private void initialize(){

	}
	@FXML
	private void Aceptar(ActionEvent event) {
		//if(user==UserIn.getText() && pass==PassIn.getText())
		showMainStage(event);
		showMainView();
	}


	private void showMainStage(ActionEvent event){
		try {
			Stage Login = (Stage) ((Node) event.getSource()).getScene().getWindow();

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ControladorVentanaLogin.class.getResource(mainScene));
			rootLayout = (BorderPane) loader.load();

			Scene scene = new Scene(rootLayout);

			mainStage = new Stage(StageStyle.UNDECORATED);
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