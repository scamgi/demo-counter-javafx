module com.example.democounterjavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.dotenv;


    opens com.example.democounterjavafx to javafx.fxml;
    exports com.example.democounterjavafx;
}