package snaked.model;

import lombok.Getter;

import java.nio.file.Path;

public class GameBoard {
    private final BoardCell[][] cells;
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


}
