
public class StarSign {

    public static void main(String[] args) {

        // The tests are not checking the main, so you can modify it freely.
        // NB: If the tests don't seem to pass, you should try the methods here
        // in the main to make sure they print the correct shapes!

        printStars(3);
        System.out.println("\n---"); // printing --- between the shapes
        printSquare(4);
        System.out.println("\n---");
        printRectangle(5, 6);
        System.out.println("\n---");
        printTriangle(3);
        System.out.println("\n---");
    }

    public static void printStars(int number) {
        while (number > 0) {
            System.out.print("*");
            number--;
        }
        System.out.print("\n");
    }

    public static void printSquare(int size) {
        // second part of the exercise
        int i = size;
        while (i > 0) {
            printStars(size);
            i--;
        }
    }

    public static void printRectangle(int width, int height) {
        // third part of the exercise
        int h = height;
        while (h > 0) {
            printStars(width);
            h--;
        }

    }

    public static void printTriangle(int size) {
        int i = 1;
        // fourth part of the exercise
        while (i <= size) {
            printStars(i);
            i++;
        }
    }
}
