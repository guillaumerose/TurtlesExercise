package fr.guillaumerose;

import static fr.guillaumerose.Map.Direction.*;

public class App {

    public static void main(String[] args) {
        Map map = new Map(100, 100);
        Turtle turtle = new Turtle(map, 0, 0, N);
        turtle.forward();
        turtle.turnLeft();
        turtle.forward();
        turtle.forward();
        turtle.forward();
    }
}
