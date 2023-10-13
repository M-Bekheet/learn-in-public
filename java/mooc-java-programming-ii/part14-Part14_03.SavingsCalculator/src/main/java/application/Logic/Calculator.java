package application.Logic;

import application.UI.View;
import application.UI.ChartUI;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Slider;

public class Calculator {
  private View view;
  private ChartUI chart;
  private Number savings;
  private Number interestRate;

  public Calculator(View view) {
    this.view = view;
    this.chart = view.getChart();

    Slider savingSlider = view.getSavingSlider().getSlider();
    Slider interestSlider = view.getInterestRateSlider().getSlider();

    interestRate = (int) interestSlider.getValue();
    savings = (int) savingSlider.getValue();

    updateChart();

    savingSlider.valueProperty().addListener((o, oldValue, newValue) -> {
      savings = newValue;
      updateChart();
    });
    interestSlider.valueProperty().addListener((o, oldValue, newValue) -> {
      interestRate = newValue;
      updateChart();
    });
  }

  public void updateChart() {
    XYChart.Series<Number, Number> savingsLine = new XYChart.Series();
    XYChart.Series<Number, Number> interestLine = new XYChart.Series();

    savingsLine.getData().add(new XYChart.Data(0, 0));

    double rate = interestRate.doubleValue() / 100;

    // total savings yearly without the interest
    double fixedSavings = savings.doubleValue() * 12;
    // total savings for each month after adding the
    double lastSaving = 0;
    // interest

    savingsLine.getData().add(new XYChart.Data<Number, Number>(0, 0));
    interestLine.getData().add(new XYChart.Data<Number, Number>(0, 0));

    for (int i = 1; i <= 30; i++) {

      lastSaving = (fixedSavings + lastSaving) * (1 + rate);

      double interest = (fixedSavings + lastSaving) * (rate);
      savingsLine.getData().add(new XYChart.Data<Number, Number>(((Number) i), lastSaving));
      interestLine.getData().add(new XYChart.Data<Number, Number>(((Number) i), interest));
    }

    savingsLine.setName("Balance");
    interestLine.setName("Interest");

    chart.updateChart(savingsLine, interestLine);
  }
}
