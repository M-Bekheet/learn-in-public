import java.util.ArrayList;

public class Birds {
  private ArrayList<Bird> birds;

  public Birds() {
    this.birds = new ArrayList<>();
  }

  public void addBird(Bird bird) {
    this.birds.add(bird);
  }

  public void print() {
    for (Bird bird : birds)
      System.out.println(bird);
  }

  public void increaseObservations(String name) {
    Bird bird = findBird(name);
    if (bird != null)
      bird.increaseObservations();
    else
      System.out.println("Not a bird!");

  }

  public void printOne(String birdName) {
    Bird bird = findBird(birdName);
    if (bird != null)
      System.out.println(bird);
    else
      System.out.println("Not a bird!");
  }

  public Bird findBird(String birdName) {
    for (Bird bird : birds) {
      if (bird.name().equals(birdName)) {
        return bird;
      }
    }
    return null;
  }
}
