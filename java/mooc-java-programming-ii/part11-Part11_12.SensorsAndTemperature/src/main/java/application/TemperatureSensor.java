package application;

import java.util.Random;

public class TemperatureSensor implements Sensor {
  private boolean on;

  public TemperatureSensor() {
    this.on = false;
  }

  public boolean isOn() {
    return this.on;
  };

  public void setOn() {
    this.on = true;
  };

  public void setOff() {
    this.on = false;
  };

  public int read() {
    if (!on) {
      throw new IllegalStateException();
    }
    Random read = new Random();
    return read.nextInt(30 - (-30)) - 30; // nextInt(max - min) - min;

  };
}
