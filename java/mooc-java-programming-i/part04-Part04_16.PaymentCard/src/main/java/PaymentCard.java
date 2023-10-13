public class PaymentCard {
  private double balance;

  public PaymentCard(double openingBalance) {
    balance = openingBalance;
  }

  public void eatAffordably() {
    if (balance >= 2.6)
      balance -= 2.6;
  }

  public void eatHeartily() {
    if (balance >= 4.6)
      balance -= 4.6;

  }

  public void addMoney(double money) {
    if (money < 0)
      return;
    if (balance + money > 150) {
      balance = 150;
    } else
      balance += money;
  }

  @Override
  public String toString() {
    return "The card has a balance of " + balance + " euros";
  }
}
