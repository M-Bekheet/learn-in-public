import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class UI {
  Scanner scanner;

  public UI(Scanner scanner) {
    this.scanner = scanner;

  }

  public void start() {
    System.out.print("File to read: ");
    String fileName = scanner.nextLine();
    ArrayList<Recipe> recipes = new ArrayList<>();

    // record recipes
    try (Scanner fileReader = new Scanner(Paths.get(fileName))) {
      ArrayList<String> lines = new ArrayList<>();
      while (fileReader.hasNextLine()) {
        String line = fileReader.nextLine();
        if (line.isEmpty()) {
          recipes.add(getRecipeFromLines(lines));
          lines.clear();
        } else {
          lines.add(line);
        }

      }
      recipes.add(getRecipeFromLines(lines));

    } catch (Exception exception) {
      System.out.println(exception.getMessage());
    }
    while (true) {

      System.out.println("\nCommands:");

      System.out.println(
          "list - lists the recipes");
      System.out.println("stop - stops the program");
      System.out.println("find name - searches recipes by name");
      System.out.println("find cooking time - searches recipes by cooking time");
      System.out.println("find ingredient - searches recipes by ingredient");

      System.out.println();

      System.out.print("Enter command: ");

      String command = scanner.nextLine();

      if (command.equals("stop"))
        break;

      if (command.equals("list")) {

        System.out.println("Recipes:");
        for (Recipe recipe : recipes)
          System.out.println(recipe);

      } else if (command.equals("find name")) {

        System.out.print("Searched word: ");
        String searchWord = scanner.nextLine();
        System.out.println("\nRecipes:");
        for (Recipe r : recipes) {
          if (r.name().contains(searchWord))
            System.out.println(r);
        }

      } else if (command.equals("find cooking time")) {

        System.out.print("Max cooking time: ");
        int cookingTime = Integer.valueOf(scanner.nextLine());
        System.out.println("\nRecipes:");
        for (Recipe r : recipes) {
          if (r.cookingTime() <= cookingTime)
            System.out.println(r);
        }

      } else if (command.equals("find ingredient")) {

        System.out.print("Searched word: ");
        String searchWord = scanner.nextLine();
        System.out.println("\nRecipes:");
        for (Recipe r : recipes) {
          if (r.ingredients().contains(searchWord))
            System.out.println(r);
        }

      }
    }
  }

  public Recipe getRecipeFromLines(ArrayList<String> lines) {
    String name = lines.get(0);
    ArrayList<String> ingredients = new ArrayList<>();
    int cookingTime = Integer.valueOf(lines.get(1));
    for (int i = 2; i < lines.size(); i++) {
      if (!lines.get(i).isEmpty())
        ingredients.add(lines.get(i));
    }
    return new Recipe(name, cookingTime, ingredients);

  }
}
