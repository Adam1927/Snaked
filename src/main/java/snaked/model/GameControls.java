package snaked.model;

import lombok.Getter;
import lombok.Setter;

public class GameControls {
    private Snake snake;

    @Setter private Direction currentDirection;
    private GameBoard gameBoard;

    private GameOptions gameOptions;

    public GameControls(Snake snake, GameBoard gameBoard, GameOptions gameOptions){
        this.snake = snake;
        this.gameBoard = gameBoard;
        this.currentDirection = gameOptions.getStartingDirection();
        this.gameOptions = gameOptions;
    }

    public boolean checkAlive(){
        return true;
        //TODO: complete this method
    }

    public boolean nextTurn(){
        gameBoard.updateSnakeCoordinates(currentDirection, false); // TODO: update ateConsumable
        
        return checkAlive();
    }
    public int getScore (){
        return snake.getEatenConsumables()*gameOptions.getDifficulty().getScoreMultiplier();
    }

}
