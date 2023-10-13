
import java.util.ArrayList;
import java.util.Scanner;

public class AverageOfNumbers {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    ArrayList<String> inputs = new ArrayList<>();

    while (true) {

      String input = scanner.nextLine();
      if (input.equals("end"))
        break;

      inputs.add(input);
    }

    double average = inputs.stream().mapToInt(val -> Integer.valueOf(val)).average().getAsDouble();
    System.out.println("average of the numbers: " + average);

  }
}
