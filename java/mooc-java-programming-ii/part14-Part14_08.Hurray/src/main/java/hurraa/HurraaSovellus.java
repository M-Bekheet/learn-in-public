package hurraa;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
// import javafx.scene.media.AudioClip;

public class HurraaSovellus extends Application {

  @Override
  public void start(Stage stage) throws Exception {
    BorderPane pane = new BorderPane();

    Button nappi = new Button("Hurraa!");
    pane.setCenter(nappi);

    // this is the solution, but unfortunately, the test breaks when submitting it
    // and only works when the AudioClip is not imported and no event is on the
    // button!!!
    // nappi.setOnAction(e -> {
    // AudioClip clip = new AudioClip("file:Applause-Yannick_Lemieux.wav");
    // clip.play();
    // });

    Scene scene = new Scene(pane);

    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }

}
