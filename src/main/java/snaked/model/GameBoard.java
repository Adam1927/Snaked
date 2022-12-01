package snaked.model;

import lombok.Getter;

import java.nio.file.Path;
import java.util.*;

public class GameBoard {
    private final BoardCell[][] cells;

    private List<Coordinate> snakeCoords = new ArrayList<>();
    @Getter
    private final Path backgroundImage;
    @Getter
    private final int gameBoardHeight;
    @Getter
    private final int gameBoardWidth;

    public GameBoard(int gameBoardHeight, int gameBoardWidth, Path backgroundImage) {
        this.gameBoardHeight = gameBoardHeight;
        this.gameBoardWidth = gameBoardWidth;
        this.backgroundImage = backgroundImage;
        cells = new BoardCell[gameBoardHeight][gameBoardWidth];
    }

    /**
     * Updates the snake's coordinates
     *
     * @param direction Direction the snake is going in
     * @param ateConsumable If true, the snake grows by one cell
     */
    public void updateSnakeCoordinates(Direction direction, boolean ateConsumable) {
        if (direction == null)
            throw new IllegalArgumentException("Direction must not be null");

        if(ateConsumable)
            snakeCoords.remove(snakeCoords.size() - 1); // remove tail

        int headX = snakeCoords.get(0).getX();
        int headY = snakeCoords.get(0).getY();
        Coordinate newHeadCoords = null;
        switch (direction) {
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
    public void spawnConsumable(){
        Random random = new Random();
        int xRandom=random.nextInt(gameBoardWidth-1);
        int yRandom=random.nextInt(gameBoardHeight-1);
        consumableCoords.add(new Coordinate(xRandom, yRandom));
    }
}
