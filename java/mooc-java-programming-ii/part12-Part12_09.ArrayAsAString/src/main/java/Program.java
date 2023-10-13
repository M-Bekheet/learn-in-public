
public class Program {

  public static void main(String[] args) {
    int[][] matrix = {
        { 3, 2, 7, 6 },
        { 2, 4, 1, 0 },
        { 3, 2, 1, 0 }
    };

    System.out.println(arrayAsString(matrix));
  }

  public static String arrayAsString(int[][] arr) {
    String string = "";
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        string += arr[i][j];
      }
      if (i != arr.length - 1)
        string += "\n";
    }
    return string;
  }
}
