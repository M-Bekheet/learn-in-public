package FlightControl.domain;

public class Flight {
  private String planeId;
  private String departureAirport;
  private String targetAirport;

  public Flight(String planeId, String departureId, String targetId) {
    this.planeId = planeId;
    this.departureAirport = departureId;
    this.targetAirport = targetId;
  }

  @Override
  public String toString() {
    return planeId + "-" + departureAirport + "-" + targetAirport;
  }

  public String getDepartureAirport() {
    return this.departureAirport;
  }

  public String getTargetAirport() {
    return this.targetAirport;
  }

  public String getAirplaneId() {
    return this.planeId;
  }

}
