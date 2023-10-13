public class Product {
  private double price;
  private String name;
  private int quantity;

  public Product(String initialName, double initialPrice, int initialQuantity) {
    this.name = initialName;
    this.price = initialPrice;
    this.quantity = initialQuantity;
  }

  public void printProduct() {
    System.out.println(this.name + ", " + this.price + ", " + this.quantity);
  }

}
