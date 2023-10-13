public class Gift {
  private String name;
  private int weight;

  public Gift(String n, int w) {
    name = n;
    weight = w;
  }

  public String getName() {
    return name;
  }

  public int getWeight() {
    return weight;
  }

  public String toString() {
    return name + " (" + weight + "kg)";
  }

}
