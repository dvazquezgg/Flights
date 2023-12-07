package mx.edu.greengates.flights;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FlightRecord {
    private int flightNumber;
    private String departureAirport;
    private String arrivalAirport;
    private Date departureDate;
    private Date arrivalDate;
    private String departureTime;
    private String arrivalTime;
    private String airline;
    private int passengerCount;
    private int flightDuration;

    // SimpleDateFormat for parsing date and time
    private SimpleDateFormat dateTimeFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm a");

    public FlightRecord(String[] data) {
        this.flightNumber = Integer.parseInt(data[0]);
        this.departureAirport = data[1];
        this.arrivalAirport = data[2];
        try {
            this.departureDate = dateTimeFormat.parse(data[3] + " " + data[5]);
            this.arrivalDate = dateTimeFormat.parse(data[4] + " " + data[6]);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.airline = data[7];
        this.passengerCount = Integer.parseInt(data[8]);
        this.flightDuration = Integer.parseInt(data[9]);
    }

    public FlightRecord(int flightNumber, String departureAirport,
                        String arrivalAirport, String airLine) {
        this.flightNumber = flightNumber;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.departureDate = new Date();
        this.arrivalDate = new Date();
        this.airline = airLine;
        this.passengerCount = 0;
        this.flightDuration = 0;
    }

    public FlightRecord(int flightNumber,
                        String departureAirport,
                        String arrivalAirport,
                        String airLine, String departureDate,
                        String arrivalDate) {
        this.flightNumber = flightNumber;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.departureDate = new Date();
        this.arrivalDate = new Date();
        this.airline = airLine;
        this.passengerCount = 0;
        this.flightDuration = 0;
    }


    public FlightRecord(int flightNumber, String departureAirport,
                        String arrivalAirport, String airLine,
                        Date departureDate, Date arrivalDate,
                        int passengerCount, int flightDuration) {
        this.flightNumber = flightNumber;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.airline = airLine;
        this.passengerCount = passengerCount;
        this.flightDuration = flightDuration;
    }
    public int getFlightNumber() {
        return flightNumber;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public String getAirline() {
        return airline;
    }

    public int getPassengerCount() {
        return passengerCount;
    }

    public int getFlightDuration() {
        return flightDuration;
    }

    @Override
    public String toString() {
        return "mx.edu.greengates.flights.FlightRecord{" +
                "flightNumber=" + flightNumber +
                ", departureAirport='" + departureAirport + '\'' +
                ", arrivalAirport='" + arrivalAirport + '\'' +
                ", departureDate=" + departureDate +
                ", arrivalDate=" + arrivalDate +
                ", airline='" + airline + '\'' +
                ", passengerCount=" + passengerCount +
                ", flightDuration=" + flightDuration +
                "}\n";
    }


    public int compareTo(FlightRecord flightRecord) {

        // return this.flightNumber - flightRecord.getFlightNumber();
        return this.departureAirport.compareTo(flightRecord.getDepartureAirport());
    }
}