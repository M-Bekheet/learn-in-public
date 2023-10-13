
import java.util.ArrayList;
import java.util.Scanner;

public class LimitedNumbers {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Integer> inputs = new ArrayList<>();
    while (true) {
      int input = Integer.valueOf(scanner.nextLine());
      if (input < 0)
        break;

      inputs.add(input);
    }
    inputs.stream().filter(val -> val >= 1 && val <= 5).forEach(input -> System.out.println(input));
  }
}
