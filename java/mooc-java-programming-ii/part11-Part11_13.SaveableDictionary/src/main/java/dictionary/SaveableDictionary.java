package dictionary;

import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class SaveableDictionary {
  private HashMap<String, String> dictionary;
  private String file;

  public SaveableDictionary() {
    dictionary = new HashMap<String, String>();
  }

  public SaveableDictionary(String file) {
    this();
    this.file = file;

  }

  public boolean load() {
    try {
      Scanner reader = new Scanner(Paths.get(file));
      while (reader.hasNextLine()) {
        String line = reader.nextLine();
        String firstWord = line.split(":")[0];
        String secondWord = line.split(":")[1];
        add(firstWord, secondWord);
      }
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  public boolean save() {
    HashMap<String, String> uniqueList = new HashMap<>();

    try {

      for (String word : dictionary.keySet()) {
        String translation = dictionary.get(word);

        boolean wordsInList = uniqueList.containsKey(word) && uniqueList.containsValue(word)
            && uniqueList.containsKey(translation)
            && uniqueList.containsValue(translation);
        if (!wordsInList) {
          uniqueList.put(word, translation);
        }

      }
      if (uniqueList.size() > 0)
        saveToFile(uniqueList);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  private void saveToFile(HashMap<String, String> list) throws Exception {
    PrintWriter writer = new PrintWriter(file);
    String newText = "";
    int i = 0;
    int listSize = list.size();
    for (String first : list.keySet()) {

      newText += first + ":" + list.get(first);
      if (++i < listSize) {
        newText += "\n";
      }
    }
    writer.print(newText);
    writer.close();

    if (writer.checkError())
      throw new Exception();
  }

  public void add(String words, String translation) {
    if (dictionary.containsKey(words) || dictionary.containsKey(translation) ||
        dictionary.containsValue(words) || dictionary.containsValue(translation))
      return;
    dictionary.put(words, translation);

  }

  public void delete(String word) {
    deleteFromList(word, dictionary);
  }

  public void deleteFromList(String word, HashMap<String, String> list) {

    if (list.containsKey(word)) {
      list.remove(word);
    }
    Iterator<String> iterator = list.keySet().iterator();
    while (iterator.hasNext()) {
      String currentWord = iterator.next();
      if (list.get(currentWord).equals(word)) {

        iterator.remove();
      }
    }
  }

  public String translate(String word) {
    if (dictionary.containsKey(word))
      return dictionary.get(word);
    if (!dictionary.containsValue(word))
      return null;

    for (String firstWord : dictionary.keySet()) {
      if (dictionary.get(firstWord).equals(word))
        return firstWord;
    }
    return null;
  }

}
