package com.example.demo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginForm extends Application {

    private TextField usernameField;
    private PasswordField passwordField;
    private Label messageLabel;
    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("LoginForm");

        usernameField = new TextField();
        usernameField.setPromptText("username");
        passwordField = new PasswordField();
        passwordField.setPromptText("password");


        Button loginButton = new Button();
        loginButton.setOnAction(event->{
            String username = usernameField.getText();
            String password = passwordField.getText();
            if(username.equals("admin") && password.equals("password")){
                messageLabel.setText("login successful");
            }else{
                messageLabel.setText("invalid username or password");
            }
        });
        messageLabel = new Label();

        // Создаем сетку для размещения элементов формы
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));
        gridPane.add(new Label("Username:"), 0, 0);
        gridPane.add(usernameField, 1, 0);
        gridPane.add(new Label("Password:"), 0, 1);
        gridPane.add(passwordField, 1, 1);
        gridPane.add(loginButton, 1, 2);
        gridPane.add(messageLabel, 1, 3);

        // Создаем вертикальный контейнер для размещения сетки и кнопки выхода
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().add(gridPane);

        // Создаем кнопку выхода из приложения
        Button exitButton = new Button("Exit");
        exitButton.setOnAction(event -> primaryStage.close());

        // Создаем горизонтальный контейнер для размещения кнопки выхода
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().add(exitButton);

        // Создаем сцену и добавляем на нее вертикальный и горизонтальный контейнеры
        Scene scene = new Scene(new VBox(vBox, hBox), 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}