package mx.edu.greengates.flights;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import mx.edu.greengates.utils.Validation;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

public class FlightRecordFormApp extends Application {

    private ArrayList<FlightRecord> flightRecords = new ArrayList<>();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Flight Record Form");

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        // Labels
        Label flightNumberLabel = new Label("Flight Number:");
        Label departureAirportLabel = new Label("Departure Airport:");
        Label arrivalAirportLabel = new Label("Arrival Airport:");
        Label airlineLabel = new Label("Airline:");
        Label departureDateLabel = new Label("Departure Date:");
        Label arrivalDateLabel = new Label("Arrival Date:");
        Label passengerCountLabel = new Label("Passenger Count:");
        Label flightDurationLabel = new Label("Flight Duration:");

        // TextFields
        TextField flightNumberTextField = new TextField();
        flightNumberTextField.setPromptText(flightNumberLabel.getText());
        TextField departureAirportTextField = new TextField();
        departureAirportTextField.setPromptText(departureAirportLabel.getText());
        TextField arrivalAirportTextField = new TextField();
        arrivalAirportTextField.setPromptText(arrivalAirportLabel.getText());
        TextField airlineTextField = new TextField();
        airlineTextField.setPromptText(airlineLabel.getText());
        TextField departureDateTextField = new TextField();
        departureDateTextField.setPromptText(departureDateLabel.getText());
        TextField arrivalDateTextField = new TextField();
        arrivalDateTextField.setPromptText(arrivalDateLabel.getText());
        DatePicker departureDatePicker = new DatePicker();
        departureDatePicker.setPromptText(departureDateLabel.getText());
        DatePicker arrivalDatePicker = new DatePicker();
        arrivalDatePicker.setPromptText(arrivalDateLabel.getText());
        TextField passengerCountTextField = new TextField();
        passengerCountTextField.setPromptText(passengerCountLabel.getText());
        TextField flightDurationTextField = new TextField();
        flightDurationTextField.setPromptText(flightDurationLabel.getText());

        // Button
        Button addButton = new Button("Add Flight Record");
        addButton.setOnAction(e -> {
            if (Validation.emptyOrNonNumeric(flightNumberTextField)) return;
            if (Validation.empty(departureAirportTextField)) return;
            if (Validation.empty(arrivalAirportTextField)) return;
            if (Validation.empty(airlineTextField)) return;
            if (Validation.empty(departureDatePicker)) return;
            if (Validation.empty(arrivalDatePicker)) return;
            if (Validation.emptyOrNonNumeric(passengerCountTextField)) return;
            if (Validation.emptyOrNonNumeric(flightDurationTextField)) return;

            addFlightRecord(
                            Integer.parseInt(flightNumberTextField.getText()),
                            departureAirportTextField.getText(),
                            arrivalAirportTextField.getText(),
                            airlineTextField.getText(),
                            departureDatePicker.getValue(),
                            arrivalDatePicker.getValue(),
                            Integer.parseInt(passengerCountTextField.getText()),
                            Integer.parseInt(flightDurationTextField.getText())
                    );

        });

        // Add components to the grid
        grid.add(flightNumberLabel, 0, 0);
        grid.add(flightNumberTextField, 1, 0);
        grid.add(departureAirportLabel, 0, 1);
        grid.add(departureAirportTextField, 1, 1);
        grid.add(arrivalAirportLabel, 0, 2);
        grid.add(arrivalAirportTextField, 1, 2);
        grid.add(airlineLabel, 0, 3);
        grid.add(airlineTextField, 1, 3);
        grid.add(departureDateLabel, 0, 4);
        grid.add(departureDatePicker, 1, 4);
        grid.add(arrivalDateLabel, 0, 5);
        grid.add(arrivalDatePicker, 1, 5);
        grid.add(passengerCountLabel, 0, 6);
        grid.add(passengerCountTextField, 1, 6);
        grid.add(flightDurationLabel, 0, 7);
        grid.add(flightDurationTextField, 1, 7);
        grid.add(addButton, 0, 8, 2, 1);

        Scene scene = new Scene(grid, 300, 600);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    private void addFlightRecord(int flightNumber, String departureAirport,
                                 String arrivalAirport, String airline,
                                 LocalDate departureDate, LocalDate arrivalDate,
                                 int passengerCount, int flightDuration){
        System.out.println("Adding Flight Record...");
        System.out.println("Departure Date: " + departureDate);
        System.out.println("Arrival Date: " + arrivalDate);
        FlightRecord record = new FlightRecord(flightNumber,
                departureAirport, arrivalAirport, airline,
                convertToLocalDateToDate(departureDate),
                convertToLocalDateToDate(arrivalDate),
                passengerCount, flightDuration);
        flightRecords.add(record);

        // Print the current list for demonstration purposes
        System.out.println("Flight Record added: " + record);
        System.out.println("Flights List: " + flightRecords);
    }


    private static Date convertToLocalDateToDate(LocalDate localDate) {
        // Convert LocalDate to Instant
        // An Instant represents a point in time in the UTC time zone
        // The time part is set to midnight (00:00:00)
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }


}

