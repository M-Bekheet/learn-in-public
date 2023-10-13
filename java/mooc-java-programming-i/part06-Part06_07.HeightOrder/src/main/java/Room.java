import java.util.ArrayList;

public class Room {
  private ArrayList<Person> persons;

  public Room() {
    persons = new ArrayList<>();
  }

  public void add(Person person) {
    persons.add(person);
  }

  public boolean isEmpty() {
    return persons.size() == 0;
  }

  public ArrayList<Person> getPersons() {
    return persons;
  }

  public Person shortest() {
    if (persons.size() == 0)
      return null;

    Person shortestPerson = persons.get(0);

    for (Person person : persons) {
      if (person.getHeight() < shortestPerson.getHeight()) {
        shortestPerson = person;
      }
    }
    return shortestPerson;
  }

  public Person take() {
    if (persons.isEmpty())
      return null;

    Person shortest = shortest();

    int shortestPersonIndex = 0;
    for (int i = 0; i < persons.size(); i++) {
      if (persons.get(i).equals(shortest)) {
        shortestPersonIndex = i;
        break;
      }
    }
    return persons.remove(shortestPersonIndex);
  }
}
