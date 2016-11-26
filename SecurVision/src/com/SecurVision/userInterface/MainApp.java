package com.SecurVision.userInterface;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainApp extends Application {

	private Stage primaryStage;

    Frameworks frame= new Frameworks();


	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;

		showLogin();

	}

	public void showLogin() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/VentanaLogin.fxml"));
            AnchorPane VentanaLogin = (AnchorPane) loader.load();

            Scene scene = new Scene(VentanaLogin);

    		primaryStage.setTitle("SecurVision");

    		primaryStage.initStyle(StageStyle.UNDECORATED);
            primaryStage.setScene(scene);
            frame.setArrastrable(VentanaLogin,primaryStage );
            
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	public static void main(String[] args) {
		launch(args);
	}
}
