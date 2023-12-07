package mx.edu.greengates.utils;

import mx.edu.greengates.flights.FlightRecord;

public class SearchingAlgorithms {

    public static FlightRecord sequentialSearch(FlightRecord[] array, int flightNumber) {
        for (FlightRecord flightRecord : array) {
            if (flightRecord.getFlightNumber() == flightNumber) {
                return flightRecord;
            }
        }
        return null;
    }

    public static FlightRecord binarySearch(FlightRecord[] array, int flightNumber) {
        int left = 0;
        int right = array.length - 1;
        int middle = (left + right) / 2;
        while (left <= right) {
            if (array[middle].getFlightNumber() < flightNumber) {
                left = middle + 1;
            } else if (array[middle].getFlightNumber() == flightNumber) {
                return array[middle];
            } else {
                right = middle - 1;
            }
            middle = (left + right) / 2;
        }
        return null;
    }
}
