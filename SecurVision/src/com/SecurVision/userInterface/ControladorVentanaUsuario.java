package com.SecurVision.userInterface;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.util.List;

import com.SecurVision.exceptions.DAOExcepcion;
import com.SecurVision.logic.Checkeo;
import com.SecurVision.logic.Persona;
import com.SecurVision.logic.SecurVisionApp;

public class ControladorVentanaUsuario {
	
	Frameworks frame = new Frameworks();
	private static final String add="view/AnyadirUsuario.fxml";
	
	SecurVisionApp instance = new SecurVisionApp();
	private List<Persona> personas;
    private ObservableList<Persona> personsObservable;
    
    @FXML
    private TableView <Persona> userTable;

    @FXML
    private TableColumn <Persona, String> dniColumn;

    @FXML
    private TableColumn <Persona, String>nameColumn;

    @FXML
    private TableColumn <Persona, String> apeCollumn;

    @FXML
    private TableColumn <Persona, Integer>levelColumn;

    @FXML
    private TableColumn <Persona, Integer> timeColumn;
	
	
    public ControladorVentanaUsuario(){
    	
    	
    }
    
    
    @FXML
    private void initialize(){
    	//rellenarTabla();
    		
    }
    
    
    @FXML
    void anyadir(ActionEvent event) {
    	frame.showNewStage(event, add);

    }  
    
    private void rellenarTabla(){
    	try {
			personas =instance.listarPersonas();
			//personsObservable = FXCollections.observableArrayList(personas);
			System.out.println(personas);
		} catch (DAOExcepcion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
}