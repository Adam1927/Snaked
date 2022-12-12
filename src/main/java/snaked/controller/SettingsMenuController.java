package snaked.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import snaked.App;

public class SettingsMenuController {
    public static final String SELECTED_STYLE = "-fx-background-color: #111111;-fx-text-fill: #fff;";
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
        easyButton.setStyle(SELECTED_STYLE);
        mediumButton.setStyle(null);
        hardButton.setStyle(null);
    }
    @FXML
    protected void mediumButtonClick(){
        easyButton.setStyle(null);
        mediumButton.setStyle(SELECTED_STYLE);
        hardButton.setStyle(null);
    }
    @FXML
    protected void hardButtonClick(){
        easyButton.setStyle(null);
        mediumButton.setStyle(null);
        hardButton.setStyle(SELECTED_STYLE);
    }
    @FXML
    protected void map1ButtonClick(){
        map1Button.setStyle(SELECTED_STYLE);
        map2Button.setStyle(null);
        map3Button.setStyle(null);
    }
    @FXML
    protected void map2ButtonClick(){
        map1Button.setStyle(null);
        map2Button.setStyle(SELECTED_STYLE);
        map3Button.setStyle(null);
    }
    @FXML
    protected void map3ButtonClick(){
        map1Button.setStyle(null);
        map2Button.setStyle(null);
        map3Button.setStyle(SELECTED_STYLE);
    }
    @FXML
    protected void snake1ButtonClick(){
        snake1Button.setStyle(SELECTED_STYLE);
        snake2Button.setStyle(null);
        snake3Button.setStyle(null);
    }
    @FXML
    protected void snake2ButtonClick(){
        snake1Button.setStyle(null);
        snake2Button.setStyle(SELECTED_STYLE);
        snake3Button.setStyle(null);
    }
    @FXML
    protected void snake3ButtonClick(){
        snake1Button.setStyle(null);
        snake2Button.setStyle(null);
        snake3Button.setStyle(SELECTED_STYLE);
    }




}