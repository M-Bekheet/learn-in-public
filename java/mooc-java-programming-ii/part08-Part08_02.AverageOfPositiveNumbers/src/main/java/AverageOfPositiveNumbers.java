
import java.util.Scanner;

public class AverageOfPositiveNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        int total = 0;
        while (true) {
            int input = Integer.valueOf(scanner.nextLine());
            if (input == 0) {

                break;
            } else if (input < 0) {

                continue;
            }
            total += input;
            count++;
        }
        if (total == 0) {

            System.out.println("Cannot calculate the average");
        } else {
            System.out.println(1.0 * total / count);
        }
    }
}
