package FlightControl.ui;

import java.util.Scanner;
import FlightControl.logic.FlightControl;
import FlightControl.domain.Airplane;
import FlightControl.domain.Flight;

public class UserInterface {
  private Scanner scanner;
  private FlightControl flightControl;

  public UserInterface(FlightControl flightControl, Scanner scanner) {
    this.flightControl = flightControl;
    this.scanner = scanner;
  }

  public void start() {
    startAssetControl();
    startFlightControl();
  }

  private void startAssetControl() {
    System.out.println("Airport Asset Control");
    while (true) {

      System.out.println("Choose an action:");
      System.out.println("[1] Add an airplane");

      System.out.println("[2] Add a flight");
      System.out.println("[x] Exit Airport Asset Control");
      // System.out.print("> ");

      String command = scanner.nextLine();
      if (command.equals("x"))
        break;
      if (command.equals("1")) {
        addAirplane();
      }
      if (command.equals("2")) {
        addFlight();
      }

    }

  }

  private void startFlightControl() {
    System.out.println("Flight Control");
    while (true) {
      System.out.println("Choose an action:");
      System.out.println("[1] Print airplanes");
      System.out.println("[2] Print flights");
      System.out.println("[3] Print airplane details");
      System.out.println("[x] Quit");
      // System.out.print("> ");
      String command = scanner.nextLine();
      if (command.equals("x"))
        break;
      if (command.equals("1")) {
        flightControl.printAirplanes();
      }
      if (command.equals("2")) {
        flightControl.printFlights();
      }
      if (command.equals("3")) {
        System.out.print("Give the airplane id: ");
        String planeId = scanner.nextLine();
        flightControl.printAirplanesDetails(planeId);
      }

    }
  }

  private void addAirplane() {
    System.out.print("Give the airplane id: ");
    String ID = scanner.nextLine();
    System.out.print("Give the airplane capacity: ");
    int capacity = Integer.valueOf(scanner.nextLine());

    Airplane airplane = new Airplane(ID, capacity);
    flightControl.addAirplane(ID, airplane);
  }

  private void addFlight() {
    System.out.print("Give the airplane id: ");
    String airplaneId = scanner.nextLine();
    System.out.print("Give the departure airport id: ");
    String departureId = scanner.nextLine();
    System.out.print("Give the target airport id: ");
    String targetId = scanner.nextLine();

    Flight flight = new Flight(airplaneId, departureId, targetId);
    flightControl.addFlight(flight.toString(), flight);
  }
}
