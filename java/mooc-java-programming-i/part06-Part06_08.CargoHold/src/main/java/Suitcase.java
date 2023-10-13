import java.util.ArrayList;

public class Suitcase {
  private ArrayList<Item> items;
  private int maxWeight;

  public Suitcase(int maxWeight) {
    this.maxWeight = maxWeight;
    this.items = new ArrayList<>();
  }

  public void addItem(Item item) {
    if (item.getWeight() > maxWeight)
      return;

    if (totalWeight() + item.getWeight() > maxWeight)
      return;

    this.items.add(item);
  }

  public int totalWeight() {
    int newWeight = 0;
    for (Item ele : items)
      newWeight += ele.getWeight();
    return newWeight;
  }

  public void printItems() {
    for (Item item : items)
      System.out.println(item);
  }

  public String toString() {
    if (items.size() == 0)
      return "no items (0kg)";

    String itemNaming = items.size() == 1 ? " item (" : " items (";
    return (items.size() + itemNaming + totalWeight() + " kg)");
  }

  public Item heaviestItem() {
    if (items.isEmpty())
      return null;

    Item heaviestItem = items.get(0);

    for (Item item : items) {
      if (item.getWeight() > heaviestItem.getWeight())
        heaviestItem = item;
    }
    return heaviestItem;
  }
}
