public enum Education {
  BA("BA"), PHD("PHD"), MA("MA"),
  HS("HS");

  private String label;

  private Education(String label) {
    this.label = label;
  }

  public String toString() {
    return this.label;
  }
}