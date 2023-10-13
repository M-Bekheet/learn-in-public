package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

// END SOLUTION
public class VocabularyPracticeApplication extends Application {
  private Dictionary dictionary;

  public static void main(String[] args) {
    launch(args);
  }

  public void init() throws Exception {
    this.dictionary = new Dictionary();
  }

  public void start(Stage window) throws Exception {

    HBox menu = new HBox();
    Button addBtn = new Button("Enter new words");
    Button practiceBtn = new Button("Practice");

    // styling menu
    menu.setSpacing(10);
    menu.setPadding(new Insets(20, 20, 20, 20));
    menu.setAlignment(Pos.CENTER);
    menu.getChildren().addAll(addBtn, practiceBtn);

    // Elements
    InputView inputView = new InputView(dictionary);
    PracticeView practiceView = new PracticeView(dictionary);

    // Structure
    BorderPane layout = new BorderPane();
    layout.setTop(menu);
    layout.setCenter(inputView.getView());

    // Events
    addBtn.setOnMouseClicked(e -> {
      layout.setCenter(inputView.getView());
    });
    practiceBtn.setOnMouseClicked(e -> {
      // if (dictionary.size() > 0)
      layout.setCenter(practiceView.getView());
    });

    Scene scene = new Scene(layout, 400, 300);
    window.setScene(scene);
    window.show();

  }
}
