package snaked.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.io.InputStream;

/**
 * GameState Singleton
 * An instance of this class is created once and only once, at the beginning of the program.
 * Later, the instance can be accessed anywhere using GameState.getInstance()
 */
public class GameState {
    @Getter private static GameState instance;

    @Getter private final GameOptions options;
    @Getter @Setter private Snake snake;
    @Getter @Setter private GameBoard gameBoard;

    /**
     * Private constructor, so only one instance can be created (using the createInstance method)
     *
     * @param options GameOptions of the GameState
     */
    private GameState(GameOptions options) {
        this.options = options;
    }

    /**
     * Creates an instance of GameState.
     *
     * @param inputStream the inputStream (json format) to parse into the GameOptions
     * @return the GameState instance
     * @throws IOException           if the inputStream cannot be read
     * @throws IllegalStateException if an instance was already created previously
     */
    public static GameState createInstance(InputStream inputStream) throws IOException {
        if (instance != null) throw new IllegalStateException("Instance already exists");

        GameOptions gameOptions = (new ObjectMapper()).readValue(inputStream, GameOptions.class);
        instance = new GameState(gameOptions);
        return instance;
    }

}
