
public class AdvancedAstrology {

    public static void printStars(int number) {
        // part 1 of the exercise
        while (number > 0) {
            System.out.print("*");
            number--;
        }
        System.out.print("\n");

    }

    public static void printSpaces(int number) {
        // part 1 of the exercise
        while (number > 0) {
            System.out.print(" ");
            number--;
        }
    }

    public static void printTriangle(int size) {
        // part 2 of the exercise
        int row = 1;
        while (row <= size) {
            printSpaces(size - row);
            printStars(row);
            row++;
        }
    }

    public static void christmasTree(int height) {
        // part 3 of the exercise
        int row = 1;
        for (int i = 1; row <= height; i += 2) {
            printSpaces(height - row);
            printStars(i);
            row++;
        }
        // to get the count of leading spaces: (2*height -1) is the count of stars for
        // the last row. We're dividing it by 2
        // got reach its mid and remove 1 (the half of the 3 stars (3/2 = 1))
        int rootIndex = (2 * height - 1) / 2 - 1;
        printSpaces(rootIndex);
        printStars(3);
        printSpaces(rootIndex);
        printStars(3);
    }

    public static void main(String[] args) {
        // The tests are not checking the main, so you can modify it freely.

        printTriangle(3);
        System.out.println("---");
        christmasTree(4);
        System.out.println("---");
        christmasTree(10);
    }
}
