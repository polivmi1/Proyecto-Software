package com.SecurVision.userInterface;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

import com.SecurVision.exceptions.DAOExcepcion;
import com.SecurVision.exceptions.LogicException;
import com.SecurVision.logic.Persona;
import com.SecurVision.logic.SecurVisionApp;

public class ControladorVentanaUsuario {

	Frameworks frame = new Frameworks();
	private static final String add="view/AnyadirUsuario.fxml";

	SecurVisionApp svApp;

	private ObservableMap<String, Persona> mapPersons;
	private ObservableList<Persona> personas;

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

	Stage User;
	private String dni;


	public ControladorVentanaUsuario(){


	}


	@FXML
	private void initialize() throws LogicException, DAOExcepcion{
		rellenarTabla();
		dni="";

		userTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			if(!newValue.getDni().isEmpty()){
				dni=newValue.getDni();
				System.out.println("Slider Value Changed (newValue: " + newValue.getDni() + ")");
			}
		});
	}


	@FXML
	void anyadir(ActionEvent event) {
		User = (Stage) userTable.getScene().getWindow();
		User.close();
		frame.showNoModalStage(event, add);

	}  
	@FXML
	void borrar(ActionEvent event) throws DAOExcepcion, LogicException {
		System.out.println("aaa "+personas.size());
		if(!dni.isEmpty()){
			for (int aux =0; aux<personas.size();aux++)
				if(personas.get(aux).getDni().equals(dni)){
					svApp.getInstance().borrarPersona(dni);
					personas.remove(aux);
					frame.Alert(AlertType.INFORMATION,"Borrar Usuario", "El usuario ha sido eliminado correctamente");	
				}
		}else{
			frame.Alert(AlertType.ERROR,"Borrar Usuario", "Debes seleccionar un elemento de la tabla");	

		}
		dni="";
		System.out.println(personas.size());
		userTable.getSelectionModel().clearSelection();
	} 


	private void rellenarTabla() throws DAOExcepcion, LogicException{
		mapPersons = FXCollections.observableHashMap();


		mapPersons.putAll(svApp.getInstance().listarPersonas());

		personas =  FXCollections.observableArrayList();

		for(String key : mapPersons.keySet()){
			Persona p = mapPersons.get(key);
			personas.add(p);
		}


		dniColumn.setCellValueFactory(cellData ->new ReadOnlyStringWrapper(cellData.getValue().getDni()));
		nameColumn.setCellValueFactory(cellData ->new ReadOnlyStringWrapper(cellData.getValue().getNombre()));
		apeCollumn.setCellValueFactory(cellData ->new ReadOnlyStringWrapper(cellData.getValue().getApellidos()));
		//    	Nivel nivel;
		//		levelColumn.setCellValueFactory(cellData ->new ReadOnlyStringWrapper("1"))));
		//		timeColumn.setCellValueFactory(cellData ->new ReadOnlyStringWrapper("1"))));
		userTable.setItems(personas);
	}


}