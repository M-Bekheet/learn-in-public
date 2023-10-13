public class List<Type> {
  private int lastFreeIndex;
  private Type[] values;

  public List() {
    values = (Type[]) new Object[2];
    lastFreeIndex = 0;
  }

  private void grow() {
    int newLength = lastFreeIndex + lastFreeIndex / 2;
    Type[] newValues = (Type[]) new Object[newLength];

    // copying old values
    for (int i = 0; i < lastFreeIndex; i++) {
      newValues[i] = values[i];
    }
    values = newValues;
  }

  public void add(Type element) {
    if (lastFreeIndex == values.length) {
      grow();

    }
    values[lastFreeIndex] = element;
    lastFreeIndex++;
  }

  public void remove(Type element) {
    int elementIndex = indexOfValue(element);
    if (elementIndex < 0)
      return;

    shiftToLeft(elementIndex);
    lastFreeIndex--;

  }

  public Type value(int index) {
    if (index < 0 || index >= lastFreeIndex)
      throw new ArrayIndexOutOfBoundsException("Index " + index + " outside of [0, " + lastFreeIndex + "]");
    return values[index];
  }

  private void shiftToLeft(int fromIndex) {
    for (int i = fromIndex; i < lastFreeIndex - 1; i++) {
      values[i] = values[i + 1];
    }
  }

  public boolean contains(Type element) {
    return indexOfValue(element) >= 0;
  }

  public int indexOfValue(Type element) {
    for (int i = 0; i < lastFreeIndex; i++) {
      if (values[i] == element || values[i].equals(element))
        return i;
    }
    return -1;
  }

  public int size() {
    return lastFreeIndex;
  }

}
