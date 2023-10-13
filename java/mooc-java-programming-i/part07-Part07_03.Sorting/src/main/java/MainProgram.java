import java.util.Arrays;

public class MainProgram {

    public static void main(String[] args) {
        int[] numbers = { 8, 3, 7, 9, 1, 2, 4 };
        MainProgram.sort(numbers);
    }

    public static int smallest(int[] array) {
        int smallestNumber = array[0];
        for (int i : array) {
            if (i < smallestNumber)
                smallestNumber = i;
        }
        return smallestNumber;
    }

    public static int indexOfSmallest(int[] array) {
        int index = 0;
        int smallest = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < smallest) {
                smallest = array[i];
                index = i;
            }
        }

        return index;
    }

    public static int indexOfSmallestFrom(int[] table, int startIndex) {
        int index = startIndex;
        int smallest = table[startIndex];
        for (int i = startIndex; i < table.length; i++) {
            if (table[i] < smallest) {
                smallest = table[i];
                index = i;
            }
        }
        return index;
    }

    public static void swap(int[] array, int index1, int index2) {
        int first = array[index1];
        array[index1] = array[index2];
        array[index2] = first;
    }

    public static void sort(int[] array) {
        System.out.println(Arrays.toString(array));

        for (int i = 0; i < array.length; i++) {
            int smallestNumIndex = indexOfSmallestFrom(array, i);
            swap(array, i, smallestNumIndex);
            System.out.println(Arrays.toString(array));
        }

    }
}
