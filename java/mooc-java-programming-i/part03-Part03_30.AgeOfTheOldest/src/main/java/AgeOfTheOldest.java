
import java.util.Scanner;

public class AgeOfTheOldest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int largest = 0;
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("")) {
                break;
            }
            String[] inputs = input.split(",");
            if (Integer.valueOf(inputs[1]) > largest) {
                largest = Integer.valueOf(inputs[1]);
            }

        }
        System.out.println("Age of the oldest: " + largest);
    }
}
