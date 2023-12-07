package mx.edu.greengates.utils;

import mx.edu.greengates.flights.FlightRecord;

public class SortingAlgorithms {

    public static void bubbleSort(FlightRecord[] array) {
        int n = array.length;
        FlightRecord temp;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                count++;
                if (array[j - 1].compareTo(array[j]) > 0) {
                    //swap elements
                    temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
                if (count % 1000000 == 0)
                    System.out.println(count);
            }
        }
        System.out.println("Bubble Sort: " + count);
    }


    public static void selectionSort(FlightRecord[] array) {

        int n = array.length;
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in unsorted array
            int min_idx = i;

            for (int j = i + 1; j < n; j++) {
                count++;
                if (array[j].compareTo(array[min_idx]) < 0) {
                    min_idx = j;
                }
                if (count % 1000000 == 0)
                    System.out.println(count);
            }

            // Swap the found minimum element with the first
            // element
            FlightRecord temp = array[min_idx];
            array[min_idx] = array[i];
            array[i] = temp;
        }
        System.out.println("Selection Sort: " + count);

    }
}
