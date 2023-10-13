import java.util.ArrayList;

public class MagicSquareFactory {

  public MagicSquare createMagicSquare(int size) {

    MagicSquare square = new MagicSquare(size);

    // implement the creation of a magic square with the Siamese method algorithm
    // here

    int lastAdded = 1;
    int i = 0;
    int j = size / 2;
    square.placeValue(j, i, lastAdded);
    ArrayList<Integer> numbers = square.giveAllNumbers();
    while (numbers.contains(0)) {
      int newI = i - 1;
      int newJ = j + 1;

      // correct i
      if (newI < 0)
        newI = size - 1;
      // correct j
      if (newJ >= size)
        newJ = 0;

      int currentValueIndex = newI * size + newJ;
      if (numbers.get(currentValueIndex) != 0) { // value is setBefore
        newI = i + 1;
        newJ = j;

        // correct i
        if (newI >= size)
          newI = 0;

        currentValueIndex = newI * size + newJ;
      }

      lastAdded += 1;
      numbers.set(currentValueIndex, lastAdded);

      // update i,j
      i = newI;
      j = newJ;

    }

    for (int k = 0; k < numbers.size(); k++) {
      int row = k / size;
      int col = k % size;
      square.placeValue(col, row, numbers.get(k));
    }

    return square;
  }

}
