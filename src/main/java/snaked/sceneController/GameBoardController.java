package snaked.sceneController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import snaked.model.Difficulty;
import snaked.model.GameOptions;

import java.io.IOException;

public class GameBoardController {



    // -- Attributes of game board screen (snake & board cells should all be added here later).

    Stage stage;
    Scene scene;

    @FXML
    Text currentScore = new Text();
    @FXML
    Text highestScore = new Text();
    GameOptions gameOptions = new GameOptions();

    // -- constructor.
    public GameBoardController(){

    }

    // --methods
    // -- for changing the highest score if current score goes higher than top score.
    public void seNewtHighestScore(int score){

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
        int currentMultiplier = gameOptions.getDifficulty().getScoreMultiplier();

        int currentScore = Integer.parseInt(this.currentScore.getText());

        currentScore += currentMultiplier; // we can only eat one consumable at each time.

        this.currentScore.setText(String.valueOf(currentScore));
    }
}
