package tran.billy.games.robot.character;

import tran.billy.games.robot.navigation.Direction;
import tran.billy.games.robot.navigation.Position;

public interface Robot {
    /**
     * Place this robot on its target surface at position (X,Y) facing direction F
     * @param position the intending position
     * @param direction the intending direction
     * @return true if success
     */
    boolean place(Position position, Direction direction);

    /**
     * Turn this robot counterclockwise 90 degrees from current direction
     * @return new direction if success
     */
    Direction turnLeft();

    /**
     * Turn this robot clockwise 90 degrees from current direction
     * @return new direction if success
     */
    Direction turnRight();

    /**
     * Move this robot forward
     * @return new position if success
     */
    Position move();

    /**
     * Report current position and direction
     * @return current position and direction in string format if success
     */
    String report();
}
