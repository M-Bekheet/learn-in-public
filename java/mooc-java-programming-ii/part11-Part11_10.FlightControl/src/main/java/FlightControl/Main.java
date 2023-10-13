package FlightControl;

import java.util.Scanner;

import FlightControl.logic.FlightControl;
import FlightControl.ui.UserInterface;

public class Main {

    public static void main(String[] args) {

        FlightControl flightControl = new FlightControl();
        Scanner scanner = new Scanner(System.in);
        UserInterface ui = new UserInterface(flightControl, scanner);
        ui.start();
    }
}
