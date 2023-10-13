import java.util.ArrayList;

public class ChangeHistory {
  private ArrayList<Double> history;

  public ChangeHistory() {
    history = new ArrayList<>();
  }

  public void add(double status) {
    history.add(status);
  }

  public double maxValue() {
    if (history.size() == 0)
      return 0;
    double max = history.get(0);
    for (Double record : history) {
      if (record > max)
        max = record;
    }
    return max;
  }

  public double minValue() {
    if (history.size() == 0)
      return 0;
    double min = history.get(0);
    for (Double record : history) {
      if (record < min)
        min = record;
    }
    return min;
  }

  public double average() {
    if (history.size() == 0)
      return 0;
    double total = 0;
    for (Double record : history)
      total += record;
    return total / history.size();
  }

  public void clear() {
    history.clear();
  }

  public String toString() {
    return history.toString();
  }
}
