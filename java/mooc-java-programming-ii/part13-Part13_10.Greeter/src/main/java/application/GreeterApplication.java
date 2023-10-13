package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GreeterApplication extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  public void start(Stage window) {
    /*
     * First Scene
     */
    GridPane grid = new GridPane();
    Label label = new Label("Enter your name and start.");
    TextField input = new TextField();
    Button button = new Button("Start");
    // Styling
    grid.setPrefSize(300, 180);
    grid.setPadding(new Insets(20, 20, 20, 20));
    grid.setVgap(10);
    grid.setAlignment(Pos.CENTER);
    // Structure
    grid.add(label, 0, 0);
    grid.add(input, 0, 1);
    grid.add(button, 0, 2);
    Scene first = new Scene(grid);

    /*
     * Second Scene
     */
    StackPane stack = new StackPane();
    // Styling
    stack.setPrefSize(300, 180);
    stack.setAlignment(Pos.CENTER);
    // Structure
    Label welcomeMsg = new Label("Welcome !");
    stack.getChildren().add(welcomeMsg);
    Scene second = new Scene(stack);

    /*
     * Events
     */
    // Scenes Switch Event
    button.setOnAction(e -> window.setScene(second));
    // Name Input Change Event
    input.textProperty().addListener((change, oldValue, newValue) -> welcomeMsg.setText("Welcome " + newValue + "!"));

    window.setScene(first);
    window.show();
  }
}
