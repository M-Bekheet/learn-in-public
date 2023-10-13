package application;

import application.Logic.Calculator;
import application.UI.SliderUI;
import application.UI.View;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class SavingsCalculatorApplication extends Application {
  private Number savings;
  private Number interestRate;

  public static void main(String[] args) {
    launch(args);
  }

  public void start(Stage stage) {
    View view = new View();
    BorderPane layout = view.getView();
    Calculator chartCalculator = new Calculator(view);
    Scene scene = new Scene(layout);
    stage.setScene(scene);
    stage.show();
  }

}
