package asteroids.character;

import java.util.Random;

import asteroids.shape.PolygonFactory;

public class Asteroid extends Character {
  private double rotationMovement;

  public Asteroid(int x, int y) {
    // create random polygon
    super(new PolygonFactory().createPolygon(), x, y);

    Random rnd = new Random();

    super.getCharacter().setRotate(rnd.nextInt(360));
    int accelerationAmount = 1 + rnd.nextInt(10);

    for (int i = 0; i < accelerationAmount; i++) {
      accelerate();
    }
    this.rotationMovement = 0.5 - rnd.nextDouble();
  }

  @Override
  public void move() {
    super.move();
    super.getCharacter().setRotate(super.getCharacter().getRotate() + rotationMovement);
  }
}
