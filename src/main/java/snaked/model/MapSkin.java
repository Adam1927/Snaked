package snaked.model;

import lombok.Getter;

import java.nio.file.Path;

public enum MapSkin {
    ONE(1, null),
    TWO(2, null),
    THREE(3, null);

    @Getter private final int ordinalRepresentation;
    @Getter private final Path mapFilePath;

    MapSkin(int ordinalRepresentation, Path mapFilePath) {
        this.ordinalRepresentation = ordinalRepresentation;
        this.mapFilePath = mapFilePath;
    }
}
