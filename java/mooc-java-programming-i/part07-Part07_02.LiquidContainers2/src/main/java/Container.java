public class Container {
  private int liters;

  public Container() {

  }

  public int contains() {
    return liters;
  }

  public void add(int amount) {
    if (amount < 0)
      return;
    liters += amount;
    if (liters > 100)
      liters = 100;

  }

  public void remove(int amount) {
    if (amount < 0)
      return;

    liters -= amount;
    if (liters < 0)
      liters = 0;
  }

  public String toString() {
    return liters + "/100";
  }
}
