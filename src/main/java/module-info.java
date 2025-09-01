module org.example.studentsystem {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.studentsystem to javafx.fxml;
    exports org.example.studentsystem;
}