
public class Main {

    public static void main(String[] args) {
        Song song1 = new Song("The Lonely Island", "Jack Sparrow", 196);
        Song song2 = new Song("The Lonely Island", "Jack Sparrow", 196);
        if (song1.equals(song2)) {
            System.out.println("Same!");
        }
    }
}
