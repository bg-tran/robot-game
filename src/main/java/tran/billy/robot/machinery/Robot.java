package tran.billy.robot.machinery;

import tran.billy.robot.controller.CommandStatus;
import tran.billy.robot.navigation.Direction;
import tran.billy.robot.navigation.Position;

public interface Robot {
    /**
     * Place this robot on its target surface at position (X,Y) facing direction F
     * @param position the intending position
     * @param direction the intending direction
     * @return true if success
     */
    CommandStatus place(Position position, Direction direction);

    /**
     * Turn this robot counterclockwise 90 degrees from current direction
     * @return new direction if success
     */
    CommandStatus turnLeft();

    /**
     * Turn this robot clockwise 90 degrees from current direction
     * @return new direction if success
     */
    CommandStatus turnRight();

    /**
     * Move this robot forward
     * @return new position if success
     */
    CommandStatus move();

    /**
     * Report current position and direction
     * @return current position and direction in string format if success
     */
    CommandStatus report();
}
