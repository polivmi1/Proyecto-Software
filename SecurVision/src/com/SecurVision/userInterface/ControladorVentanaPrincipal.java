package com.SecurVision.userInterface;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ControladorVentanaPrincipal {
   
    @FXML
    private Label fechalabel;
    @FXML
    private Label horalabel;
    
    private MainApp mainApp;
    private Date date = new Date();
    
    public ControladorVentanaPrincipal(){
    }
    
    @FXML
    private void initialize(){
    		horaFecha();
    }
    
    @FXML
    private void cerrar(){
    	mainApp.getPrimaryStage().close();
    }
    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    
    public void horaFecha(){
    	DateFormat fechaFormat = new SimpleDateFormat("dd/MM/yyyy");
    	DateFormat horaFormat = new SimpleDateFormat("HH:mm:ss");
    	fechalabel.setText(fechaFormat.format(date));
    	horalabel.setText(horaFormat.format(date));
    }
    
}
    

    