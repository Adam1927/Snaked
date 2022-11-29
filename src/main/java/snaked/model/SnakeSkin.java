package snaked.model;

import lombok.Getter;

import java.nio.file.Path;

public enum SnakeSkin {
    //TODO: as soon as we have the images for the snake skin, we can add them as arguments for the enums
    ONE(null, null),
    TWO(null, null),
    THREE(null, null);

    @Getter private final Path bodyFileName;
    @Getter private final Path headFileName;

    private SnakeSkin(Path headFileName, Path bodyFileName) {
        this.headFileName = headFileName;
        this.bodyFileName = bodyFileName;
    }
}
