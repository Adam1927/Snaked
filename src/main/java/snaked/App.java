package snaked;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import snaked.model.GameOptions;

import java.io.IOException;

public class App extends Application {

    private Stage stage;
    private Scene scene;


    Image snakeLogo = new Image("C:\\Users\\amirp\\group11\\group-11\\src\\main\\resources\\snaked\\Icons\\snakeLogo.png");

    @FXML
    ImageView snakeLogoView = new ImageView(snakeLogo);

    @FXML
    Button scoreboardButton = new Button();
    @FXML
    Button settingsButton = new Button();

    @Override
    public void start(Stage stage) throws IOException {
        System.out.println(
                GameOptions.fromJSON("C:\\Users\\amirp\\group11\\group-11\\src\\main\\resources\\snaked\\config\\initialSettings.json")
        );
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("view/MainMenu.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        stage.setTitle("Snake Game");

        Image icon = new Image("C:\\Users\\amirp\\group11\\group-11\\src\\main\\resources\\snaked\\Icons\\snake.png"); // icon for the app
        stage.getIcons().add(icon); // setting the icon


        snakeLogo = new Image("C:\\Users\\amirp\\group11\\group-11\\src\\main\\resources\\snaked\\Icons\\snakeLogo.png");
        snakeLogoView = new ImageView(snakeLogo);

        stage.setResizable(false);

        Button scoreboardButton = new Button();


        stage.setScene(scene);
        stage.show();
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

    // -- Settings button functionality
    public void goToSettings(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("view/settings.fxml"));
        scene = new Scene(fxmlLoader.load());

        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}