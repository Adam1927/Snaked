package snaked.sceneController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import snaked.App;




public class SettingsMenuController {
    @FXML
    ImageView volumeIcon = new ImageView();
    @FXML
    Button volumeButton = new Button();
    @FXML
    Button backButton = new Button();
    Image muteVolume = new Image("snaked/Icons/muteVolume.png");
    Image fullVolume = new Image("snaked/Icons/fullVolume.png");

    @FXML //button for toggling sound & changes buttons icon on click.
    protected void volumeButtonClick() {
        if(volumeIcon.getImage() == fullVolume){
            volumeIcon.setImage(muteVolume);
        }
        else{
            volumeIcon.setImage((fullVolume));
        }
    }
    @FXML //button that shows the original scene form the main menu
    protected void backButtonClick(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(App.mainMenu);
    }
}