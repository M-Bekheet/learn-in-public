package FlightControl.domain;

public class Airplane {
  private int capacity;
  private String ID;

  public Airplane(String ID, int capacity) {
    this.capacity = capacity;
    this.ID = ID;
  }

  @Override
  public String toString() {
    return this.ID + " (" + this.capacity + " capacity)";
  }
}
