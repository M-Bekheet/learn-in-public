public class ProductWarehouseWithHistory extends ProductWarehouse {
  private ChangeHistory changeHistory;

  public ProductWarehouseWithHistory(String productName, double capacity, double initialBalance) {
    super(productName, capacity);
    super.addToWarehouse(initialBalance);
    this.changeHistory = new ChangeHistory();
    this.changeHistory.add(initialBalance);
  }

  @Override
  public void addToWarehouse(double amount) {
    super.addToWarehouse(amount);
    changeHistory.add(super.getBalance());
  }

  @Override
  public double takeFromWarehouse(double amount) {
    double balance = super.takeFromWarehouse(amount);
    changeHistory.add(super.getBalance());
    return balance;
  }

  public String history() {
    return changeHistory.toString();
  }

  public void printAnalysis() {
    System.out.println("Product: " + this.getName());
    System.out.println("History: " + history());
    System.out.println("Largest amount of product: " + changeHistory.maxValue());
    System.out.println("Smallest amount of product: " + changeHistory.minValue());
    System.out.println("Average: " + changeHistory.average());
  }

}
