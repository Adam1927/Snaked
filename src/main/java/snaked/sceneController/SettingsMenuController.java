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
    Button easyButton = new Button();
    @FXML
    Button mediumButton = new Button();
    @FXML
    Button hardButton = new Button();
    @FXML
    Button map1Button = new Button();
    @FXML
    Button map2Button = new Button();
    @FXML
    Button map3Button = new Button();
    @FXML
    Button snake1Button = new Button();
    @FXML
    Button snake2Button = new Button();
    @FXML
    Button snake3Button = new Button();


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


    @FXML //changes color of buttons to indicate what options have been chosen.
    protected void easyButtonClick(){
        easyButton.setStyle("-fx-background-color: #443c3c");
        mediumButton.setStyle("-fx-background-color: #000000");
        hardButton.setStyle("-fx-background-color: #000000");
    }
    @FXML
    protected void mediumButtonClick(){
        easyButton.setStyle("-fx-background-color: #000000");
        mediumButton.setStyle("-fx-background-color: #443c3c");
        hardButton.setStyle("-fx-background-color: #000000");
    }
    @FXML
    protected void hardButtonClick(){
        easyButton.setStyle("-fx-background-color: #000000");
        mediumButton.setStyle("-fx-background-color: #000000");
        hardButton.setStyle("-fx-background-color: #443c3c");
    }
    @FXML
    protected void map1ButtonClick(){
        map1Button.setStyle("-fx-background-color: #443c3c");
        map2Button.setStyle("-fx-background-color: #000000");
        map3Button.setStyle("-fx-background-color: #000000");
    }
    @FXML
    protected void map2ButtonClick(){
        map1Button.setStyle("-fx-background-color: #000000");
        map2Button.setStyle("-fx-background-color: #443c3c");
        map3Button.setStyle("-fx-background-color: #000000");
    }
    @FXML
    protected void map3ButtonClick(){
        map1Button.setStyle("-fx-background-color: #000000");
        map2Button.setStyle("-fx-background-color: #000000");
        map3Button.setStyle("-fx-background-color: #443c3c");
    }
    @FXML
    protected void snake1ButtonClick(){
        snake1Button.setStyle("-fx-background-color: #443c3c");
        snake2Button.setStyle("-fx-background-color: #000000");
        snake3Button.setStyle("-fx-background-color: #000000");
    }
    @FXML
    protected void snake2ButtonClick(){
        snake1Button.setStyle("-fx-background-color: #000000");
        snake2Button.setStyle("-fx-background-color: #443c3c");
        snake3Button.setStyle("-fx-background-color: #000000");
    }
    @FXML
    protected void snake3ButtonClick(){
        snake1Button.setStyle("-fx-background-color: #000000");
        snake2Button.setStyle("-fx-background-color: #000000");
        snake3Button.setStyle("-fx-background-color: #443c3c");
    }


}