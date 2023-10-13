
import java.util.Scanner;

public class Story {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("I will tell you a story, but I need some information first.");
        System.out.println("What is the main character called?");
        String c = scanner.nextLine();
        System.out.println("What is their job?");
        String j = scanner.nextLine();
        System.out.println("Here is the story:");
        System.out.println("Once upon a time there was " + c + ", who was " + j + ".");
        System.out.println("On the way to work, " + c + " reflected on life.");
        System.out.println("Perhaps " + c + " will not be " + j + " forever.");
        // Write your program here

    }
}
