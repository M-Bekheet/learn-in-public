
import java.util.Scanner;

public class NameOfTheOldest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = "";
        int largest = 0;
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("")) {
                break;
            }
            String[] inputs = input.split(",");
            if (Integer.valueOf(inputs[1]) > largest) {
                largest = Integer.valueOf(inputs[1]);
                name = inputs[0];
            }

        }
        System.out.println("Name of the oldest: " + name);

    }
}
