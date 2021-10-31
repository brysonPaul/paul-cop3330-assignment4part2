module ucf.assignments {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.junit.jupiter.api;
    opens ucf.assignments to javafx.fxml;
    exports ucf.assignments;
}