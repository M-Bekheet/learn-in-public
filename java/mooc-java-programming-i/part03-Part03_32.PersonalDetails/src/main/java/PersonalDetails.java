
import java.util.ArrayList;
import java.util.Scanner;

public class PersonalDetails {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double sum = 0;
        int count = 0;
        String longestName = "";

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("")) {
                break;
            }
            count++;
            String[] pair = input.split(",");
            sum += Integer.valueOf(pair[1]);
            if (pair[0].length() > longestName.length()) {
                longestName = pair[0];
            }
        }
        System.out.println("Longest name: " + longestName);
        System.out.println("Average of the birth years: " + sum / count);

    }
}
