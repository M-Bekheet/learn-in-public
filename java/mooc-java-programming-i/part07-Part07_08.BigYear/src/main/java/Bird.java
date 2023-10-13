public class Bird {
  private String name;
  private String latinName;
  private int observations = 0;

  public Bird(String name, String latinName) {
    this.name = name;
    this.latinName = latinName;
  }

  public void increaseObservations() {
    this.observations++;
  }

  public String name() {
    return this.name;
  }

  @Override
  public String toString() {
    return name + " (" + latinName + "): " + observations + " observations";
  }

}
