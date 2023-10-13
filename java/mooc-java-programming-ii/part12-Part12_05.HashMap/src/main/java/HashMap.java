import java.util.ArrayList;

public class HashMap<K, V> {
  private ArrayList<Pair<K, V>>[] values;
  private int firstFreeIndex;

  public HashMap() {
    values = new ArrayList[32];
    firstFreeIndex = 0;
  }

  public V get(K key) {
    ArrayList<Pair<K, V>> subList = getListByKey(key);
    if (subList.size() == 0)
      return null;
    for (int i = 0; i < subList.size(); i++) {
      if (subList.get(i).getKey().equals(key))
        return subList.get(i).getValue();
    }

    return null;
  }

  public void add(K key, V value) {
    ArrayList<Pair<K, V>> subList = getListByKey(key);

    int index = getIndexByKey(subList, key);
    if (index < 0) {
      subList.add(new Pair<K, V>(key, value));
      firstFreeIndex++;
    } else {
      subList.get(index).setValue(value);
    }

    if (1.0 * firstFreeIndex / values.length < 0.75) {
      grow();
    }
  }

  public V remove(K key) {
    ArrayList<Pair<K, V>> subList = getListByKey(key);

    int index = getIndexByKey(subList, key);
    if (index < 0)
      return null;

    int hash = Math.abs(key.hashCode() % values.length);
    Pair<K, V> pair = subList.get(hash);
    if (pair == null)
      return null;

    subList.remove(pair);
    return pair.getValue();
  }

  // helpers

  private void grow() {
    ArrayList<Pair<K, V>>[] newList = new ArrayList[values.length * 2];
    for (int i = 0; i < values.length; i++) {
      ArrayList<Pair<K, V>> subList = values[i];
      if (subList == null)
        continue;
      copy(newList, i);
    }
  }

  private ArrayList<Pair<K, V>> getListByKey(K key) {
    int hash = Math.abs(key.hashCode() % values.length);
    if (values[hash] == null) {
      values[hash] = new ArrayList<>();
    }
    return values[hash];
  }

  private int getIndexByKey(ArrayList<Pair<K, V>> subList, K key) {
    for (int i = 0; i < subList.size(); i++) {
      if (subList.get(i).getKey().equals(key))
        return i;
    }
    return -1;
  }

  private void copy(ArrayList<Pair<K, V>>[] newList, int index) {

    ArrayList<Pair<K, V>> subList = values[index];

    for (int i = 0; i < firstFreeIndex; i++) {
      Pair<K, V> pair = subList.get(i);
      if (pair == null)
        continue;
      int hash = Math.abs(pair.getKey().hashCode() % newList.length);
      if (newList[hash] == null) {
        newList[hash] = new ArrayList<>();
      }
      newList[hash].add(pair);
    }
  }

}
