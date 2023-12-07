package mx.edu.greengates.flights;

import mx.edu.greengates.utils.ReadCSV;
import mx.edu.greengates.utils.SearchingAlgorithms;
import mx.edu.greengates.utils.SortingAlgorithms;

import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Opt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.printf("Flight Record Program!%n%n");

        String fileName = "flight_records.csv";
        ReadCSV readCSV = new ReadCSV(fileName);
        readCSV.read();
        List<List<String>> records = readCSV.getRecords();

        FlightRecord[] flightRecords = new FlightRecord[records.size() - 1];
        FlightRecord[] flightRecordsA = new FlightRecord[records.size() - 1];
        FlightRecord[] flightRecordsB = new FlightRecord[records.size() - 1];


        int count = 0;
        for (List<String> record : records) {
            if (count > 0) {
                // convert List<String> to String[]
                String[] recordArray = record.toArray(new String[0]);
                FlightRecord flightRecord = new FlightRecord(recordArray);
                flightRecords[count - 1] = flightRecord;
                // System.out.println(flightRecord);
            }
            count++;
        }

        // copy flightRecords to flightRecordsA and flightRecordsB
        for (int i = 0; i < flightRecords.length; i++) {
            flightRecordsA[i] = flightRecords[i];
            flightRecordsB[i] = flightRecords[i];
        }

        System.out.printf("%nTotal records: %d%n", flightRecords.length);

        System.out.println("flightRecords[0] = " + flightRecords[0]);
        System.out.println("flightRecords[1] = " + flightRecords[1]);
        System.out.println("Compare flightRecords[0] and flightRecords[1]: " + flightRecords[0].compareTo(flightRecords[1]));

        //print system timestamp
        //long bubbleIni = System.currentTimeMillis();
        //SortingAlgorithms.bubbleSort(flightRecordsA);
        //long bubbleFin = System.currentTimeMillis();
        //System.out.println("BubbleSort finished [ " + (bubbleFin - bubbleIni) + "]");
        //for(FlightRecord flightRecord : flightRecordsA){
        //    System.out.println(flightRecord);
        //}

        //long selectionIni = System.currentTimeMillis();
        //SortingAlgorithms.selectionSort(flightRecordsB);
        //long selectionFin = System.currentTimeMillis();
        //System.out.println("SelectionSort finished [ " + (selectionFin - selectionIni) + "]");
        //for(FlightRecord flightRecord : flightRecordsB){
        //    System.out.println(flightRecord);
        //}


        FlightRecord fr = SearchingAlgorithms.sequentialSearch(flightRecords, 4578);
        System.out.println("Sequential Search: " + fr);
    }
}