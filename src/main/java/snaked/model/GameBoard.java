package snaked.model;

import lombok.Getter;
import lombok.Setter;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameBoard {
    private final List<Coordinate> snakeCoords = new ArrayList<>();
    private Coordinate consumableCoords = null;


    @Setter private Direction currentDirection;
    @Getter private final Path backgroundImage;
    @Getter private final int gameBoardHeight;
    @Getter private final int gameBoardWidth;

    public GameBoard(int gameBoardHeight, int gameBoardWidth, Path backgroundImage) {
        this.gameBoardHeight = gameBoardHeight;
        this.gameBoardWidth = gameBoardWidth;
        this.backgroundImage = backgroundImage;
        spawnConsumable();
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
        if (newHeadCoords.equals(consumableCoords)) {
            GameState.getInstance().getSnake().increaseEatenConsumables();
            spawnConsumable();
        } else {
            snakeCoords.remove(snakeCoords.size() - 1);
        }
    }

    /**
     * Spawns a new consumable on the game board
     */
    private void spawnConsumable() {
        Random random = GameState.getInstance().getRandomGen();

        int xRandom = random.nextInt(gameBoardWidth - 1);
        int yRandom = random.nextInt(gameBoardHeight - 1);
        consumableCoords = new Coordinate(xRandom, yRandom);
    }

    /**
     * Checks if the snake is alive or dead
     * The snake is dead if it hit a wall or its own body
     *
     * @return true if the snake is alive, false if dead
     */
    private boolean checkAlive() {
        Coordinate headCoords = snakeCoords.get(0);
        // check if snake is outside the gameBoard
        if (headCoords.getX() >= gameBoardWidth || headCoords.getY() >= gameBoardHeight ||
                headCoords.getX() < 0 || headCoords.getY() < 0) {
            return false;


        } else { // check if snake hits itself
            List<Coordinate> bodyCoords = new ArrayList<>(snakeCoords);
            bodyCoords.remove(0);
            if (bodyCoords.contains(headCoords)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Execute the next turn
     * This includes:
     * - Moving the snake
     * - Checking if it ate a consumable (if yes, growing its size)
     * - Spawning a new consumable if the current one has been eaten
     *
     * @return true if the game continues, false if game over
     */
    public boolean nextTurn() {
        moveSnake();

        return checkAlive();
    }

    /**
     * Get the score of the current game
     * The score is calculated using the current difficulty and the eaten consumables
     *
     * @return score of the current game
     */
    public int getScore() {
        Snake snake = GameState.getInstance().getSnake();
        Difficulty difficulty = GameState.getInstance().getOptions().getDifficulty();
        return snake.getEatenConsumables() * difficulty.getScoreMultiplier();
    }

    public BoardCell[][] getBoardAsArray() {
        // TODO:
        return null;
    }

}
