package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JokeApplication extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  public void start(Stage window) {

    BorderPane layout = new BorderPane();

    HBox menu = new HBox();
    menu.setAlignment(Pos.CENTER);
    menu.setPadding(new Insets(10, 10, 10, 10));
    menu.setSpacing(10);

    Button jokeBtn = new Button("Joke");
    Button answerBtn = new Button("Answer");
    Button explainBtn = new Button("Explanation");
    menu.getChildren().addAll(jokeBtn, answerBtn, explainBtn);

    // Sub-views
    StackPane jokeView = createView("What do you call a bear with no teeth?");
    StackPane answerView = createView("A gummy bear.");
    StackPane explainView = createView("I really didn't get the joke lol.");

    // Events
    jokeBtn.setOnAction(e -> layout.setCenter(jokeView));
    answerBtn.setOnAction(e -> layout.setCenter(answerView));
    explainBtn.setOnAction(e -> layout.setCenter(explainView));

    // Default View
    layout.setTop(menu);
    layout.setCenter(jokeView);

    Scene scene = new Scene(layout);

    window.setScene(scene);
    window.show();
  }

  private StackPane createView(String text) {
    StackPane view = new StackPane();
    view.setPrefSize(300, 180);
    view.setAlignment(Pos.CENTER);
    view.getChildren().add(new Label(text));
    return view;

  }
}
