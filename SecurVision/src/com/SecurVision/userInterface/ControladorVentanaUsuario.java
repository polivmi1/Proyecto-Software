package com.SecurVision.userInterface;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import com.SecurVision.logic.Checkeo;

public class ControladorVentanaUsuario {
	
    private MainApp mainApp;
    
    
    public ControladorVentanaUsuario(){
    }
    
    
    @FXML
    private void initialize(){
    		
    }
    @FXML
    private void Aceptar(){
    	mainApp.showVentanaPrincipal();
    }
    
    @FXML
    private void CrearUser(){
    	mainApp.showDialogUsuario();
    }
    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        
        
    }
    
    
    
}