package application.UI;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class View {
  private BorderPane layout;
  private SliderUI savingSlider;
  private SliderUI interestRateSlider;
  private ChartUI chart;

  public View() {
    layout = new BorderPane();
    layout.setPadding(new Insets(10, 10, 10, 10));
    chart = new ChartUI();
    layout.setTop(header());
    layout.setCenter(body());
  }

  public BorderPane getView() {
    return layout;
  }

  private Parent header() {
    this.savingSlider = new SliderUI(25, 250, "Monthly savings");

    this.interestRateSlider = new SliderUI(0, 10, "Yearly interest rate");

    VBox layout = new VBox();
    layout.setSpacing(10);
    layout.getChildren().addAll(savingSlider.getView(), interestRateSlider.getView());
    return layout;
  }

  public LineChart body() {
    return chart.getView();
  }

  public SliderUI getSavingSlider() {
    return savingSlider;
  }

  public SliderUI getInterestRateSlider() {
    return interestRateSlider;
  }

  public ChartUI getChart() {
    return chart;
  }

}
