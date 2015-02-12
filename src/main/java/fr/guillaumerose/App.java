package fr.guillaumerose;

import lombok.Data;

import static fr.guillaumerose.App.Direction.*;

public class App {

    public static enum Direction {
        N, S, E, W;
    }

    @Data
    public static class Map {
        private final int maxX;
        private final int maxY;
    }

    @Data
    public static class Turtle {
        private final Map map;
        private int x = 0;
        private int y = 0;
        private Direction direction = N;

        public void forward() {

        }

        public void turnLeft() {

        }

        public void turnRight() {

        }
    }

    public static void main(String[] args) {
        Map map = new Map(100, 100);
        Turtle turtle = new Turtle(map);
        turtle.forward();
        turtle.turnLeft();
        turtle.forward();
        turtle.forward();
        turtle.forward();
    }
}
