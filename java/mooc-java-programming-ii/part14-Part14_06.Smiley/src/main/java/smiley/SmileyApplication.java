package smiley;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SmileyApplication extends Application {
  public static void main(String[] args) {
    launch(args);
  }

  public void start(Stage window) {

    Canvas canvas = new Canvas(800, 600);
    GraphicsContext painter = canvas.getGraphicsContext2D();

    painter.setFill(Color.WHITE);

    ColorPicker palette = new ColorPicker();

    // set white background
    painter.setFill(Color.WHITE);
    painter.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

    // change the color of the painter
    painter.setFill(Color.BLACK);

    int x1 = 300;
    int y1 = 150;
    int w = 40;

    painter.fillRect(x1, y1, w, w);
    painter.fillRect(x1 + 3 * w, y1, w, w);
    painter.fillRect(x1 - w, y1 * 2, w, w);
    painter.fillRect(x1 + 4 * w, y1 * 2, w, w);
    painter.fillRect(x1, y1 * 2 + w, 4 * w, w);

    BorderPane layout = new BorderPane();

    layout.setCenter(canvas);

    Scene scene = new Scene(layout);
    window.setScene(scene);
    window.show();
  }
}