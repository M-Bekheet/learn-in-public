package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class PracticeView {
  private Dictionary dict;
  private String randomWord;

  public PracticeView(Dictionary dict) {
    this.dict = dict;

  }

  public Parent getView() {
    GridPane layout = new GridPane();
    String randomWord = dict.getRandomWord();

    // Styling
    layout.setHgap(10);
    layout.setVgap(10);
    layout.setPadding(new Insets(10, 10, 10, 10));
    layout.setAlignment(Pos.CENTER);

    // Elements
    Label wordLabel = new Label("Translate the word '" + randomWord + "'");
    TextField answerInput = new TextField();
    Button checkBtn = new Button("Check");
    Label result = new Label("");

    // Structure
    layout.add(wordLabel, 0, 0);
    layout.add(answerInput, 0, 1);
    layout.add(checkBtn, 0, 2);
    layout.add(result, 0, 3);

    // event
    checkBtn.setOnMouseClicked(e -> {
      String translation = dict.get(randomWord);
      String answer = answerInput.getText();
      if (answer.equals(translation)) {
        result.setText("Correct!");
      } else {
        result.setText("Incorrect! The translation for the word '" + randomWord + "' is '" + translation + "'.");
        return;
      }
      answerInput.clear();
      this.randomWord = dict.getRandomWord();

    });
    return layout;
  }
}
