module org.example.studentsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens org.example.studentsystem to javafx.fxml;
    exports org.example.studentsystem;
}