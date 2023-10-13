
import java.util.Scanner;

public class Program {

  public static void main(String[] args) {
    HashMap<String, Integer> hashmap = new HashMap<String, Integer>();
    hashmap.add("Jack", 4);
    hashmap.add("Adam", 2);
    hashmap.add("Ahmed", 20);
    hashmap.add("Sayed", 20);
    hashmap.add("Sayed", 102);
    hashmap.add("Jack", 12);

    System.out.println(hashmap.get("Sayed"));
    System.out.println(hashmap.remove("Sayed"));
    System.out.println(hashmap.get("Sayed"));
    System.out.println(hashmap.remove("Sayed"));
  }

}
