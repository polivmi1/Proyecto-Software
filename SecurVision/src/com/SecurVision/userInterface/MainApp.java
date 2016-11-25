package com.SecurVision.userInterface;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {
	
	private Stage primaryStage;
    private BorderPane rootLayout;


	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("SecurVision");
		
		
		initRootLayout();
		
		showLogin();
		
	}
	
	public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("MainLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
            
            ControladorPrincipal controll = loader.getController();
            controll.setMainApp(this);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	
	public void showVentanaPrincipal() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("VentanaPrincipal.fxml"));
            AnchorPane VentanaPrincipal = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(VentanaPrincipal);
            
            ControladorVentanaPrincipal controll = loader.getController();
            controll.setMainApp(this);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	 
	public void showLogin() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("VentanaLogin.fxml"));
            AnchorPane VentanaLogin = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(VentanaLogin);
            
            ControladorVentanaLogin controll = loader.getController();
            controll.setMainApp(this);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public void showVentanaUsuario() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("VentanaUsuario.fxml"));
            AnchorPane VentanaUsuario = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(VentanaUsuario);
            
            ControladorVentanaUsuario controll = loader.getController();
            controll.setMainApp(this);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public Stage getPrimaryStage() {
        return primaryStage;
    }
	
	public static void main(String[] args) {
		launch(args);
	}
}
