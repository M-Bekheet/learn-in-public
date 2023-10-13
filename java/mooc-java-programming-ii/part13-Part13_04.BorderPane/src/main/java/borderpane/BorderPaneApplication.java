package borderpane;

import javafx.scene.layout.BorderPane;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;

public class BorderPaneApplication extends Application {

  public static void main(String[] args) {
    launch(BorderPaneApplication.class);
  }

  public void start(Stage window) {
    BorderPane pane = new BorderPane();

    pane.setTop(new Label("NORTH"));
    pane.setBottom(new Label("SOUTH"));
    pane.setRight(new Label("EAST"));
    pane.setLeft(new Label("WEST"));

    Scene scene = new Scene(pane);
    window.setScene(scene);
    window.show();
  }

}
