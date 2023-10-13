
import java.util.Objects;

public class LicensePlate {
    // don't modify existing parts of this class

    // these instance variables have been defined as final, meaning
    // that once set, their value can't be changed
    private final String liNumber;
    private final String country;

    public LicensePlate(String country, String liNumber) {
        this.liNumber = liNumber;
        this.country = country;
    }

    @Override
    public String toString() {
        return country + " " + liNumber;
    }

    @Override
    public int hashCode() {
        return liNumber.hashCode() + country.hashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (object == null)
            return false;
        if (object == this)
            return true;
        if (!object.getClass().equals(this.getClass()))
            return false;

        LicensePlate that = (LicensePlate) object;
        if (!that.country.equals(this.country))
            return false;
        if (!that.liNumber.equals(this.liNumber))
            return false;
        return true;
    }

}
