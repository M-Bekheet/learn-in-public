
public class Money {

    private final int euros;
    private final int cents;

    public Money(int euros, int cents) {

        if (cents > 99) {
            euros = euros + cents / 100;
            cents = cents % 100;
        }

        this.euros = euros;
        this.cents = cents;
    }

    public Money plus(Money addition) {
        Money newMoney = new Money(euros + addition.euros, cents + addition.cents);
        return newMoney;
    }

    public boolean lessThan(Money compared) {
        if (this.euros > compared.euros)
            return false;
        if (this.euros == compared.euros && (this.cents > compared.cents))
            return false;
        return true;
    }

    public Money minus(Money decreaser) {
        double totalA = euros * 100 + cents;
        double totalB = decreaser.euros * 100 + decreaser.cents;
        int newEuros = (int) ((totalA - totalB) / 100);
        double newCents = (totalA - totalB - newEuros * 100);
        if (newEuros < 0)
            newEuros = 0;
        if (newCents < 0)
            newCents = 0;
        Money money = new Money((int) newEuros, (int) newCents);
        return money;
    }

    public int euros() {
        return this.euros;
    }

    public int cents() {
        return this.cents;
    }

    public String toString() {
        String zero = "";
        if (this.cents < 10) {
            zero = "0";
        }

        return this.euros + "." + zero + this.cents + "e";
    }

}
