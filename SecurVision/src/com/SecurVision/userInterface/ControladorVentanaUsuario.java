package com.SecurVision.userInterface;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

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
	}





	@FXML
	void anyadir(ActionEvent event) {
		frame.showNewStage(event, add);

	}  

	@FXML
	void borrar(ActionEvent event) throws DAOExcepcion, LogicException {
		String dni=userTable.getSelectionModel().getSelectedItem().getDni();
		for (int aux =0; aux<personsObservable.size();aux++)
			if(personsObservable.get(aux).getDni().equals(dni))
				personsObservable.remove(personsObservable.get(aux));
		svApp.getInstance().borrarPersona(dni);


	} 

	private void rellenarTabla(){
		try {
			personas =svApp.listarPersonas();
			//personsObservable = FXCollections.observableArrayList(personas);
			System.out.println(personas);
		} catch (DAOExcepcion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}