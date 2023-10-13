import java.util.ArrayList;
import java.util.Random;

public class JokeManager {

  private ArrayList<String> jokes;

  public JokeManager() {
    jokes = new ArrayList<>();
  }

  public void addJoke(String joke) {
    jokes.add(joke);
  }

  public String drawJoke() {
    if (jokes.size() == 0)
      return "Jokes are in short supply.";

    Random rand = new Random();
    int index = rand.nextInt(jokes.size());
    System.out.println(index);
    return jokes.get(index);

  }

  public void printJokes() {
    if (jokes.size() != 0)
      for (String joke : jokes)
        System.out.println(joke);
  }
}
