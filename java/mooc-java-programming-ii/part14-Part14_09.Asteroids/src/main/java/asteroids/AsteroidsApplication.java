package asteroids;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import asteroids.character.Asteroid;
import asteroids.character.Projectile;
import asteroids.character.Ship;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AsteroidsApplication extends Application {

  public static int WIDTH = 800;
  public static int HEIGHT = 500;
  private boolean gameOver = false;

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage stage) throws Exception {
    Pane pane = new Pane();
    pane.setPrefSize(WIDTH, HEIGHT);

    Ship ship = new Ship(WIDTH / 2, HEIGHT / 2);
    pane.getChildren().add(ship.getCharacter());

    Text pointsText = new Text(10, 20, "Points: 0");
    pane.getChildren().add(pointsText);
    Text bestScoreText = new Text(100, 20, "Best Score: 0");
    pane.getChildren().add(bestScoreText);
    Text gameOverText = new Text(WIDTH / 2 - 200, (HEIGHT * 2) / 3, "Game Over!! To Restart, Press Enter");
    gameOverText.setFont(Font.font("Monospaced", 20));
    gameOverText.setFill(Color.RED);

    AtomicInteger points = new AtomicInteger(0);
    AtomicInteger bestScore = new AtomicInteger(0);

    Scene scene = new Scene(pane);

    /*
     * ==> Add Random Asteroids
     */
    ArrayList<Asteroid> asteroids = regenerateAsteroids(new ArrayList(), pane);

    // Projectiles Holder
    ArrayList<Projectile> projectiles = new ArrayList<>();

    /*
     * ==> Events
     */

    Map<KeyCode, Boolean> pressedKeys = new HashMap<>();

    scene.setOnKeyPressed(e -> {
      pressedKeys.put(e.getCode(), Boolean.TRUE);
    });

    scene.setOnKeyReleased(e -> {
      pressedKeys.put(e.getCode(), Boolean.FALSE);
    });

    new AnimationTimer() {
      @Override
      public void handle(long now) {

        if (gameOver && !pane.getChildren().contains(gameOverText))
          pane.getChildren().add(gameOverText);

        // restart the game: This is not required in the problem task
        if (gameOver && pressedKeys.getOrDefault(KeyCode.ENTER, false)) {

          // reset asteroids
          regenerateAsteroids(asteroids, pane);
          // reset points
          points.set(0);
          pointsText.setText("Points: 0");
          // reset projectiles
          projectiles.stream().forEach(projectile -> pane.getChildren().remove(projectile.getCharacter()));
          projectiles.clear();
          // reset ship
          ship.setMovement(new Point2D(0, 0));
          ship.getCharacter().setTranslateX(WIDTH / 2);
          ship.getCharacter().setTranslateY(HEIGHT / 2);
          ship.getCharacter().setRotate(270);
          // Remove game over text
          pane.getChildren().remove(gameOverText);
          // restart the game again
          setGameOver(false);
        }

        if (gameOver)
          return;

        // turn left
        if (pressedKeys.getOrDefault(KeyCode.LEFT, false)) {
          ship.turnLeft();
        }
        // turn right
        if (pressedKeys.getOrDefault(KeyCode.RIGHT, false)) {
          ship.turnRight();
        }
        // acceleration
        if (pressedKeys.getOrDefault(KeyCode.UP, false)) {
          ship.accelerate();
        }

        // We shoot projectiles
        if (pressedKeys.getOrDefault(KeyCode.SPACE, false) && projectiles.size() < 3) {
          Projectile projectile = new Projectile((int) (ship.getCharacter().getTranslateX()),
              (int) ship.getCharacter().getTranslateY());

          projectile.getCharacter().setRotate(ship.getCharacter().getRotate());
          projectile.accelerate();
          projectile.setMovement(projectile.getMovement().normalize().multiply(3));

          projectiles.add(projectile);
          pane.getChildren().add(projectile.getCharacter());
        }

        // Randomly add asteroids
        if (Math.random() < 0.005) {
          Asteroid asteroid = new Asteroid(WIDTH, HEIGHT);
          if (!asteroid.collided(ship)) {
            asteroids.add(asteroid);
            pane.getChildren().add(asteroid.getCharacter());
          }
        }

        ship.move();
        asteroids.forEach(asteroid -> asteroid.move());

        // Asteroids & Ship collision
        asteroids.forEach(asteroid -> {
          if (ship.collided(asteroid)) {
            setGameOver(true);
          }
        });

        // Projectiles & Asteroids collision
        projectiles.forEach(projectile -> {
          List<Asteroid> collisions = asteroids.stream().filter(asteroid -> {
            if (asteroid.collided(projectile)) {
              projectile.setAlive(false);
              asteroid.setAlive(false);
              return true;
            }
            return false;
          }).collect(Collectors.toList());

          // Increase points
          pointsText.setText("Points: " + points.addAndGet(collisions.size() * 1000));
          if (points.get() > bestScore.get()) {
            bestScore.set(points.get());
            bestScoreText.setText("Best Score: " + bestScore.get());
          }
          collisions.stream().forEach(collidedAsteroid -> {
            asteroids.remove(collidedAsteroid);
            pane.getChildren().remove(collidedAsteroid.getCharacter());

          });
        });

        // remove collided projectiles from the layout & increase points
        projectiles.stream().filter(projectile -> !projectile.isAlive()).forEach(dead -> {
          pane.getChildren().remove(dead.getCharacter());
        });
        // remove collided projectiles from projectiles list
        projectiles
            .removeAll(projectiles.stream().filter(projectile -> !projectile.isAlive()).collect(Collectors.toList()));

        projectiles.forEach(projectile -> projectile.move());
      }
    }.start();

    stage.setScene(scene);
    stage.setTitle("Asteroids!");
    stage.show();
  }

  private ArrayList<Asteroid> regenerateAsteroids(ArrayList<Asteroid> asteroids, Pane pane) {
    if (asteroids != null) {
      asteroids.forEach(asteroid -> pane.getChildren().remove(asteroid.getCharacter()));
      asteroids.clear();

    }

    for (int i = 0; i < 5; i++) {
      Random rnd = new Random();
      Asteroid asteroid = new Asteroid(rnd.nextInt(WIDTH / 3), rnd.nextInt(HEIGHT));
      asteroids.add(asteroid);
    }

    asteroids.forEach(asteroid -> pane.getChildren().add(asteroid.getCharacter()));
    return asteroids;
  }

  private void setGameOver(boolean gameOver) {
    this.gameOver = gameOver;
  }

  public static int partsCompleted() {
    // State how many parts you have completed using the return value of this method
    return 4;
  }
}
