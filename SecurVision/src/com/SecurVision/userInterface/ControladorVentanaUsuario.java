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
    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        
        
    }
    
    
    
}