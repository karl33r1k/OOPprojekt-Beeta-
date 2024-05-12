module org.example.projektbeta {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.projektbeta to javafx.fxml;
    exports org.example.projektbeta;
}