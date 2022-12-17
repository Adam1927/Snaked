package snaked.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@ToString
public class GameBoard {
    private final List<Coordinate> snakeCoords = new ArrayList<>();
    private Coordinate consumableCoords = null;

    @Setter private Direction currentDirection = GameState.getInstance().getOptions().getStartingDirection();

    /**
     * Create the GameBoard
     * Spawn a consumable randomly on the board
     * Place the Snake on the GameBoard
     * Adjust the position of the snake's body depending on the starting position of the snake
     */
    public GameBoard() {
        spawnConsumable();
        GameOptions options = GameState.getInstance().getOptions();
        Direction startingDirection = options.getStartingDirection();
        int initialSnakeLength = options.getInitialSnakeLength();
        snakeCoords.add(new Coordinate (options.getStartingPosX(), options.getStartingPosY()));

        for(int i=1; i<options.getInitialSnakeLength(); i++){
            switch (currentDirection) {
                case UP -> snakeCoords.add(new Coordinate(options.getStartingPosX(), options.getStartingPosY()-i));
                case RIGHT -> snakeCoords.add(new Coordinate(options.getStartingPosX()-i, options.getStartingPosY()));
                case DOWN -> snakeCoords.add(new Coordinate(options.getStartingPosX(), options.getStartingPosY()+i));
                case LEFT -> snakeCoords.add(new Coordinate(options.getStartingPosX()+i, options.getStartingPosY()));
        }
    }
        if(!checkCoordInsideGameBoard(snakeCoords.get(0)) || !checkCoordInsideGameBoard(snakeCoords.get(snakeCoords.size()-1))){
            throw new IllegalStateException("The snake is outside the game board");
        }
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

        int xRandom = random.nextInt(GameState.getInstance().getOptions().getGameBoardWidth() - 1);
        int yRandom = random.nextInt(GameState.getInstance().getOptions().getGameBoardHeight() - 1);
        consumableCoords = new Coordinate(xRandom, yRandom);
        System.out.println(consumableCoords);
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
        if (!checkCoordInsideGameBoard(headCoords)) {
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
     * Checks if the snake head coordinates or body coordinates is outside the game board
     * @param coordinate Coordinates to check
     * @return true if within boundaries, otherwise false
     */
    private boolean checkCoordInsideGameBoard(Coordinate coordinate){
        if(coordinate.getX() >= GameState.getInstance().getOptions().getGameBoardWidth() ||
                coordinate.getY() >= GameState.getInstance().getOptions().getGameBoardHeight() ||
                coordinate.getX() < 0 || coordinate.getY() < 0){
            return false;
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
        return GameState.getInstance().getSnake().getEatenConsumables() * difficulty.getScoreMultiplier();
    }

    /**
     * Create a two-dimensional array of board cells
     * Add the coordinates of the head, body parts and consumable
     * @return the board
     */
    public BoardCell[][] getBoardAsArray() {
        BoardCell[][] board = new BoardCell[GameState.getInstance().getOptions().getGameBoardWidth()][GameState.getInstance().getOptions().getGameBoardHeight()];
        List<Coordinate> bodyCoords = new ArrayList<>(snakeCoords);
        bodyCoords.remove(0);
        Coordinate headCoords = snakeCoords.get(0);
        for (Coordinate bodyCoord : bodyCoords) {
            board[bodyCoord.getX()][bodyCoord.getY()] = BoardCell.SNAKE_BODYPART;
        }
        board[headCoords.getX()][headCoords.getY()] = BoardCell.SNAKE_HEAD;
        board[consumableCoords.getX()][consumableCoords.getY()] = BoardCell.CONSUMABLE;
        return board;
    }

}
