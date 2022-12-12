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
}
