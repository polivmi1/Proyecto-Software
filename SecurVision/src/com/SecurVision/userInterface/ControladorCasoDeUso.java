package com.SecurVision.userInterface;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public abstract class ControladorCasoDeUso implements Initializable {
	protected Stage stage;
	protected ControladorPrincipal controladorPrincipal;
	public void setControladorPrincipal(ControladorPrincipal controladorPrincipal) {
	 this.controladorPrincipal = controladorPrincipal;
	}
	public Stage getStage() {
		return stage;
	}

	public void show() {
		stage.show();
	}

	public static <T extends ControladorCasoDeUso> T initCasoDeUso(String urlVista, Class<T> controlClass, Stage owner,
			ControladorPrincipal controladorPrincipal) {
		FXMLLoader fxmlLoader = new
				FXMLLoader(ControladorCasoDeUso.class.getResource(urlVista));
		T controlador = null;
		try {
			Parent parent = fxmlLoader.load();
			controlador = fxmlLoader.getController();
			controlador.stage.setScene(new Scene(parent));
			controlador.stage.initOwner(owner);
			controlador.setControladorPrincipal(controladorPrincipal);
		} catch (NullPointerException | IOException e) {
			e.printStackTrace();
		}
		return controlador;
	}
}