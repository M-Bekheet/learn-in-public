
public class Main {

    public static void main(String[] args) {

        Card first = new Card(2, Suit.HEART);
        Card second = new Card(4, Suit.SPADE);
        System.out.println(new BySuitInValueOrder().compare(first, second));
    }
}
