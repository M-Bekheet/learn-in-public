public class Debt {
  private double balance = 0;
  private double interestRate = 0;

  public Debt(double initBalance, double initInterestRate) {
    this.balance = initBalance;
    this.interestRate = initInterestRate;

  }

  public void printBalance() {
    System.out.println(this.balance);
  }

  public void waitOneYear() {
    this.balance = this.balance * this.interestRate;
  }
}
