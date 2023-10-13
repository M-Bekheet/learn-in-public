public class Item {
  private String identifier;
  private String name;

  public Item(String identifier, String name) {
    this.identifier = identifier;
    this.name = name;
  }

  public String toString() {
    return identifier + ": " + name;
  }

  public boolean equals(Object compared) {
    if (compared == this)
      return true;
    if (!(compared instanceof Item))
      return false;

    Item comparedItem = (Item) compared;
    if (comparedItem.identifier.equals(identifier))
      return true;

    return false;
  }
}
