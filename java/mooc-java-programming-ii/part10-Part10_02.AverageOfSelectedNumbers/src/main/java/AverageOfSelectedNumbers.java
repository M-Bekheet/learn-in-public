
import java.util.ArrayList;
import java.util.Scanner;

public class AverageOfSelectedNumbers {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    // toteuta ohjelmasi tänne
    System.out.println("Input numbers, type \"end\" to stop.");
    ArrayList<Integer> inputs = new ArrayList<>();

    while (true) {
      String input = scanner.nextLine();
      if (input.equals("end"))
        break;
      inputs.add(Integer.valueOf(input));
    }

    System.out.println("Print the average of the negative numbers or the positive numbers? (n/p)");
    Character answer = scanner.nextLine().charAt(0);
    if (answer.equals('n')) {
      double avg = inputs.stream().mapToInt(val -> val).filter(val -> val < 0).average().getAsDouble();
      System.out.println("Average of the negative numbers: " + avg);
    } else if (answer.equals('p')) {
      double avg = inputs.stream().mapToInt(val -> val).filter(val -> val > 0).average().getAsDouble();
      System.out.println("Average of the positive numbers: " + avg);

    }
  }
}
