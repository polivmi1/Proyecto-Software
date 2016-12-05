package com.SecurVision.userInterface;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.util.List;

import com.SecurVision.exceptions.DAOExcepcion;
import com.SecurVision.exceptions.LogicException;
import com.SecurVision.logic.Checkeo;
import com.SecurVision.logic.Nivel;
import com.SecurVision.logic.Persona;
import com.SecurVision.logic.SecurVisionApp;

public class ControladorVentanaUsuario {

	Frameworks frame = new Frameworks();
	private static final String add="view/AnyadirUsuario.fxml";

	SecurVisionApp svApp;
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

	Stage User;
	private String dni;


	public ControladorVentanaUsuario(){


	}


	@FXML
	private void initialize() throws LogicException{
		//rellenarTabla();
		try{
			personas=svApp.getInstance().listarPersonas();
			personsObservable=FXCollections.observableArrayList(personas);

			System.out.println(personas.size()+" "+personsObservable.size());
		} catch (DAOExcepcion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		dniColumn.setCellValueFactory(cellData ->new ReadOnlyStringWrapper(cellData.getValue().getDni()));
		nameColumn.setCellValueFactory(cellData ->new ReadOnlyStringWrapper(cellData.getValue().getNombre()));
		apeCollumn.setCellValueFactory(cellData ->new ReadOnlyStringWrapper(cellData.getValue().getApellidos()));
		//    	Nivel nivel;
		//		levelColumn.setCellValueFactory(cellData ->new ReadOnlyStringWrapper("1"))));
		//		timeColumn.setCellValueFactory(cellData ->new ReadOnlyStringWrapper("1"))));
		userTable.setItems(personsObservable);
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

		if(!dni.isEmpty()){
			for (int aux =0; aux<personsObservable.size();aux++)
				if(personsObservable.get(aux).getDni().equals(dni))
					personsObservable.remove(personsObservable.get(aux));
			svApp.getInstance().borrarPersona(dni);
			frame.Alert(AlertType.INFORMATION,"Borrar Usuario", "El usuario ha sido eliminado correctamente");	
		}else{
			frame.Alert(AlertType.ERROR,"Borrar Usuario", "Debes seleccionar un elemento de la tabla");	

		}
		dni="";


	} 


}