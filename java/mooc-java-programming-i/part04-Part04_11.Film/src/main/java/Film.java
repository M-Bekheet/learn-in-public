public class Film {
  private String name;
  private int ageRating;

  public Film(String n, int a) {
    this.name = n;
    this.ageRating = a;
  }

  public int ageRating() {
    return ageRating;
  }

  public String name() {
    return this.name;
  }
}
