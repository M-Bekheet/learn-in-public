public class Song {
  private String name;
  private int length;

  public Song(String n, int l) {
    this.name = n;
    this.length = l;
  }

  public String name() {
    return this.name;
  }

  public int length() {
    return this.length;
  }
}
