import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Employees {
  private ArrayList<Person> employees;

  public Employees() {
    this.employees = new ArrayList<>();
  }

  public void add(Person peopleToAdd) {
    this.employees.add(peopleToAdd);
  }

  public void add(List<Person> peopleToAdd) {
    for (Person person : peopleToAdd) {
      this.add(person);
    }
  }

  public void print() {
    for (Person employee : employees)
      System.out.println(employee);
  }

  public void print(Education education) {
    Iterator<Person> iterator = employees.iterator();
    while (iterator.hasNext()) {
      Person employee = iterator.next();
      if (employee.getEducation().equals(education))
        System.out.println(employee);
    }
  }

  public void fire(Education education) {
    Iterator<Person> iterator = employees.iterator();

    while (iterator.hasNext()) {
      if (iterator.next().getEducation().equals(education)) {
        iterator.remove();
      }
    }
  }
}
