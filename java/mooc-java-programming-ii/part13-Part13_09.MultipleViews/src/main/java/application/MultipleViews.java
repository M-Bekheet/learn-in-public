package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MultipleViews extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  public void start(Stage window) {

    // First View
    BorderPane layout = new BorderPane();
    layout.setTop(new Label("First view!"));
    Button toSecond = new Button("To the second view!");
    layout.setCenter(toSecond);
    Scene first = new Scene(layout);

    // Second View
    Button toThird = new Button("To the third view!");
    VBox box = new VBox();
    box.getChildren().addAll(toThird, new Label("Second view!"));
    Scene second = new Scene(box);

    // Third View
    GridPane grid = new GridPane();
    Button toFirst = new Button("To First");

    grid.add(new Label("Third view!"), 0, 0);
    grid.add(toFirst, 1, 1);

    Scene third = new Scene(grid);

    // Events
    toFirst.setOnAction(e -> window.setScene(first));
    toSecond.setOnAction(e -> window.setScene(second));
    toThird.setOnAction(e -> window.setScene(third));

    window.setScene(first);
    window.show();
  }

}
