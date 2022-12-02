package snaked.sceneController;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import snaked.App;

import java.io.IOException;

public class MenuController {
    // --Attributes
    private Stage stage;
    private Scene scene;

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
}
