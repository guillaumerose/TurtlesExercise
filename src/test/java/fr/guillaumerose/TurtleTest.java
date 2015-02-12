package fr.guillaumerose;

import org.junit.Test;

import static com.google.common.collect.Lists.*;
import static fr.guillaumerose.Map.Direction.*;
import static org.assertj.core.api.Assertions.*;

public class TurtleTest {
    private final Map map = new Map(50, 100, newArrayList());

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

    @Test
    public void should_be_able_to_turn_left() throws Exception {
        Turtle turtle = new Turtle(map, 0, 0, N);
        turtle.turnLeft();
        assertThat(turtle.getDirection()).isEqualTo(W);
    }

    @Test
    public void should_be_able_to_turn_right() throws Exception {
        Turtle turtle = new Turtle(map, 0, 0, E);
        turtle.turnRight();
        assertThat(turtle.getDirection()).isEqualTo(S);
    }

    @Test
    public void should_come_back_to_first_direction_after_4_turns() throws Exception {
        Turtle turtle = new Turtle(map, 0, 0, S);
        turtle.turnLeft();
        turtle.turnLeft();
        turtle.turnLeft();
        turtle.turnLeft();
        assertThat(turtle.getDirection()).isEqualTo(S);
        turtle.turnRight();
        turtle.turnRight();
        turtle.turnRight();
        turtle.turnRight();
        assertThat(turtle.getDirection()).isEqualTo(S);
    }

    @Test
    public void should_come_back_to_first_direction_after_left_and_right_turns() throws Exception {
        Turtle turtle = new Turtle(map, 0, 0, S);
        turtle.turnLeft();
        turtle.turnRight();
        assertThat(turtle.getDirection()).isEqualTo(S);
    }
}
