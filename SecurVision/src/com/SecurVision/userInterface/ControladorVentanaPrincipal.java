package com.SecurVision.userInterface;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.SecurVision.logic.Checkeo;

public class ControladorVentanaPrincipal {
   
    @FXML
    private Label fechalabel;
    @FXML
    private Label horalabel;
    
    @FXML
    private TableView<Checkeo> CheckeoTable;
    @FXML
    private TableColumn<Checkeo, Integer> IdCheckeoColumn;
    @FXML
    private TableColumn<Checkeo, String> PersonaDniColumn;
    @FXML
    private TableColumn<Checkeo, Integer> ZonaIdColumn;
    @FXML
    private TableColumn<Checkeo, Date> HoraColumn;
    
    
    private MainApp mainApp;
    private Date date = new Date();
    
    public ControladorVentanaPrincipal(){
    }
    
    @FXML
    private void initialize(){
    		horaFecha();
    		
            IdCheckeoColumn.setCellValueFactory(cellData -> cellData.getValue().idCheckeoProperty().asObject());
            PersonaDniColumn.setCellValueFactory(cellData -> cellData.getValue().PersonaDniProperty());
            ZonaIdColumn.setCellValueFactory(cellData -> cellData.getValue().ZonaIdProperty().asObject());
            HoraColumn.setCellValueFactory(cellData -> cellData.getValue().HoraProperty());
            
    }
    
    @FXML
    private void cerrar(){
    	mainApp.getPrimaryStage().close();
    }
    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        
        //CheckeoTable.setItems();
        
    }
    
    public void horaFecha(){
    	DateFormat fechaFormat = new SimpleDateFormat("dd/MM/yyyy");
    	fechalabel.setText(fechaFormat.format(date));
    	DateFormat horaFormat = new SimpleDateFormat("HH:mm:ss");
    	horalabel.setText(horaFormat.format(date));
    }
    
}
    

    