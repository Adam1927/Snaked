package snaked.model;

import lombok.Getter;
import lombok.Setter;

import java.nio.file.Path;
import java.util.*;

public class GameBoard {
    private List<Coordinate> snakeCoords = new ArrayList<>();
    private Coordinate consumableCoords = null;


    private Snake snake;
    @Setter private Direction currentDirection;
    @Getter private final Path backgroundImage;
    @Getter private final int gameBoardHeight;
    @Getter private final int gameBoardWidth;
    @Getter private final GameOptions gameOptions;

    public GameBoard(int gameBoardHeight, int gameBoardWidth, Path backgroundImage, GameOptions gameOptions) {
        this.gameBoardHeight = gameBoardHeight;
        this.gameBoardWidth = gameBoardWidth;
        this.backgroundImage = backgroundImage;
        this.gameOptions = gameOptions;
    }

    /**
     * Updates the snake's coordinates
     * if the snake eats a consumable then it grows
     */
    private void moveSnake() {
        int headX = snakeCoords.get(0).getX();
        int headY = snakeCoords.get(0).getY();
        Coordinate newHeadCoords = null;
        switch (currentDirection) {
            case UP -> newHeadCoords = new Coordinate(headX, headY + 1);
            case RIGHT -> newHeadCoords = new Coordinate(headX + 1, headY);
            case DOWN -> newHeadCoords = new Coordinate(headX, headY - 1);
            case LEFT -> newHeadCoords = new Coordinate(headX - 1, headY);
        }
        snakeCoords.add(0, newHeadCoords);
        if(newHeadCoords.equals(consumableCoords)) {
            snake.increaseEatenConsumables();
            spawnConsumable();}
            else {
                snakeCoords.remove(snakeCoords.size()-1);
        }
    }

    /**
     * Spawns a new consumable on the game board
     */
    private void spawnConsumable(){
        Random random = new Random();
        int xRandom=random.nextInt(gameBoardWidth-1);
        int yRandom=random.nextInt(gameBoardHeight-1);
        consumableCoords = new Coordinate(xRandom, yRandom);
    }

    public boolean checkAlive(){
        Coordinate headCoords = snakeCoords.get(0);
        if(headCoords.getX() >= gameBoardWidth || headCoords.getY() >= gameBoardHeight ||
                headCoords.getX()< 0 || headCoords.getY()< 0){
            return false;

        }else {
            return true;
        }
        if()


    }

    public boolean nextTurn(){
        moveSnake(); // TODO: update ateConsumable

        return checkAlive();
    }
    public int getScore (){
        return snake.getEatenConsumables()*gameOptions.getDifficulty().getScoreMultiplier();
    }

}
