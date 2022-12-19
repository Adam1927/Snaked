package snaked;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import snaked.controller.SettingsMenuController;
import snaked.model.Direction;
import snaked.model.GameBoard;
import snaked.model.GameState;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

public class App extends Application{

    private Stage stage;
    private Scene scene;


    Image snakeLogo = new Image("snaked/Icons/snakeLogo.png");

    @FXML
    ImageView snakeLogoView = new ImageView(snakeLogo);

    @FXML
    Button scoreboardButton = new Button();
    @FXML
    Button settingsButton = new Button();

    @FXML
    Button startButton = new Button();

    public static Scene mainMenu;
    public static Scene gameScreen;
    public static Scene settingsMenu;

    public static File soundFile;
    public static AudioInputStream audioInputStream;
    public static Clip soundEffect;

//    static {
//        try {
//            audioInputStream = AudioSystem.getAudioInputStream(soundFile);
//            soundFile = new File("C:\\Users\\amirp\\group11\\group-11\\src\\main\\resources\\snaked\\sounds\\soundtrack.wav");
//            soundEffect = AudioSystem.getClip();
//        } catch (UnsupportedAudioFileException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        } catch (LineUnavailableException e) {
//            throw new RuntimeException(e);
//        }
//    }

    public static Scene gameOverScreen;

    @Override
    public void start(Stage stage) throws IOException, ClassNotFoundException, UnsupportedAudioFileException, LineUnavailableException {
        GameState.createInstance(App.class.getResourceAsStream("config/initialSettings.json"));
        //load the data
        GameState.getInstance().loadScores();
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("view/MainMenu.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Snaked");

        Image icon = new Image("snaked/Icons/snake.png"); // icon for the app
        stage.getIcons().add(icon); // setting the icon


        snakeLogo = new Image("snaked/Icons/snakeLogo.png");
        snakeLogoView = new ImageView(snakeLogo);
        stage.setResizable(false);

        Button scoreboardButton = new Button();
        scene.getStylesheets().add(getClass().getResource("cssStyles/MainMenu.css").toExternalForm());

        //Adding sound effect TODO

        soundFile = new File("C:\\Users\\amirp\\group11\\group-11\\src\\main\\resources\\snaked\\sounds\\soundtrack.wav");
        audioInputStream = AudioSystem.getAudioInputStream(soundFile);
        soundEffect = AudioSystem.getClip();
        soundEffect.open(audioInputStream);
        soundEffect.start();

        stage.setScene(scene);
        stage.show();

        mainMenu = scene;
    }

    //methods
    public void startGame(ActionEvent event) throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("view/GameBoard.fxml"));
        scene = new Scene(fxmlLoader.load());
        scene.setOnKeyPressed(onKeyPressedEvent());
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.show();

        gameScreen = scene;
    }

    private static EventHandler<KeyEvent> onKeyPressedEvent() {
        return keyEvent -> {
            KeyCode k = keyEvent.getCode();
            GameBoard gameBoard = GameState.getInstance().getGameBoard();
            System.out.println(k.getChar());

            switch (k) {
                case W, UP -> {
                    if(gameBoard.getCurrentDirection() != Direction.DOWN)
                        gameBoard.setCurrentDirection(Direction.UP);
                }
                case A, LEFT -> {
                    if(gameBoard.getCurrentDirection() != Direction.RIGHT)
                        gameBoard.setCurrentDirection(Direction.LEFT);
                }
                case S, DOWN -> {
                    if(gameBoard.getCurrentDirection() != Direction.UP)
                        gameBoard.setCurrentDirection(Direction.DOWN);
                }
                case D, RIGHT -> {
                    if(gameBoard.getCurrentDirection() != Direction.LEFT)
                        gameBoard.setCurrentDirection(Direction.RIGHT);
                }
            }
        };
    }

    // -- Scoreboard button functionality
    public void goToScoreboard(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("view/scoreboard.fxml"));
        scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(getClass().getResource("cssStyles/scoreboard.css").toExternalForm());

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    // -- Settings button functionality
    public void goToSettings(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("view/SettingsMenu.fxml"));
        scene = new Scene(fxmlLoader.load());

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

        settingsMenu = scene;
    }

    public static void main(String[] args) {
        launch();
        //before the app closes we save the scores
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                GameState.getInstance().saveScores();
            } catch (IOException e) {
                GameState.getInstance().getLogger().warning("Could not save scores");
            }
        }));
    }
}