package snaked.sceneController;

import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.Node;
import snaked.App;

public class ScoreBoardController {


    @FXML //Back button that takes you to the manu screen
    private void returnToMenu(ActionEvent click){
        Node node = (Node) click.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(App.mainMenu);
    }

    @FXML //To display top 5 highest scores
    private void showHighScores(){

    }
}
