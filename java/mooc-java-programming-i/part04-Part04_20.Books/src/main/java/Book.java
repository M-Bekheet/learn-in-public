public class Book {
  String title;
  int pages;
  int publicationYear;

  public Book(String title, int pages, int publicationYear) {
    this.title = title;
    this.pages = pages;
    this.publicationYear = publicationYear;
  }

  public void printTitle() {
    System.out.println(title);
  }

  public String toString() {
    return title + ", " + pages + " pages, " + publicationYear;
  }

}
