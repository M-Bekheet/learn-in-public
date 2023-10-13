public class Game {
  private String homeTeam;
  private String otherTeam;
  private int homePoints;
  private int otherPoints;

  public Game(String homeTeam, String otherTeam, int homePoints, int otherPoints) {
    this.homeTeam = homeTeam;
    this.otherTeam = otherTeam;
    this.homePoints = homePoints;
    this.otherPoints = otherPoints;
  }

  public String getHomeTeam() {
    return this.homeTeam;
  }

  public String getOtherTeam() {
    return this.otherTeam;
  }

  public int getHomePoints() {
    return this.homePoints;
  }

  public int getOtherPoints() {
    return this.otherPoints;
  }

  public boolean isWinner(String team) {
    if (team.equals(homeTeam) && homePoints > otherPoints)
      return true;
    if (team.equals(otherTeam) && homePoints < otherPoints)
      return true;

    return false;

  }
}
