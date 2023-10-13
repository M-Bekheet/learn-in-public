package FlightControl.logic;

import java.util.HashMap;
import FlightControl.domain.Airplane;
import FlightControl.domain.Flight;

public class FlightControl {
  private HashMap<String, Airplane> airplanes;
  private HashMap<String, Flight> flights;

  public FlightControl() {
    airplanes = new HashMap<String, Airplane>();
    flights = new HashMap<String, Flight>();
  }

  public void addAirplane(String ID, Airplane airplane) {
    airplanes.put(ID, airplane);
  }

  public void addFlight(String flightId, Flight flight) {
    flights.put(flightId, flight);
  }

  public void printAirplanes() {
    for (Airplane airplane : airplanes.values()) {
      System.out.println(airplane);
      System.out.println();
    }
  }

  public void printAirplanesDetails(String airplaneId) {
    if (airplanes.containsKey(airplaneId)) {
      System.out.println(airplanes.get(airplaneId));
      System.out.println();
    }
  }

  public void printFlights() {
    for (Flight flight : flights.values()) {
      Airplane airplane = airplanes.get(flight.getAirplaneId());

      String msg = airplane + " (" + flight.getDepartureAirport() + "-" + flight.getTargetAirport() + ")";

      System.out.println(msg);
      System.out.println();

    }
  }

}
