
import java.util.Scanner;

public class LineByLine {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {

            String input = scanner.nextLine();
            if (input.equals("")) {
                break;
            }
            String[] inputs = input.split(" ");
            for (String a : inputs) {
                System.out.println(a);
            }
        }
    }
}
