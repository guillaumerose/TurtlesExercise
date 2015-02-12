package fr.guillaumerose;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws Exception {
        Gson gson = new Gson();
        Turtle turtle = gson.fromJson(firstLine(args[0]), Turtle.class);
        turtle.forward();
        turtle.turnRight();
        turtle.forward();
        turtle.forward();
        turtle.forward();
    }

    private static String firstLine(String fileName) throws IOException {
        return Files.readLines(new File(fileName), Charsets.UTF_8).get(0);
    }
}
