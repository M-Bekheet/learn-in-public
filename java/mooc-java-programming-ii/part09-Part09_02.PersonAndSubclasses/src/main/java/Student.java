public class Student extends Person {
  private int credits;

  public Student(String name, String address) {
    super(name, address);
  }

  public int credits() {
    return credits;
  }

  public void study() {
    credits++;
  }

  @Override
  public String toString() {
    return super.toString() + "\n  Study credits " + credits;
  }

}
