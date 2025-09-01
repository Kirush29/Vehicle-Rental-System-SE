package org.example.studentsystem;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.SQLException;

public class HelloApplication extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Student Management System");

        try (Connection conn = DBConnection.getConnection()) {
            showAlert(Alert.AlertType.INFORMATION, "Database connected successfully!");
        } catch (SQLException e) {
            showAlert(Alert.AlertType.ERROR, "Failed to connect to database: " + e.getMessage());
            return;
        }

        VBox menu = new VBox(10);
        menu.setPadding(new Insets(20));
        menu.setAlignment(Pos.CENTER);

        Button courseBtn = new Button("Manage Courses");
        courseBtn.setOnAction(e -> new CourseController().showWindow());
        Button studentBtn = new Button("Manage Students");
        studentBtn.setOnAction(e -> new StudentController().showWindow());
        Button moduleBtn = new Button("Manage Modules");
        moduleBtn.setOnAction(e -> new ModuleController().showWindow());
        Button offersBtn = new Button("Manage Offers");
        offersBtn.setOnAction(e -> new OffersController().showWindow());

        menu.getChildren().addAll(courseBtn, studentBtn, moduleBtn, offersBtn);

        Scene scene = new Scene(menu, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void showAlert(Alert.AlertType type, String message) {
        Alert alert = new Alert(type);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}