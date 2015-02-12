package fr.guillaumerose;

import fr.guillaumerose.Map.Direction;
import lombok.AllArgsConstructor;
import lombok.Data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Data
@AllArgsConstructor
public class Turtle {
    private static final Logger LOGGER = LoggerFactory.getLogger(Turtle.class);
    private final Map map;
    private int x;
    private int y;
    private Direction direction;

    public void forward() {
        LOGGER.info("Going forward. " + summary());
        switch (direction) {
        case N:
            y = map.canGo(x, y + 1) ? y + 1 : y;
            break;
        case E:
            x = map.canGo(x + 1, y) ? x + 1 : x;
            break;
        case W:
            x = map.canGo(x - 1, y) ? x - 1 : x;
            break;
        case S:
            y = map.canGo(x, y - 1) ? y - 1 : y;
            break;
        }
    }

    public void turnLeft() {
        LOGGER.info("Turn left. " + summary());
        direction = direction.getLeft();
    }

    public void turnRight() {
        LOGGER.info("Turn right. " + summary());
        direction = direction.getRight();
    }

    private String summary() {
        return "(" + x + ", " + y + ", " + direction + ")";
    }
}