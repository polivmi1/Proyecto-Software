package com.SecurVision.userInterface;

import com.SecurVision.exceptions.LogicException;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;


public class ControladorPrincipal {
	
	private MainApp mainApp;
	
	public ControladorPrincipal(){
    }
	@FXML
	private void initialize(){
		
	}
	@FXML
    private void Cerrar(){
		mainApp.getPrimaryStage().close();
	}
	@FXML
    private void VentanaPrincipal(){
		mainApp.showVentanaPrincipal();
	}
	public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
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