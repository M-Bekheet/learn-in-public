
public class Statistics {
  private int count;
  private int sum;

  public Statistics() {

  }

  public void addNumber(int n) {
    sum += n;
    count++;
  }

  public int getCount() {
    return count;
  }

  public int sum() {
    return sum;
  }

  public double average() {
    if (count == 0)
      return 0;
    return 1.0 * sum / count;
  }
}
