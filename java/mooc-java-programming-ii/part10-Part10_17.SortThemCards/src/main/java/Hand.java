import java.util.ArrayList;
import java.util.Collections;

public class Hand implements Comparable<Hand> {
  private ArrayList<Card> cards;

  public Hand() {
    cards = new ArrayList<>();
  }

  public void add(Card card) {
    this.cards.add(card);
  }

  public void print() {
    for (Card card : cards) {
      System.out.println(card);
    }
  }

  @Override
  public int compareTo(Hand otherHand) {
    return this.sum() - otherHand.sum();

  }

  public int sum() {
    int total = 0;
    for (Card card : cards) {
      total += card.getValue();
    }
    return total;
  }

  public void sort() {
    Collections.sort(cards);
  }

  public void sortBySuit() {

    Collections.sort(this.cards, new BySuitInValueOrder());

  }
}
