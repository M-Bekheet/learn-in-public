import java.util.ArrayList;

public class Box implements Packable {
  private double maxCapacity;
  private ArrayList<Packable> packables;

  public Box(double maxCapacity) {
    this.maxCapacity = maxCapacity;
    packables = new ArrayList<>();
  }

  public void add(Packable packable) {
    if (weight() + packable.weight() <= maxCapacity) {
      packables.add(packable);
    }
  }

  public double weight() {
    double weight = 0;
    for (Packable packable : packables)
      weight += packable.weight();
    return weight;
  }

  @Override
  public String toString() {
    return "Box: " + packables.size() + " items, total weight " + weight() + " kg";
  }

}
