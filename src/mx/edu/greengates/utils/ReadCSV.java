package mx.edu.greengates.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;

public class ReadCSV {

    private String fileName;
    private List<List<String>> records;
    public static final String COMMA_DELIMITER = ",";

    public ReadCSV(String fileName) {
        this.fileName = fileName;
        this.records = new ArrayList<>();
    }

    public List<List<String>> getRecords() {
        return records;
    }

    public void read() {
        System.out.println("Reading file: " + this.fileName);
        // Reading file: data.csv

        try {
            File file = new File(this.fileName);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                records.add(getRecordFromLine(scanner.nextLine()));
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Error reading file: " + this.fileName);
            System.out.println(e.getMessage());
        }
    }

    private List<String> getRecordFromLine(String line) {
        List<String> values = new ArrayList<String>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(COMMA_DELIMITER);
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next());
            }
        }
        return values;
    }


}
