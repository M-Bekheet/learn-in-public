package textstatistics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class TextStatisticsApplication extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  public void start(Stage window) {
    BorderPane layout = new BorderPane();

    HBox texts = new HBox();
    texts.setSpacing(10);
    texts.getChildren().add(new Label("Letters: 0"));
    texts.getChildren().add(new Label("Words: 0"));
    texts.getChildren().add(new Label("The longest word is:"));

    layout.setCenter(new TextArea("Center"));
    layout.setBottom(texts);

    Scene scene = new Scene(layout);
    window.setScene(scene);
    window.show();
  }

}
