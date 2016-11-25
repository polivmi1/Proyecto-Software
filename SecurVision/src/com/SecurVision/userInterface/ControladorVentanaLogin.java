package com.SecurVision.userInterface;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import com.SecurVision.logic.Checkeo;

public class ControladorVentanaLogin {
    
	@FXML
    private TextField UserIn;
    @FXML
    private TextField PassIn;
	
    private MainApp mainApp;
    private String user = "admin";
    private String pass = "1234";
    
    public ControladorVentanaLogin(){
    }
    
    
    @FXML
    private void initialize(){
    		
    }
    @FXML
    private void Aceptar(){
    	//if(user==UserIn.getText() && pass==PassIn.getText())
    	mainApp.showVentanaPrincipal();
    }
    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        
        
    }
    
    
    
}