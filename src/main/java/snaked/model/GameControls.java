package snaked.model;

import lombok.Getter;
import lombok.Setter;

public class GameControls {
    private Snake snake;
    @Getter private int highscore=0;
    @Setter private Direction currentDirection;
    private GameBoard gameBoard;

    public GameControls(Snake snake, GameBoard gameBoard, Direction startingDirection){
        this.snake = snake;
        this.gameBoard = gameBoard;
        this.currentDirection = startingDirection;
    }

    public boolean checkAlive(){
        return true; //TODO: complete this method
    }

    public boolean nextTurn(){
        return true; //TODO:
    }


}
