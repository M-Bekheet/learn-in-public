
public class Student implements Comparable<Student> {

  private String name;

  public Student(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  @Override
  public int compareTo(Student other) {
    return this.getName().compareToIgnoreCase(other.getName());
  }

  @Override
  public String toString() {
    return name;
  }

}
