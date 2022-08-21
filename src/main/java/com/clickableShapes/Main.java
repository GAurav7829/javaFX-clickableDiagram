package com.clickableShapes;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.QuadCurve;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// Border Top
		Label label = new Label("Clickable Shapes");

		HBox top = new HBox();
		top.setAlignment(Pos.CENTER);
		top.getChildren().add(label);

		// Border Center
		Line line = new Line(155, 155, 355, 155);
		line.setStroke(Color.BLUE);
		Text text = new Text("Some Text\nSome Text");
		text.setRotate(45);

		StackPane stackPane = new StackPane();
		stackPane.getChildren().addAll(line, text);

//		QuadCurve quadCurve = new QuadCurve(180, 100, 240, 50, 320, 100);
//		quadCurve.setStroke(Color.RED);

		Data data = new Data();

		Ellipse ellipse = new Ellipse(100, 100, 55, 45);
		ellipse.setOnMouseClicked(e -> {
			Stage stage = new Stage();
			stage.setScene(new Scene(ShowInput.getAlertContent(stage, data)));
			stage.show();
		});

		Ellipse ellipse2 = new Ellipse(300, 100, 55, 44);
		ellipse2.setOnMouseClicked(e -> {
			Stage stage = new Stage();
			stage.setScene(new Scene(ShowInput.getAlertContent(stage, data)));
			stage.show();
		});

		Rectangle rectangle = new Rectangle(10, 100, 50, 40);

		AnchorPane root = new AnchorPane();
		root.getChildren().addAll(ellipse, ellipse2, rectangle, stackPane);
		root.setStyle("-fx-background-color: white;");

		// Border Bottom
		Button btn = new Button("Show Data");
		btn.setOnAction(e -> {
			System.out.println(data.getContent1());
		});

		BorderPane pane = new BorderPane();
		pane.setTop(top);
		pane.setCenter(root);
		pane.setBottom(btn);

		Scene scene = new Scene(pane, 500, 400);

		primaryStage.setTitle("Clickable Shapes");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void launchApp(String[] args) {
		launch(args);
	}

}

class ShowInput {
	public static GridPane getAlertContent(Stage stage, Data data) {
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

	private static EventHandler<ActionEvent> closeStageHandler(Stage stage, Data data, TextField content1) {
		return e -> {
			data.setContent1(content1.getText());
			System.out.println(data.getContent1());
			stage.close();
		};
	}
}

class Data {
	private String content1;

	public String getContent1() {
		return content1;
	}

	public void setContent1(String content1) {
		this.content1 = content1;
	}

}