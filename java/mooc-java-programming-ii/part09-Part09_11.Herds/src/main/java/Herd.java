import java.util.ArrayList;

public class Herd implements Movable {
  private ArrayList<Movable> movables;

  public Herd() {
    movables = new ArrayList<>();
  }

  public void addToHerd(Movable movable) {
    this.movables.add(movable);
  }

  public void move(int dx, int dy) {
    for (Movable movable : movables) {
      movable.move(dx, dy);
    }
  }

  public String toString() {
    String text = "";
    for (Movable movable : movables) {
      text += movable + "\n";
    }
    return text;
  }
}
