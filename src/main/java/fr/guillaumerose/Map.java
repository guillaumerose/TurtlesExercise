package fr.guillaumerose;

import lombok.Data;

@Data
public class Map {
    public static enum Direction {
        N, S, E, W;
    }

    private final int maxX;
    private final int maxY;
}