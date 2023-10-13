
public class Checker {
  public boolean isDayOfWeek(String string) {
    return string.matches("sat|sun|mon|tue|wed|thu|fri");
  }

  public boolean allVowels(String string) {
    return string.matches("[aeiou]{1,}");
  }

  public boolean timeOfDay(String string) {
    /*
     * range 00:00:00 ==> 23:59:59
     * // first part:
     * // accept (0 or 1) + any number from 0 -> 9
     * // OR accept (2) + any number from 0 -> 3
     * 
     * // second part(minutes and seconds):
     * start with ":" and twice ( accept any number from 0 -> 9 + any number from 0
     * -> 9 )
     */
    return string.matches("(((0|1)[0-9])|2[0-3])(:[0-5][0-9]){2}");
  }
}
