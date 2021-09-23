package tran.billy.robot.surfaces;

import tran.billy.robot.navigation.Position;

/**
 * A surface that a robot will be placed on and moving around
 */
public interface Surface {

    /**
     * Check if the position is available for the robot to occupy
     *
     * @param position target position
     * @return true if it is available/inside the surface or false if it is not
     */
    boolean isPositionAvailable(Position position);
}
