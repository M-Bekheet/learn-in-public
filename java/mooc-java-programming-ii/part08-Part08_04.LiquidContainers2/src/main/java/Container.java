public class Container {
  private int amount;

  public Container() {
    amount = 0;
  }

  public int contains() {
    return amount;
  }

  public void add(int value) {
    if (value <= 0)
      return;

    amount += value;
    if (amount > 100)
      amount = 100;

  }

  public void remove(int value) {
    if (value <= 0)
      return;
    amount -= value;
    if (amount < 0)
      amount = 0;
  }

  @Override
  public String toString() {
    return amount + "/100";
  }
}
