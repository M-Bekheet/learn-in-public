
import java.util.ArrayList;
import java.util.Random;

public class LotteryRow {

  private ArrayList<Integer> numbers;
  private Random rand;

  public LotteryRow() {
    // Draw the numbers when the LotteryRow is created
    this.rand = new Random();
    this.randomizeNumbers();
  }

  public ArrayList<Integer> numbers() {
    return this.numbers;
  }

  public void randomizeNumbers() {
    this.numbers = new ArrayList<>();
    while (numbers.size() < 7) {
      int number = this.rand.nextInt(40) + 1;
      if (!containsNumber(number))
        numbers.add(number);
    }
  }

  public boolean containsNumber(int number) {
    // Check here whether the number is among the drawn numbers
    return this.numbers.contains(number);
  }
}
