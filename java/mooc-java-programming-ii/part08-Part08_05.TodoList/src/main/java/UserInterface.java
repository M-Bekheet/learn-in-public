import java.util.Scanner;

public class UserInterface {
  private Scanner scanner;
  private TodoList todoList;

  public UserInterface(TodoList list, Scanner scanner) {
    this.scanner = scanner;
    this.todoList = list;
  }

  public void start() {
    while (true) {
      String command = scanner.nextLine();
      if (command.equals("add")) {
        String task = scanner.nextLine();
        todoList.add(task);
      } else if (command.equals("list")) {
        todoList.print();
      } else if (command.equals("remove")) {
        System.out.print("Which one is removed? ");
        int taskNumber = Integer.valueOf(scanner.nextLine());
        todoList.remove(taskNumber);
      } else if (command.equals("stop"))
        break;
    }
  }

}
