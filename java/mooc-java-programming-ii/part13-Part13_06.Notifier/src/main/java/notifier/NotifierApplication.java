package notifier;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class NotifierApplication extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  public void start(Stage window) {
    VBox layout = new VBox();
    TextField input = new TextField();
    Button button = new Button("Update");
    Label label = new Label();

    layout.getChildren().addAll(input, button, label);

    button.setOnAction(e -> {
      label.setText(input.getText());
    });

    Scene scene = new Scene(layout);
    window.setScene(scene);
    window.show();
  }

}
