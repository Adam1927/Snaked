package snaked.model;

import lombok.Getter;

public enum Difficulty {
    EASY(1, 1),
    MEDIUM(2, 2),
    HARD(4, 4);
    @Getter
    private final int scoreMultiplier;
    @Getter
    private final int speedMultiplier;

    Difficulty(int scoreMultiplier, int speedMultiplier) {
        this.scoreMultiplier = scoreMultiplier;
        this.speedMultiplier = speedMultiplier;
    }
}
