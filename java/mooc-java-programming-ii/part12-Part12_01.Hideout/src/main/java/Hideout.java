
public class Hideout<T> {
  private T value;

  public void putIntoHideout(T toHide) {
    value = toHide;
  }

  public T takeFromHideout() {
    if (value.equals(null))
      return null;
    T oldValue = value;
    value = null; // if T was a reference type, that will be a problem as oldValue will be null
                  // too. So this method is not perfect
    return oldValue;
  }

  public boolean isInHideout() {
    return value != null;
  }

  public String toString() {
    return value.toString();
  }
}
