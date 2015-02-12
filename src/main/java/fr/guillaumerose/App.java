package fr.guillaumerose;

import static com.google.common.collect.Lists.*;
import static fr.guillaumerose.Map.Direction.*;

public class App {
    public static void main(String[] args) {
        Map map = new Map(100, 100, newArrayList());
        Turtle turtle = new Turtle(map, 0, 0, N);
        turtle.forward();
        turtle.turnRight();
        turtle.forward();
        turtle.forward();
        turtle.forward();
    }
}
