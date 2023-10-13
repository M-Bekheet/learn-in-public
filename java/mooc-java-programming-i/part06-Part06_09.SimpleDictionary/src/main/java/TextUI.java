import java.util.Scanner;

public class TextUI {
  private Scanner scanner;
  private SimpleDictionary dictionary;

  public TextUI(Scanner scanner, SimpleDictionary dictionary) {
    this.scanner = scanner;
    this.dictionary = dictionary;
  }

  public void start() {
    while (true) {
      System.out.print("Command: ");
      String input = this.scanner.nextLine();
      if (input.equals("end")) {
        System.out.println("Bye bye!");
        break;
      }
      if (input.equals("add")) {
        System.out.print("Word: ");
        String word = this.scanner.nextLine();
        System.out.print("Translation: ");
        String translation = this.scanner.nextLine();
        dictionary.add(word, translation);
      } else if (input.equals("search")) {
        System.out.print("To be translated: ");
        String word = scanner.nextLine();
        System.out.print("Translation: ");
        String translation = dictionary.translate(word);
        if (translation == null)
          System.out.println("Word " + word + " was not found");
        else {
          System.out.print(dictionary.translate(word) + "\n");
        }
      } else {

        System.out.println("Unknown command");
      }
    }
  }
}
