import java.util.HashMap;

public class Abbreviations {
  private HashMap<String, String> abbreviations;

  public Abbreviations() {
    abbreviations = new HashMap();
  }

  public void addAbbreviation(String abbreviation, String explanation) {
    if (abbreviations.containsKey(abbreviation))
      System.out.println("Already exist!");
    else {
      String sanitizedAbbreviation = sanitizeString(abbreviation);
      abbreviations.put(sanitizedAbbreviation, explanation);
    }
  }

  public boolean hasAbbreviation(String abbreviation) {
    abbreviation = sanitizeString(abbreviation);
    if (abbreviations.containsKey(abbreviation))
      return true;
    return false;
  }

  public String findExplanationFor(String abbreviation) {
    String sanitizedAbbreviation = sanitizeString(abbreviation);
    if (hasAbbreviation(sanitizedAbbreviation)) {
      return abbreviations.get(sanitizedAbbreviation);
    }
    return null;
  }

  public String sanitizeString(String text) {
    if (text == null)
      return "";
    String sanitized = text.trim().toLowerCase();
    return sanitized;
  }
}
