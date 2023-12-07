module Flights {
    requires javafx.controls;
    requires javafx.fxml;

    opens mx.edu.greengates.flights to javafx.fxml;

    exports mx.edu.greengates.flights;
}