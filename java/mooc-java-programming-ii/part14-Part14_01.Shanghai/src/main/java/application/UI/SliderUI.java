package application.UI;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;

public class SliderUI {
  private String title;
  private Slider slider;

  public SliderUI(double min, double max, String title) {

    this.title = title;

    slider = new Slider(min, max, min);
    slider.setShowTickLabels(true);
    slider.setShowTickMarks(true);

  }

  public Parent getView() {
    BorderPane layout = new BorderPane();

    layout.setLeft(getTitleLabel());
    layout.setRight(getValueLabel());
    layout.setCenter(slider);

    return layout;
  }

  private Label getValueLabel() {
    Label label = new Label(String.valueOf(slider.getValue()));

    slider.valueProperty().addListener(
        (observable, oldValue, newValue) -> {
          label.setText(String.valueOf(Math.round(newValue.doubleValue() * 100) / 100.0));
        });
    return label;
  }

  private Label getTitleLabel() {
    Label label = new Label(title);
    label.setMinWidth(110);
    return label;
  }

  public Slider getSlider() {
    return this.slider;
  }

}
