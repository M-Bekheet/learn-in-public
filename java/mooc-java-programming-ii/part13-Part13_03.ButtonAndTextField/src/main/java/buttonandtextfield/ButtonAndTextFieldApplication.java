package buttonandtextfield;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.FlowPane;

public class ButtonAndTextFieldApplication extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage window) {
    FlowPane componentGroup = new FlowPane();
    Button button = new Button("Simple Button");
    TextField text = new TextField("Text Here");

    componentGroup.getChildren().add(button);
    componentGroup.getChildren().add(text);

    Scene scene = new Scene(componentGroup);
    window.setScene(scene);
    window.show();
  }

}
