
public class SimpleDate {

    private int day;
    private int month;
    private int year;

    public SimpleDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public String toString() {
        return this.day + "." + this.month + "." + this.year;
    }

    public boolean before(SimpleDate compared) {
        if (this.year < compared.year) {
            return true;
        }

        if (this.year == compared.year && this.month < compared.month) {
            return true;
        }

        if (this.year == compared.year && this.month == compared.month &&
                this.day < compared.day) {
            return true;
        }

        return false;
    }

    public void advance() {
        if (day == 30) {
            day = 1;
            if (month == 12) {
                month = 1;
                year++;
            } else {
                month++;
            }
        } else {
            day++;
        }
    }

    public void advance(int howManyDays) {
        while (howManyDays-- > 0)
            advance();
    }

    public SimpleDate afterNumberOfDays(int days) {
        int newDay = (day + days) % 30;
        if (newDay == 0)
            newDay = 30;
        int newMonth = month + (day + days - newDay) / 30;
        int newYear = year;
        if (newMonth > 12) {
            newYear = year + newMonth / 12;
            newMonth = newMonth % 12;
        }
        return new SimpleDate(newDay, newMonth, newYear);
    }

}
