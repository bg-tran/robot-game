package tran.billy.robot.navigation;

public interface CoordinateCalculator {

    /**
     * Calculate the new position if the robot moves forward from its current position
     * @param direction current direction
     * @param position current position
     * @return new position
     */
    Position nextCoordinates(Direction direction, Position position);
}
