package application;

import java.io.File;
import java.util.Scanner;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class PartiesApplication extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  public void start(Stage stage) {
    NumberAxis xAxis = new NumberAxis("Year", 1962, 2012, 4);
    NumberAxis yAxis = new NumberAxis(0, 30, 5);
    yAxis.setLabel("Relative Support (%)");

    LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);

    loadParties(lineChart);

    Scene scene = new Scene(lineChart);
    stage.setScene(scene);
    stage.show();
  }

  private void loadParties(LineChart<Number, Number> lineChart) {
    try {
      File file = new File("partiesdata.tsv");
      Scanner reader = new Scanner(file);
      String[] header = reader.nextLine().split("\t");
      while (reader.hasNextLine()) {
        String[] party = reader.nextLine().split("\t");

        XYChart.Series<Number, Number> line = new XYChart.Series();
        for (int i = 1; i < party.length; i++) {
          if (party[i].equals("-"))
            continue;
          int year = Integer.valueOf(header[i]);
          line.getData().add(new XYChart.Data(year, Double.valueOf(party[i])));
        }

        line.setName(party[0]);
        lineChart.getData().add(line);
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

}
