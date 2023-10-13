
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PositiveNumbers {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    List<Integer> numbers = new ArrayList<>();
    numbers.add(Integer.valueOf(scanner.nextLine()));
    numbers.add(Integer.valueOf(scanner.nextLine()));
    numbers.add(Integer.valueOf(scanner.nextLine()));
    numbers = positive(numbers);
    System.out.println(numbers);

  }

  public static List<Integer> positive(List<Integer> numbers) {
    return numbers.stream().filter(val -> val > 0).collect(Collectors.toCollection(ArrayList::new));
  }

}
