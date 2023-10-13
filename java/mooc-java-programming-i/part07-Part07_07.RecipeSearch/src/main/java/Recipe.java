import java.util.ArrayList;

public class Recipe {
  private String name;
  private int cookingTime;
  private ArrayList<String> ingredients;

  public Recipe(String name, int cookingTime, ArrayList<String> ingredients) {
    this.name = name;
    this.cookingTime = cookingTime;
    this.ingredients = ingredients;
  }

  public String toString() {
    return name + ", cooking time: " + cookingTime;
  }

  public String name() {
    return this.name;
  }

  public int cookingTime() {
    return this.cookingTime;
  }

  public ArrayList<String> ingredients() {
    return this.ingredients;
  }
}
