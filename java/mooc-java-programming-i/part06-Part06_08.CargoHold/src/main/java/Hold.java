import java.util.ArrayList;

public class Hold {
  private int maxWeight;
  private ArrayList<Suitcase> suitcases;

  public Hold(int maxWeight) {
    this.maxWeight = maxWeight;
    suitcases = new ArrayList<>();
  }

  public void addSuitcase(Suitcase suitcase) {
    int suitcasesWeight = 0;
    for (Suitcase s : suitcases)
      suitcasesWeight += s.totalWeight();

    if (suitcasesWeight + suitcase.totalWeight() > maxWeight)
      return;

    suitcases.add(suitcase);
  }

  public String toString() {
    int totalWeight = 0;
    for (Suitcase s : suitcases) {
      totalWeight += s.totalWeight();
    }
    return suitcases.size() + " suitcases (" + totalWeight + " kg)";
  }

  public void printItems() {
    for (Suitcase suitcase : suitcases) {
      suitcase.printItems();
    }
  }
}
