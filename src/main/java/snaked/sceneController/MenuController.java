package snaked.sceneController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import snaked.App;

import java.io.IOException;

public class MenuController {

    // --Attributes
    private Stage stage;
    private Scene scene;
    //--Buttons
    @FXML
    private Button startButton = new Button();



    @FXML
    private Button scoreboardButton = new Button();

    private Image cup = new Image("C:\\Users\\amirp\\group11\\group-11\\src\\main\\resources\\snaked\\Icons\\scoreboardButton.png");
    private ImageView cupView = new ImageView(cup);




    // --Constructor
    public MenuController(){

    }

    //methods
    public void startGame(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("view/GameBoard.fxml"));
        scene = new Scene(fxmlLoader.load());
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.show();
    }

    // -- Scoreboard button functionality
    public void goToScoreboard(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("view/scoreboard.fxml"));
        scene = new Scene(fxmlLoader.load());

        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
