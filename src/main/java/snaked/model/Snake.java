package snaked.model;

import lombok.Getter;

public class Snake {
    @Getter
    private final int initialLength;
    @Getter
    private int eatenConsumables = 0;

    public Snake(int initialLength ) {
        if (initialLength <=0 ){
            throw new IllegalArgumentException("initialLength must be greater than 0");
        }
        this.initialLength = initialLength;

    }

    public void increaseEatenConsumables() {
        eatenConsumables++;
    }

    public int getCurrentLength() {
        return initialLength + eatenConsumables;
    }

}
