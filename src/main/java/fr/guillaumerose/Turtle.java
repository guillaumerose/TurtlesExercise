package fr.guillaumerose;

import fr.guillaumerose.Map.Direction;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Turtle {
    private final Map map;
    private int x;
    private int y;
    private Direction direction;

    public void forward() {
        switch (direction) {
        case N:
            y = map.getMaxY() >= y + 1 ? y + 1 : y;
            break;
        case E:
            x = map.getMaxX() >= x + 1 ? x + 1 : x;
            break;
        case W:
            x = 0 <= x - 1 ? x - 1 : x;
            break;
        case S:
            y = 0 <= y - 1 ? y - 1 : y;
            break;
        }
    }

    public void turnLeft() {
        direction = direction.getLeft();
    }

    public void turnRight() {
        direction = direction.getRight();
    }
}