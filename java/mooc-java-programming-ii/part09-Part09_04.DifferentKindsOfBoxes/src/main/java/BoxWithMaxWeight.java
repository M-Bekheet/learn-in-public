import java.util.ArrayList;

public class BoxWithMaxWeight extends Box {
  private int capacity;
  private ArrayList<Item> items;

  public BoxWithMaxWeight(int capacity) {
    this.capacity = capacity;
    this.items = new ArrayList<>();
  }

  public void add(Item item) {
    if (item.getWeight() + currentWeight() > capacity)
      return;
    items.add(item);
  }

  public boolean isInBox(Item item) {
    return items.contains(item);
  }

  protected int currentWeight() {
    int weight = 0;
    for (Item item : items)
      weight += item.getWeight();
    return weight;
  }
}
