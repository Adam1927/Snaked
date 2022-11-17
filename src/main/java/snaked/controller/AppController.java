package snaked.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import lombok.Getter;

@Getter
public class AppController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}