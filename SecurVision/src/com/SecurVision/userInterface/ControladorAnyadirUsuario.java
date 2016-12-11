package com.SecurVision.userInterface;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

import com.SecurVision.exceptions.DAOExcepcion;
import com.SecurVision.exceptions.LogicException;
import com.SecurVision.logic.HorarioEmpleo;
import com.SecurVision.logic.Nivel;
import com.SecurVision.logic.Persona;
import com.SecurVision.logic.SecurVisionApp;
import com.SecurVision.logic.Zona;
import com.SecurVision.persistencia.DAL;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ControladorAnyadirUsuario{

	@FXML
	private ImageView imgFoto;

	@FXML
	private TextField txtName;

	@FXML
	private TextField txtApellidos;

	@FXML
	private TextField txtDni;

	@FXML
	private ComboBox<?> comboNivel;

	@FXML
	private ComboBox<?> comboTurno;

	@FXML
	private ToggleButton btnGuardia;

	final FileChooser fileChooser = new FileChooser();
	private String photo;
	private String directory;

	SecurVisionApp svApp;
	Persona newPerson;
	Frameworks frame=new Frameworks();

	Stage stage;

	private static final String user="view/VentanaUsuario.fxml";
	private static final String guardia="view/AnyadirUsuarioGuardia.fxml";

	private String dni;
	private static final String APPLICATION_ICON = "img/icon.png";
	
	private ArrayList<String> zonas;

	@FXML
	private void initialize(){
		
		//TODO cambiar cuando esté Nivel, que zonas es para probar
		ObservableMap<Integer, Zona> mapZones = FXCollections.observableHashMap();
		zonas= new ArrayList();


		try {
			mapZones.putAll(svApp.getInstance().listarZonas());
			
			for(int key : mapZones.keySet()){
				Zona z = mapZones.get(key);
				zonas.add(z.getDescription());
			}		
			fillCombo(comboNivel, zonas);
		} catch (DAOExcepcion | LogicException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		System.out.println(zonas.size());
	}

	@SuppressWarnings("static-access")
	@FXML
	void anyadir(ActionEvent event) throws DAOExcepcion, LogicException {
		stage=(Stage) txtDni.getScene().getWindow();
		boolean checkPass=checkElements();

		if(checkPass){

			newPerson = new Persona(txtDni.getText(), txtName.getText(), txtApellidos.getText());
			Nivel nivel = null;
			newPerson.setNivel(nivel);
			HorarioEmpleo horario = null;
			newPerson.setHorario(horario);

			if(newPerson !=null){
				try {
					svApp.getInstance().crearPersona(newPerson.getDni(),
							newPerson.getNombre(),
							newPerson.getApellidos(),
							Integer.parseInt("1"),
							Integer.parseInt("1")
							);
					stage.close();
					if(btnGuardia.isSelected()){
						frame.Alert(AlertType.INFORMATION,"Parámetros Guardia", "Como el usuario creado era un guadia, debe proporcionale credenciales de acceso");	
						frame.showNoModalStage(event,guardia);
					}else{
						frame.Alert(AlertType.INFORMATION,"Nuevo Usuario", "El usuario ha sido creado correctamente en el sistema");	
						frame.showNoModalStage(event,user);
					}
				} catch (NumberFormatException | LogicException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					frame.Alert(AlertType.ERROR,"Nuevo Usuario", "Error Creando nuevo usuario");
				}
			}
		}
	}

	@FXML
	void volver(ActionEvent event) {

	}


	@FXML
	private void selPhoto(ActionEvent event){

		configureFileChooser(fileChooser);
		File file = fileChooser.showOpenDialog(null);
		if (file != null) {
			//openFile(file);
			//Guardamos en la variable directory el Path del fichero
			Image img = new Image(file.toURI().toString());
			directory=file.getAbsolutePath();
			photo=file.getName();
			imgFoto.setImage(img);

		}
	}

	private static void configureFileChooser(
			FileChooser fileChooser) { 
		//Si dabas varias veces al boton "Buscar" duplicaba extensiones, así lo evitamos
		fileChooser.getExtensionFilters().clear();
		fileChooser.setTitle("Selecciona Imagen para el Usuario");
		fileChooser.setInitialDirectory(
				new File(System.getProperty("user.home"))
				);     
		fileChooser.getExtensionFilters().addAll(
				new FileChooser.ExtensionFilter("JPG", "*.jpg"),
				new FileChooser.ExtensionFilter("PNG", "*.png")
				);
	}


	private boolean checkElements() throws DAOExcepcion, LogicException{
		boolean checked=false;
		dni = txtDni.getText();
		if(!svApp.getInstance().containsPersona(dni)){

			if(!txtDni.getText().isEmpty()  &&
					!txtName.getText().isEmpty() &&
					!txtDni.getText().isEmpty()  )
			{
				checked=true;		
			}else{
				frame.Alert(AlertType.WARNING,"Nuevo Usuario", "Comprueba haber rellenado todos los campos");
			}
		}else	
			frame.Alert(AlertType.ERROR,"Error Usuario", "El DNI ya existe en la Base de Datos");	

		return checked;
	}
	
	private void fillCombo(ComboBox combo,ArrayList<String> zonas){
		for(int index=0;index<zonas.size();index++)
			combo.getItems().add(zonas.get(index));
	}
}