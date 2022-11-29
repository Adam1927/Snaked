package snaked.model;

import lombok.Getter;

public enum Difficulty {
    EASY(1, 1),
    MEDIUM(2, 2),
    HARD(4, 4);
    @Getter
    private final double scoreMultiplier;
    @Getter
    private final double speedMultiplier;

    Difficulty(double scoreMultiplier, double speedMultiplier) {
        this.scoreMultiplier = scoreMultiplier;
        this.speedMultiplier = speedMultiplier;
    }
}
