
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class MainProgram {

  public static void main(String[] args) {
    ArrayList<Book> books = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    while (true) {
      System.out.println("Input the name of the book, empty stops: ");
      String name = scanner.nextLine();

      if (name.isEmpty())
        break;

      System.out.println("Input the age recommendation: ");
      int age = Integer.valueOf(scanner.nextLine());
      books.add(new Book(name, age));
    }

    System.out.println(books.size() + " books in total.");
    Comparator<Book> comparator = Comparator.comparing(Book::getAge).thenComparing(Book::getName);
    System.out.println("Books: ");
    books.stream().sorted(comparator).forEach(book -> System.out.println(book));
  }

}

class Book {
  private String name;
  private int age;

  public Book(String n, int a) {
    name = n;
    age = a;
  }

  public int getAge() {
    return this.age;
  }

  public String getName() {
    return this.name;
  }

  @Override
  public String toString() {
    return name + " (recommended for " + age + " year-olds or older)";
  }
}