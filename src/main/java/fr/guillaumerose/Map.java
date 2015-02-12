package fr.guillaumerose;

import java.util.List;

import lombok.AllArgsConstructor;
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

    @Data
    @AllArgsConstructor
    public static class RestrictedArea {
        private final int minX;
        private final int minY;
        private final int maxX;
        private final int maxY;
    }

    private final int maxX;
    private final int maxY;
    private final List<RestrictedArea> areas;

    public boolean canGo(int x, int y) {
        return !areas.stream().anyMatch(area -> between(x, area.getMinX(), area.getMaxX()) && between(y, area.getMinY(), area.getMaxY())) //
                && between(x, 0, maxX) && between(y, 0, maxY);
    }

    private static boolean between(int x, int min, int max) {
        return min <= x && x <= max;
    }
}