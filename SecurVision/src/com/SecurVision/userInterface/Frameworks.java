package com.SecurVision.userInterface;

import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Frameworks {

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

}
