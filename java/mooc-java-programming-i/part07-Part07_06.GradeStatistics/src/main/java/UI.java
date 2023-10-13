import java.util.Scanner;

public class UI {
  private Scanner scanner;
  private Stats stats;

  public UI(Scanner scanner) {
    this.scanner = scanner;
    this.stats = new Stats();
  }

  public void ready() {
    System.out.println("Enter point totals, -1 stops:");
    while (true) {

      String input = scanner.nextLine();
      int number = Integer.valueOf(input);
      if (number == -1)
        break;
      if (number < 0 || number > 100)
        continue;
      Grade grade = new Grade();
      grade.setValue(number);
      stats.addGrade(grade);

    }
    System.out.println("Point average (all): " + stats.average());
    double passingGradesAverage = stats.passingGradesAverage();
    double passingPercentage = stats.passingPercentage();
    System.out.println("Point average (passing): " + (passingGradesAverage > 0 ? passingGradesAverage : "-"));
    System.out.println("Pass percentage: " + passingPercentage);
    System.out.println("Grade distribution:");
    stats.printGradesDistribution();
  }
}
