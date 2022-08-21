package com.clickableShapes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Diagram extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		DiagramController controller = new DiagramController();
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Diagram.fxml"));
		fxmlLoader.setController(controller);
		Parent root = fxmlLoader.load();
		primaryStage.setTitle("Clickable Diagram");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}
	
	public static void launchApp(String[] args) {
		launch(args);
	}

}
