
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class NumbersFromAFile {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("File? ");
        String file = scanner.nextLine();
        System.out.print("Lower bound? ");
        int lowerBound = Integer.valueOf(scanner.nextLine());
        System.out.print("Upper bound? ");
        int upperBound = Integer.valueOf(scanner.nextLine());

        ArrayList<Integer> nums = new ArrayList<>();
        try (Scanner scan = new Scanner(Paths.get(file))) {
            while (scan.hasNextLine()) {
                int n = Integer.valueOf(scan.nextLine());
                if (n >= lowerBound && n <= upperBound)
                    nums.add(n);
            }
            System.out.println("Numbers: " + nums.size());
        } catch (Exception exception) {
            System.out.println(exception);
        }

    }

}
