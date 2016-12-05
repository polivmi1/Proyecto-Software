
package com.SecurVision.userInterface;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainApp extends Application {

	private static final String APPLICATION_ICON = "img/padlock.png";

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
            primaryStage.getIcons().add(new Image(APPLICATION_ICON));
            primaryStage.getScene().getStylesheets().add(MainApp.class.getResource("/com/SecurVision/userInterface/view/login.css").toExternalForm());
            
            ControladorVentanaLogin controller = loader.getController();
			controller.registerStage(primaryStage);
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	public static void main(String[] args) {
		launch(args);
	}
}
