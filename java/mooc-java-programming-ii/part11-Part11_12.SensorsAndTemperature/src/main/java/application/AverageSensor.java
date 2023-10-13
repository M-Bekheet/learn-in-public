package application;

import java.util.ArrayList;
import java.util.List;

public class AverageSensor implements Sensor {
  private ArrayList<Sensor> sensors;
  private ArrayList<Integer> readingsList;

  public AverageSensor() {
    sensors = new ArrayList<Sensor>();
    readingsList = new ArrayList<>();
  }

  public boolean isOn() {
    for (Sensor sensor : sensors) {
      if (!sensor.isOn())
        return false;
    }
    return true;
  };

  public void addSensor(Sensor sensor) {
    sensors.add(sensor);
  }

  public void setOn() {
    for (Sensor sensor : sensors) {
      sensor.setOn();
    }
  };

  public void setOff() {
    for (Sensor sensor : sensors) {
      sensor.setOff();
    }
  };

  public int read() {
    if (sensors.size() == 0 || !isOn()) {
      throw new IllegalStateException();
    }
    int avg = (int) (sensors.stream().mapToInt(sensor -> sensor.read()).average().getAsDouble());

    readingsList.add(avg);

    return avg;
  }

  public List<Integer> readings() {
    return readingsList;
  }
}