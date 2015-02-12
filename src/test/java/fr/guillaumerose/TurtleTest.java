package fr.guillaumerose;

import org.junit.Test;

import static fr.guillaumerose.Map.Direction.*;
import static org.assertj.core.api.Assertions.*;

public class TurtleTest {
    private final Map map = new Map(50, 100);

    @Test
    public void should_go_forward() throws Exception {
        Turtle turtle = new Turtle(map, 0, 0, N);
        turtle.forward();
        assertThat(turtle).isEqualTo(new Turtle(map, 0, 1, N));
    }

    @Test
    public void should_not_go_beyond_maxY() throws Exception {
        Turtle turtle = new Turtle(map, 0, 98, N);
        turtle.forward();
        turtle.forward();
        turtle.forward();
        assertThat(turtle).isEqualTo(new Turtle(map, 0, 100, N));
    }

    @Test
    public void should_go_to_the_east() throws Exception {
        Turtle turtle = new Turtle(map, 0, 0, E);
        turtle.forward();
        assertThat(turtle).isEqualTo(new Turtle(map, 1, 0, E));
    }

    @Test
    public void should_not_go_beyond_maxX() throws Exception {
        Turtle turtle = new Turtle(map, 48, 0, E);
        turtle.forward();
        turtle.forward();
        turtle.forward();
        assertThat(turtle).isEqualTo(new Turtle(map, 50, 0, E));
    }

    @Test
    public void should_go_to_the_south() throws Exception {
        Turtle turtle = new Turtle(map, 0, 25, S);
        turtle.forward();
        turtle.forward();
        turtle.forward();
        assertThat(turtle).isEqualTo(new Turtle(map, 0, 22, S));
    }

    @Test
    public void should_go_to_the_west() throws Exception {
        Turtle turtle = new Turtle(map, 10, 0, W);
        turtle.forward();
        assertThat(turtle).isEqualTo(new Turtle(map, 9, 0, W));
    }

    @Test
    public void should_not_go_below_zero() throws Exception {
        Turtle turtle = new Turtle(map, 0, 0, S);
        turtle.forward();
        assertThat(turtle).isEqualTo(new Turtle(map, 0, 0, S));

        turtle = new Turtle(map, 0, 0, W);
        turtle.forward();
        assertThat(turtle).isEqualTo(new Turtle(map, 0, 0, W));
    }
}
