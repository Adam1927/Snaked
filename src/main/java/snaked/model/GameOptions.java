package snaked.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;

import java.io.IOException;
import java.io.InputStream;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class GameOptions {
    private int startingPosX;
    private int startingPosY;
    private int initialSnakeLength;
    private int gameBoardHeight;
    private int gameBoardWidth;
    private Direction startingDirection;
    private SnakeSkin snakeSkin;
    private boolean soundEffectsOn;
    private Difficulty difficulty;

    /**
     * Reads a JSON file, parses it into a GameOptions object and returns it.
     *
     * @return GameOptions object, containing all the properties read from the JSON file
     * @throws IOException if the path to the JSON file cannot be read
     */
    public static GameOptions fromJSON(InputStream file) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(file, GameOptions.class);
    }
}
