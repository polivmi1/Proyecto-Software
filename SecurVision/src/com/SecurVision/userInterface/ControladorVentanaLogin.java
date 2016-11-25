package com.SecurVision.userInterface;

import javafx.fxml.FXML;

import com.SecurVision.logic.Checkeo;

public class ControladorVentanaLogin {
    
    private MainApp mainApp;
    
    public ControladorVentanaLogin(){
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