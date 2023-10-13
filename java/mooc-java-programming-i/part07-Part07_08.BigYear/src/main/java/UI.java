import java.util.Scanner;

public class UI {
  Scanner scanner;
  Birds birds;

  public UI(Scanner scanner) {
    this.scanner = scanner;
    this.birds = new Birds();
  }

  public void ready() {
    String command;
    while (true) {
      System.out.print("? ");
      command = scanner.nextLine();
      switch (command) {
        case "Quit":
          return;
        case "Add": {
          System.out.print("Name: ");
          String name = scanner.nextLine();
          System.out.print("Name in Latin: ");
          String latinName = scanner.nextLine();
          birds.addBird(new Bird(name, latinName));
          break;
        }
        case "Observation": {
          System.out.print("Bird? ");
          String name = scanner.nextLine();
          birds.increaseObservations(name);
          break;
        }
        case "One": {
          System.out.print("Bird? ");
          String name = scanner.nextLine();
          birds.printOne(name);
          break;
        }
        case "All": {
          birds.print();
          break;
        }
        default:
          System.out.println("Not a correct command");
      }
    }
  }
}
