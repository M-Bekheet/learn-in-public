
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LiteracyComparison {

  public static void main(String[] args) {
    try {
      Files.lines(Paths.get("literacy.csv")).map(line -> {
        String[] parts = line.split(",");
        String name = parts[3].trim();
        int year = Integer.valueOf(parts[4].trim());
        String gender = parts[2].split(" ")[1];
        double rate = Double.valueOf(parts[5]);

        return new Country(name, year, gender, rate);

      }).sorted((country, otherCountry) -> {
        double diff = country.getRate() - otherCountry.getRate();
        if (diff > 0)
          return 1;
        if (diff < 0)
          return -1;
        return 0;

      })
          .forEach(country -> System.out.println(country));

    } catch (Exception e) {
      System.out.println("Error: " + e);
    }
  }
}

class Country {
  private String name;
  private int year;
  private String gender;
  private double rate;

  public Country(String name, int year, String gender, double rate) {
    this.name = name;
    this.gender = gender;
    this.year = year;
    this.rate = rate;
  }

  public double getRate() {
    return this.rate;
  }

  @Override
  public String toString() {
    return name + " (" + year + "), " + gender + ", " + rate;
  }
}
