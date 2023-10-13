
import java.util.Scanner;

public class LiquidContainers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int container1 = 0;
        int container2 = 0;

        while (true) {
            System.out.println("First: " + container1 + "/100");
            System.out.println("Second: " + container2 + "/100");
            System.out.print("> ");

            String input = scan.nextLine();
            System.out.println();
            if (input.equals("quit")) {
                break;
            }
            String[] parts = input.split(" ");
            String command = parts[0];
            int amount = Integer.valueOf(parts[1]);

            if (amount < 0)
                continue;
            if (command.equals("add")) {
                container1 += amount;
                if (container1 > 100)
                    container1 = 100;
            } else if (command.equals("move")) {
                if (amount > container1)
                    amount = container1;
                container1 -= amount;
                container2 += amount;
                if (container2 > 100)
                    container2 = 100;
            } else if (command.equals("remove")) {
                container2 -= amount;
                if (container2 < 0)
                    container2 = 0;
            }

        }
    }

}
