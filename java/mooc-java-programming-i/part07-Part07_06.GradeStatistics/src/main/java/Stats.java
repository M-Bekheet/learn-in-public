import java.util.ArrayList;

public class Stats {
  // private double average;
  private ArrayList<Grade> grades;
  private ArrayList<Grade> passingGrades;

  public Stats() {
    this.grades = new ArrayList<>();
    this.passingGrades = new ArrayList<>();
  }

  public double average() {
    int total = 0;
    for (Grade grade : grades)
      total += grade.value();
    if (total <= 0)
      return 0;
    return 1.0 * total / grades.size();
  }

  public double passingGradesAverage() {
    int total = 0;
    for (Grade grade : passingGrades)
      total += grade.value();
    if (total <= 0)
      return 0;
    return 1.0 * total / passingGrades.size();
  }

  public void addGrade(Grade grade) {
    this.grades.add(grade);
    if (grade.value() >= 50)
      this.passingGrades.add(grade);
  }

  public double passingPercentage() {
    if (passingGrades.size() == 0 || grades.size() == 0)
      return 0;
    return 100.0 * passingGrades.size() / grades.size();
  }

  public void printGradesDistribution() {
    for (int i = 5; i >= 0; i--) {
      System.out.print(i + ": ");
      for (Grade grade : grades) {
        if (grade.tier() == i)
          System.out.print("*");
      }
      System.out.println();
    }
  }
}
