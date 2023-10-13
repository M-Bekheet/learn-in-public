package application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Dictionary {
  private HashMap<String, String> dictionary;
  private List<String> words;

  public Dictionary() {
    this.dictionary = new HashMap<>();
    this.words = new ArrayList<>();
  }

  public String get(String word) {
    return dictionary.get(word);
  }

  public void add(String word, String translation) {
    if (!words.contains(word))
      words.add(word);
    dictionary.put(word, translation);
  }

  public String getRandomWord() {
    if (words.size() == 0)
      return "";
    Random random = new Random();
    return this.words.get(random.nextInt(this.words.size()));
  }

  public int size() {
    return words.size();
  }
}
