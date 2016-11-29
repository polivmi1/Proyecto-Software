package com.SecurVision.userInterface;

import java.io.IOException;
import java.util.Optional;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Frameworks {

	private static final String APPLICATION_ICON = "img/icon.png";

	//Parametros para hacerla Arrastrable
	private double desplazX=0;
	private double desplazY=0;


	public void setArrastrable(Parent page, Stage PopUpStage){
		/*Para hacerla arrastrable*/

		//Tomamos la posición actual al pulsar con el ratón
		page.setOnMousePressed((evento)	->	{
			desplazX = evento.getSceneX();
			desplazY = evento.getSceneY();
		});

		//Actualizamos la posición al desplazar
		//mientras está pulsado (arrastramos) (drag)

		page.setOnMouseDragged((evento)	->	{
			PopUpStage.setX(evento.getScreenX() - desplazX);
			PopUpStage.setY(evento.getScreenY() - desplazY);
		});
		/*Fin código para hacerla arrastrable*/
	}


	///Arratrable pero a partir de nodo y parent
	public static void makeDraggable(final Stage stage, final Node byNode) {
		final Delta dragDelta = new Delta();
		byNode.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent mouseEvent) {
				// record a delta distance for the drag and drop operation.
				dragDelta.x = stage.getX() - mouseEvent.getScreenX();
				dragDelta.y = stage.getY() - mouseEvent.getScreenY();
				byNode.setCursor(Cursor.MOVE);
			}
		});
		byNode.setOnMouseReleased(new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent mouseEvent) {
				byNode.setCursor(Cursor.HAND);
			}
		});
		byNode.setOnMouseDragged(new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent mouseEvent) {
				stage.setX(mouseEvent.getScreenX() + dragDelta.x);
				stage.setY(mouseEvent.getScreenY() + dragDelta.y);
			}
		});
		byNode.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent mouseEvent) {
				if (!mouseEvent.isPrimaryButtonDown()) {
					byNode.setCursor(Cursor.HAND);
				}
			}
		});
		byNode.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent mouseEvent) {
				if (!mouseEvent.isPrimaryButtonDown()) {
					byNode.setCursor(Cursor.DEFAULT);
				}
			}
		});
	}

	/** records relative x and y co-ordinates. */
	private static class Delta {
		double x, y;
	}

	public void showNewStage(ActionEvent event,String fxml){
		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
			AnchorPane window = (AnchorPane) loader.load();

			Stage newStage = new Stage(StageStyle.UTILITY);
			newStage.getIcons().add(new Image(APPLICATION_ICON));
			Scene scene = new Scene (window);
			newStage.setScene(scene);
			newStage.initModality(Modality.APPLICATION_MODAL);

			newStage.showAndWait();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected void Alert(AlertType type, String title, String content){
		Alert alert = new Alert(type);

		Stage dialog =(Stage)alert.getDialogPane().getScene().getWindow();
		dialog.getIcons().add(new Image(APPLICATION_ICON));

		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(content);

		if(type!=AlertType.CONFIRMATION)
			alert.showAndWait();
		else{
			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK){
				Platform.exit();
			}else{
				alert.close();
			}
		}

	}

}
