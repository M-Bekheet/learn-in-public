package application.UI;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class ChartUI {
  private LineChart<Number, Number> chart;

  public ChartUI() {
    NumberAxis xAxis = new NumberAxis("Year", 0, 30, 1);
    NumberAxis yAxis = new NumberAxis();
    chart = new LineChart<Number, Number>(xAxis, yAxis);

  }

  public LineChart getView() {
    return chart;
  }

  public void updateChart(XYChart.Series<Number, Number> savingsLine, XYChart.Series<Number, Number> interestsLine) {
    chart.getData().clear();
    chart.getData().add(savingsLine);
    chart.getData().add(interestsLine);
  }

}
