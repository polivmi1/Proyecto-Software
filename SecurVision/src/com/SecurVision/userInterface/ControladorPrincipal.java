package com.SecurVision.userInterface;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.stage.Stage;

public class ControladorPrincipal {

	@FXML
	private MenuBar menu;

	Frameworks frame = new Frameworks();

	@FXML
	private Menu btnMinimize;
	
	private Stage mainStage;
	

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
	private void VentanaUsuario(){
		//mainApp.showVentanaUsuario();
	}

	public void registerStage(Stage stage) {
		mainStage=stage;
		Frameworks.makeDraggable(stage,menu);
	}



}

/*private static final String LOGGIN_ADMIN= "loggin-admin.fxml";
		 private static final String VER_PERFIL_USUARIO = "ver-perfil-usuario.fxml";
		 //TODO a�adir constantes de tipo String para la vistas correspondientes a los
		//casos de uso Crear Reserva y Listar Reservas de una Sucursal
		 private Stage primaryStage;
		 @FXML
		 void logginGuardia(ActionEvent event) throws LogicException {
		 initCasoDeUso(LOGGIN_ADMIN, ControladorLogginAdmin.class).show();
		 }
		 @FXML
		 void listarClientes(ActionEvent event) throws LogicException {
		 initCasoDeUso(VER_PERFIL_USUARIO, ControladorVerPerfilUsuario.class).show();
		 }

		 @FXML
		 void salir(ActionEvent event) {
		 Platform.exit();
		 }
		 public void setPrimaryStage(Stage primaryStage) {
		 this.primaryStage = primaryStage;
		 }
		 private <T extends ControladorCasoDeUso> T initCasoDeUso(String urlVista,
		Class<T> controlClass) {
		 return ControladorCasoDeUso.initCasoDeUso(urlVista, controlClass,
		primaryStage, ControladorPrincipal.this);
		 }
		}
 */