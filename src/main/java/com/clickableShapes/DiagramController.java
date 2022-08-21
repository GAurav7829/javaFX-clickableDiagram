package com.clickableShapes;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

public class DiagramController{
	
	Data1 data = new Data1();
	Data2 userData = new Data2();
	
	@FXML
    private Ellipse shape1;

    @FXML
    private Ellipse shape2;
    
    @FXML
    private Label path = new Label();

	
	@FXML
    void shape1Handler() {
		if(shape1.getFill()==Color.BLUE) {
			data.getClickedData.add("shape1");
			shape1.setFill(Color.RED);
		} else {
			data.getClickedData.remove("shape1");
			shape1.setFill(Color.BLUE);
		}
		addPath();
		Stage stage = new Stage();
		stage.setScene(new Scene(ShowInput1.getAlertContent(stage, userData)));
		stage.show();
	}

    @FXML
    void shape2Handler() {
    	if(shape2.getFill()==Color.BLUE ) {
    		data.getClickedData.add("shape2");	
    		shape2.setFill(Color.RED);
    	} else {
			data.getClickedData.remove("shape2");
			shape2.setFill(Color.BLUE);
		}
    	addPath();
    	Stage stage = new Stage();
		stage.setScene(new Scene(ShowInput1.getAlertContent(stage, userData)));
		stage.show();
    }
    
    @FXML
    void showPathResult() {
    	data.getClickedData.forEach(System.out::println);
    	addPath();
    	addUserData();
    }
    
    @FXML
    void resetHandler() {
    	shape1.setFill(Color.BLUE);
    	shape2.setFill(Color.BLUE);
    	data.getClickedData.clear();
    	userData.getUserData.clear();
    	addPath();
    }
    
    private void addPath() {
    	String pathText = "";
    	Iterator<String> itr = data.getClickedData.iterator();
    	while(itr.hasNext()) {
    		pathText += itr.next() + "->";
    	}
    	path.setText(pathText);
    }
    
    private void addUserData() {
    	Iterator<String> itr = userData.getUserData.iterator();
    	while(itr.hasNext()) {
    		System.out.println(itr.next());
    	}
    }

}

class Data1{
	Set<String> getClickedData = new LinkedHashSet<>();
}
class Data2 {
	Set<String> getUserData = new LinkedHashSet<>();
}

class ShowInput1 {
	public static GridPane getAlertContent(Stage stage, Data2 data) {
		GridPane pane = new GridPane();

		Label type = new Label("Type: ");
		pane.add(type, 0, 0);
		TextField content1 = new TextField();
		pane.add(content1, 1, 0);

		Button closeBtn = new Button("OK");
		closeBtn.setOnAction(closeStageHandler(stage, data, content1));
		pane.add(closeBtn, 1, 1);

		return pane;
	}

	private static EventHandler<ActionEvent> closeStageHandler(Stage stage, Data2 data, TextField content1) {
		return e -> {
			data.getUserData.add(content1.getText());
			stage.close();
		};
	}
}