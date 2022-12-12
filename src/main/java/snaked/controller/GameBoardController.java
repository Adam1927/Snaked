package snaked.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import snaked.model.GameOptions;
import snaked.model.GameState;

import java.io.IOException;

public class GameBoardController {



    Stage stage;
    Scene scene;

    @FXML
    Text currentScore = new Text();
    @FXML
    Text highestScore = new Text();

    // -- constructor.
    public GameBoardController(){

    }

    // --methods
    // -- for changing the highest score if current score goes higher than top score.
    public void setNewHighestScore(int score){

        this.highestScore.setText(String.valueOf(score));

    }

    // -- Method for going back to main menu.
    public void goToMainMenu(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("view/MainMenu.fxml"));

        this.scene = new Scene(fxmlLoader.load());

        this.stage = (Stage) ((Node)event.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.show();

    }

    // --Method for updating the current score.
    public void setCurrentScore(){ // this will be changed after different difficulties are made.
        int currentMultiplier = GameState.getInstance().getOptions().getDifficulty().getScoreMultiplier();
        int score = GameState.getInstance().getSnake().getCurrentLength();

        score *= currentMultiplier; // we can only eat one consumable at each time.

        this.currentScore.setText(String.valueOf(score));
    }
}
