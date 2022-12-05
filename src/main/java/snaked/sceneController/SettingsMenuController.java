package snaked.sceneController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SettingsMenuController {
    @FXML
    ImageView volumeIcon = new ImageView();
    @FXML
    Button volumeButton = new Button();
    Image muteVolume = new Image("snaked/Icons/muteVolume.png");
    Image fullVolume = new Image("snaked/Icons/fullVolume.png");

    @FXML
    protected void volumeButtonClick(ActionEvent event) {
        if(volumeIcon.getImage() == fullVolume){
            volumeIcon.setImage(muteVolume);
        }
        else{
            volumeIcon.setImage((fullVolume));
        }
    }
}