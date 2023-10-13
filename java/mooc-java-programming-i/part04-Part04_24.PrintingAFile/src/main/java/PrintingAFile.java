import java.nio.file.Paths;
import java.util.Scanner;

public class PrintingAFile {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(Paths.get("data.txt"))) {
            while (true) {

                if (scanner.hasNextLine()) {
                    System.out.println(scanner.nextLine());
                } else
                    break;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

}
