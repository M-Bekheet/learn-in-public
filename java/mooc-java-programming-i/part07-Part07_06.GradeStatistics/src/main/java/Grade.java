public class Grade {
  private int value;

  public Grade() {
  }

  public void setValue(int value) {
    if (value < 0 || value > 100)
      return;
    this.value = value;
  }

  public int value() {
    return value;
  }

  public int tier() {
    if (value >= 90)
      return 5;
    if (value >= 80)
      return 4;
    if (value >= 70)
      return 3;
    if (value >= 60)
      return 2;
    if (value >= 50)
      return 1;
    return 0;

  }

}
