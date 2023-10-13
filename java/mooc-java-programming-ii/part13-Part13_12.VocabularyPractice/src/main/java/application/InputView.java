package application;

import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class InputView {
  private Dictionary dict;

  public InputView(Dictionary dict) {
    this.dict = dict;
  }

  public Parent getView() {
    GridPane layout = new GridPane();

    // Styling
    layout.setHgap(10);
    layout.setVgap(10);
    layout.setAlignment(Pos.CENTER);
    layout.setPadding(new Insets(10, 10, 10, 10));

    Label wordLabel = new Label("Word");
    TextField wordInput = new TextField();
    Label translationLabel = new Label("Translation");
    TextField translationInput = new TextField();

    Button submitBtn = new Button("Add the word pair");

    // Structure
    layout.add(wordLabel, 0, 0);
    layout.add(wordInput, 0, 1);
    layout.add(translationLabel, 0, 2);
    layout.add(translationInput, 0, 3);
    layout.add(submitBtn, 0, 4);

    submitBtn.setOnMouseClicked(e -> {
      dict.add(wordInput.getText(), translationInput.getText());

      wordInput.clear();
      translationInput.clear();
    });

    return layout;
  }

}
