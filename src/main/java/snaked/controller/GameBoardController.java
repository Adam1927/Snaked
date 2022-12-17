package snaked.controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import snaked.App;
import snaked.model.BoardCell;
import snaked.model.GameBoard;
import snaked.model.GameState;
import snaked.model.Snake;

import java.io.IOException;
import java.net.URISyntaxException;

public class GameBoardController {


    @FXML Stage stage;
    @FXML Scene scene;

    @FXML
    Text highestScore = new Text();

    @FXML
    Text eatenConsumables = new Text();

    @FXML GridPane grid = new GridPane();

    // -- constructor.
    public GameBoardController() {

    }

    @FXML
    public void initialize() throws URISyntaxException, InterruptedException {
        GameState.getInstance().setGameBoard(new GameBoard());
        GameState.getInstance().setSnake(new Snake());
        int numCols = GameState.getInstance().getOptions().getGameBoardWidth();
        int numRows = GameState.getInstance().getOptions().getGameBoardHeight();

        for (int i = 0; i < numCols; i++) {
            grid.getColumnConstraints().add(new ColumnConstraints(grid.getPrefWidth() / numCols));
        }
        for (int i = 0; i < numRows; i++) {
            grid.getRowConstraints().add(new RowConstraints(grid.getPrefHeight() / numRows));
        }

        Timeline tl = new Timeline();
        tl.setCycleCount(Animation.INDEFINITE);
        double cellHeight = grid.getPrefHeight()/numRows;
        double cellWidth = grid.getPrefWidth()/numCols;
        Image snakeHead = new Image("snaked/Images/Snake_Head.png", cellWidth, cellHeight, true, true);
        Image snakeBody = new Image("snaked/Images/Snake_Body.png", cellWidth, cellHeight, true, true);
        Image apple = new Image("snaked/Images/Apple.png", cellWidth, cellHeight, true, true);

        KeyFrame keyframe = new KeyFrame(Duration.seconds(0.5 * 1/GameState.getInstance().getOptions().getDifficulty().getSpeedMultiplier()),
                event -> {
                    if (!GameState.getInstance().getGameBoard().nextTurn()) {
                        tl.stop();
                        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("view/GameOver.fxml"));
                        try {
                            scene = new Scene(fxmlLoader.load());
                            stage = (Stage) (eatenConsumables.getScene().getWindow());
                            stage.setScene(scene);
                            stage.show();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }

                        return;
                    }

                    Integer highscoreValue = 0;
                    if(GameState.getInstance().getNHighestScores(1).size() > 0) {
                        highscoreValue = GameState.getInstance().getNHighestScores(1).get(0);
                    }
                    highestScore.setText(highscoreValue.toString());

                    eatenConsumables.setText(Integer.toString(GameState.getInstance().getGameBoard().getScore()));

                    for (int i = 0; i < grid.getChildren().size(); i++) {
                        grid.getChildren().remove(i);
                    }
                    BoardCell[][] board = GameState.getInstance().getGameBoard().getBoardAsArray();
                    for (int x = 0; x < board.length; x++) {
                        for (int y = 0; y < board[0].length; y++) {
                            BoardCell cell = board[x][y];
                            if (cell != null) {
                                switch (cell) {
                                    case SNAKE_HEAD -> {
                                        grid.add(new ImageView(snakeHead), x, GameState.getInstance().getOptions().getGameBoardHeight()-y);
                                    }
                                    case SNAKE_BODYPART -> {
                                        grid.add(new ImageView(snakeBody), x, GameState.getInstance().getOptions().getGameBoardHeight()-y);
                                    }
                                    case CONSUMABLE -> {
                                        grid.add(new ImageView(apple), x, GameState.getInstance().getOptions().getGameBoardHeight()-y);
                                    }
                                }
                            }

                        }
                    }
                });

        tl.getKeyFrames().add(keyframe);
        tl.play();
    }

    // --methods
    // -- for changing the highest score if current score goes higher than top score.
    public void setNewHighestScore(int score) {

        this.highestScore.setText(String.valueOf(score));

    }

    // -- Method for going back to main menu.
    public void goToMainMenu(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("view/MainMenu.fxml"));

        this.scene = new Scene(fxmlLoader.load());

        this.stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.show();

    }

//    // --Method for updating the current score.
//    public void setCurrentScore() { // this will be changed after different difficulties are made.
//        int currentMultiplier = GameState.getInstance().getOptions().getDifficulty().getScoreMultiplier();
//        int score = GameState.getInstance().getSnake().getCurrentLength();
//
//        score *= currentMultiplier; // we can only eat one consumable at each time.
//
//        this.currentScore.setText(String.valueOf(score));
//    }

    //This is just a button to view the game over screen without running the game
    @FXML
    protected void testGameOverClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("view/GameOver.fxml"));
        scene = new Scene(fxmlLoader.load());

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
