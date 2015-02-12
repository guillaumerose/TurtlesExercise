package fr.guillaumerose;

import lombok.Data;

@Data
public class Map {
    public static enum Direction {
        N("W", "E"), S("E", "W"), E("N", "S"), W("S", "N");

        private final String left;
        private final String right;

        private Direction(String left, String right) {
            this.left = left;
            this.right = right;
        }

        public Direction getLeft() {
            return valueOf(left);
        }

        public Direction getRight() {
            return valueOf(right);
        }
    }

    private final int maxX;
    private final int maxY;
}