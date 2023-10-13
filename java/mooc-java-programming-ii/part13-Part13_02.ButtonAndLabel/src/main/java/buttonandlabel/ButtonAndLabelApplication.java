package buttonandlabel;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.FlowPane;

public class ButtonAndLabelApplication extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage window) {
    FlowPane componentGroup = new FlowPane();
    Button button = new Button("Simple Button");
    Label text = new Label("Text Here");

    componentGroup.getChildren().add(text);
    componentGroup.getChildren().add(button);

    Scene scene = new Scene(componentGroup);
    window.setScene(scene);
    window.show();
  }

}
