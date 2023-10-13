import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // implement here the program that allows the user to enter
        // book information and to examine them
        Scanner scanner = new Scanner(System.in);

        ArrayList<Book> books = new ArrayList<>();

        while (true) {
            System.out.print("Title: ");
            String title = scanner.nextLine();
            if (title.isEmpty())
                break;
            System.out.print("Pages: ");
            int pages = Integer.valueOf(scanner.nextLine());

            System.out.print("Publication year: ");
            int pubYear = Integer.valueOf(scanner.nextLine());

            books.add(new Book(title, pages, pubYear));

        }
        System.out.print("What information will be printed? ");
        String answer = scanner.nextLine();
        if (answer.equals("everything")) {
            for (Book book : books) {
                System.out.println(book);

            }
        } else if (answer.equals("name")) {
            for (Book book : books) {
                book.printTitle();
            }
        }
    }
}
