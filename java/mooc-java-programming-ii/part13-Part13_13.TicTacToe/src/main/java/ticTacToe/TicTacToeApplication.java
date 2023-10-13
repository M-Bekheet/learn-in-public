package ticTacToe;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TicTacToeApplication extends Application {
  public static void main(String[] args) {
    launch(args);
  }

  public void start(Stage window) {
    BorderPane layout = new BorderPane();
    layout.setPadding(new Insets(30, 30, 30, 30));

    Label header = new Label("Turn: X");
    header.setFont(Font.font("Monospaced", 40));
    layout.setTop(header);

    Grid grid = new Grid(header);
    layout.setCenter(grid.getView());

    Scene scene = new Scene(layout);
    window.setScene(scene);
    window.show();
  }
}
