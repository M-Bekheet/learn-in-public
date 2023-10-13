package textstatistics;

import java.util.Arrays;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TextStatisticsApplication extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  public void start(Stage window) {
    BorderPane layout = new BorderPane();

    HBox texts = new HBox();
    texts.setSpacing(10);

    Label lettersLabel = new Label("Letters: 0");
    Label wordsLabel = new Label("Words: 0");
    Label longestLabel = new Label("The longest word is: ");

    texts.getChildren().addAll(lettersLabel, wordsLabel, longestLabel);

    TextArea textArea = new TextArea();
    layout.setCenter(textArea);
    layout.setBottom(texts);

    textArea.textProperty().addListener((change, oldValue, newValue) -> {
      String[] parts = newValue.split(" ");
      wordsLabel.setText("Words: " + parts.length);
      lettersLabel.setText("Letters: " + newValue.split("").length);

      String longest = Arrays.stream(parts).sorted((a, b) -> b.length() - a.length()).findFirst().get();
      longestLabel.setText("The longest word is: " + longest);
    });

    Scene scene = new Scene(layout);
    window.setScene(scene);
    window.show();
  }

}
