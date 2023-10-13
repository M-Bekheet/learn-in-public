package application;

public class StandardSensor implements Sensor {
  private int read;

  public StandardSensor(int read) {
    this.read = read;
  }

  public boolean isOn() {
    return true;
  };

  public void setOn() {
  };

  public void setOff() {
  };

  public int read() {
    return this.read;
  };
}
