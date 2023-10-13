import java.util.ArrayList;
import java.util.HashMap;

public class VehicleRegistry {
  private HashMap<LicensePlate, String> cars;

  public VehicleRegistry() {
    this.cars = new HashMap<>();
  }

  public boolean add(LicensePlate licensePlate, String owner) {
    String foundOwner = cars.get(licensePlate);
    if (foundOwner != null)
      return false;
    cars.put(licensePlate, owner);
    return true;
  }

  public String get(LicensePlate licensePlate) {
    return cars.get(licensePlate);
  }

  public boolean remove(LicensePlate licensePlate) {
    String removedOwner = cars.remove(licensePlate);
    return removedOwner != null;
  }

  public void printLicensePlates() {
    for (LicensePlate license : cars.keySet())
      System.out.println(license);
  }

  public void printOwners() {
    ArrayList<String> printedOwners = new ArrayList<>();

    for (String owner : cars.values())
      if (!printedOwners.contains(owner)) {
        printedOwners.add(owner);
        System.out.println(owner);
      }
  }
}
