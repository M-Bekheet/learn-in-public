import java.util.ArrayList;
import java.util.HashMap;

public class StorageFacility {
  private HashMap<String, ArrayList<String>> facility;

  public StorageFacility() {
    facility = new HashMap<>();
  }

  public void add(String unit, String item) {
    facility.putIfAbsent(unit, new ArrayList<>());
    facility.get(unit).add(item);
  }

  public ArrayList<String> contents(String storageUnit) {
    return facility.getOrDefault(storageUnit, new ArrayList<>());
  }

  public void remove(String storageUnit, String item) {

    if (!facility.containsKey(storageUnit))
      return;

    ArrayList<String> items = facility.get(storageUnit);

    for (int index = 0; index < items.size(); index++) {
      if (items.get(index).equals(item)) {
        items.remove(index);
        break;
      }
    }
    if (items.size() == 0)
      facility.remove(storageUnit);
  }

  public ArrayList<String> storageUnits() {
    ArrayList<String> units = new ArrayList<>();

    for (String unit : facility.keySet()) {
      if (facility.get(unit).size() > 0)
        units.add(unit);
    }
    return units;

  }
}
