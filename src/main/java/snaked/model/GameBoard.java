package snaked.model;

import lombok.Getter;
import lombok.Setter;

import java.nio.file.Path;
import java.util.*;

public class GameBoard {
    private List<Coordinate> snakeCoords = new ArrayList<>();
    private Set<Coordinate> consumableCoords = new HashSet<>();
    private Set<Coordinate> wallCoords = new HashSet<>();

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
     *
     * @param ateConsumable If true, the snake grows by one cell
     */
    private void moveSnake(boolean ateConsumable) {
        if(ateConsumable)
            snakeCoords.remove(snakeCoords.size() - 1); // remove tail

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
    }

    /**
     * Spawns a new consumable on the game board
     */
    private void spawnConsumable(){
        Random random = new Random();
        int xRandom=random.nextInt(gameBoardWidth-1);
        int yRandom=random.nextInt(gameBoardHeight-1);
        consumableCoords.add(new Coordinate(xRandom, yRandom));
    }

    public boolean checkAlive(){
        return true;
        // TODO: complete this method
    }

    public boolean nextTurn(){
        moveSnake(false); // TODO: update ateConsumable

        return checkAlive();
    }
    public int getScore (){
        return snake.getEatenConsumables()*gameOptions.getDifficulty().getScoreMultiplier();
    }

}
