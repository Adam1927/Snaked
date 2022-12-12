package snaked.model;

import lombok.Getter;

import java.nio.file.Path;

public enum SnakeSkin {
    //TODO: as soon as we have the images for the snake skin, we can add them as arguments for the enums
    ONE(1, null, null),
    TWO(2, null, null),
    THREE(3, null, null);

    @Getter private final int ordinalRepresentation;

    @Getter private final Path bodyFileName;
    @Getter private final Path headFileName;

    SnakeSkin(int ordinalRepresentation, Path headFileName, Path bodyFileName) {
        this.ordinalRepresentation = ordinalRepresentation;
        this.headFileName = headFileName;
        this.bodyFileName = bodyFileName;
    }
}
