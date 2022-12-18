package snaked.model;

import javafx.scene.image.Image;
import lombok.Getter;

public enum SnakeSkin {
    //TODO: as soon as we have all the images for the snake skin, we can add them as arguments for the enums
    ONE(1, new Image("snaked/Images/Snake_Head.png"), new Image("snaked/Images/Snake_Body.png")),
    TWO(2, null, null),
    THREE(3, null, null);

    @Getter private final int ordinalRepresentation;

    @Getter private final Image headImage;
    @Getter private final Image bodyImage;

    SnakeSkin(int ordinalRepresentation, Image headImage, Image bodyImage) {
        this.ordinalRepresentation = ordinalRepresentation;
        this.headImage = headImage;
        this.bodyImage = bodyImage;
    }
}
