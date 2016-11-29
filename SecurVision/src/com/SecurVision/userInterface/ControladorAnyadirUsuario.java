package com.SecurVision.userInterface;

import java.io.File;

import com.SecurVision.exceptions.DAOExcepcion;
import com.SecurVision.logic.HorarioEmpleo;
import com.SecurVision.logic.Nivel;
import com.SecurVision.logic.Persona;
import com.SecurVision.logic.SecurVisionApp;
import com.SecurVision.persistencia.DAL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

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

	SecurVisionApp instance;
	Persona newPerson;
	DAL dal;


	@FXML
	void anyadir(ActionEvent event) throws DAOExcepcion {
		//System.out.println(txtDni.getText()+"  "+txtName.getText()+"   "+txtApellidos.getText());


		newPerson = new Persona(txtDni.getText(), txtName.getText(), txtApellidos.getText());
		Nivel nivel = null;
		newPerson.setNivel(nivel);
		HorarioEmpleo horario = null;
		newPerson.setHorario(horario);
		

		//			if(newPerson !=null){
		//				instance.crearPersona(newPerson,newPerson.setNivel(nivel),newPerson.setHorario(horario));
		//			}
		
		//instance.crearPersona(txtDni.getText(), txtName.getText(), txtApellidos.getText(), 1, 1);
		if(newPerson !=null){
			instance.crearPersona(newPerson.getDni(),
								  newPerson.getNombre(),
								  newPerson.getApellidos(),
								  Integer.parseInt("1"),
								  Integer.parseInt("1")
								  );
			
			
			System.out.println(newPerson.getDni() +"  "+
					  newPerson.getNombre()+"     "+
					  newPerson.getApellidos()+"     "+
					  Integer.parseInt("1")+"     "+
					  Integer.parseInt("1")
					  );
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

}