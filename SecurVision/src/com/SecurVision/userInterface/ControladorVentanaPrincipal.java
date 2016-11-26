package com.SecurVision.userInterface;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Duration;

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

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;

		//CheckeoTable.setItems();

	}

	public void horaFecha(){
		DateFormat fechaFormat = new SimpleDateFormat("dd/MM/yyyy");

		DateFormat horaFormat = new SimpleDateFormat("HH:mm:ss");

		setTimeLabel(fechalabel,horalabel,horaFormat,fechaFormat);

	}

	private void setTimeLabel(Label fecha, Label hora, DateFormat TimeFormat, DateFormat Date){
		Timeline timeline = new Timeline(
				new KeyFrame(Duration.seconds(0),
						new EventHandler<ActionEvent>() {
					@Override public void handle(ActionEvent actionEvent) {
						Date time= new Date();
						fecha.setText(Date.format(time));
						hora.setText(TimeFormat.format(time));
					}
				}
						),
				new KeyFrame(Duration.seconds(1))
				);
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();
	}

}


