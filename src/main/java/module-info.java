module com.example.iarecursion {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.iarecursion to javafx.fxml;
    exports com.example.iarecursion;
}