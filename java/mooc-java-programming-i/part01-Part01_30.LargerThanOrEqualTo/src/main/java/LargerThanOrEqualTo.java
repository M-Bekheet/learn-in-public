
import java.util.Scanner;

public class LargerThanOrEqualTo {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n1, n2;
        System.out.println("Give the first number:");
        n1 = Integer.valueOf(scan.nextLine());
        System.out.println("Give the second number:");
        n2 = Integer.valueOf(scan.nextLine());

        if (n1 > n2) {

            System.out.println("Greater number is: " + n1);
        } else if (n1 == n2) {
            System.out.println("The numbers are equal!");
        } else {
            System.out.println("Greater number is: " + n2);
        }

    }
}
