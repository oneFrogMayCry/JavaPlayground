module com.example.turtle {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.turtle to javafx.fxml;
    exports com.example.turtle;
}