import java.util.ArrayList;
import java.util.Collections;

public class MainProgram {

  public static void main(String[] args) {
    Student first = new Student("Zaki");
    Student second = new Student("Moatasem");
    Student third = new Student("Mahomoud");
    System.out.println(first.compareTo(second));

    ArrayList<Student> students = new ArrayList<>();
    students.add(first);
    students.add(second);
    students.add(third);

    System.out.println(students);
    System.out.println();

    Collections.sort(students);
    System.out.println(students);
  }
}
