module com.example.democounterjavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.democounterjavafx to javafx.fxml;
    exports com.example.democounterjavafx;
}