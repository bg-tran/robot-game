package tran.billy.games.robot.character;

import tran.billy.games.robot.navigation.Navigator;
import tran.billy.games.robot.navigation.Direction;
import tran.billy.games.robot.navigation.Position;
import tran.billy.games.robot.sufaces.Surface;

/**
 *  An implementation of Robot
 */
public class SimpleRobot implements Robot {

    private Position position;
    private Direction direction;
    private final Surface surface;

    /**
     *  Constructor
     *  @param targetSurface a surface for this robot to be placed on
     *  @return robot instance
     */
    public SimpleRobot(Surface targetSurface){
        this.surface = targetSurface;
    }

    @Override
    public boolean place(Position position, Direction direction) {

        if (surface == null
                || !surface.isPositionAvailable(position)
                || direction == null
                || Direction.UNDEFINED.equals((direction))){
            return false;
        }

        this.position = position;
        this.direction = direction;

        return true;
    }

    @Override
    public Direction turnLeft() {

        Direction newDirection = Navigator.getNavigator().rotateLeft(this.direction);

        if (newDirection != null){
            this.direction = newDirection;
        }

        return this.direction;
    }

    @Override
    public Direction turnRight() {

        Direction newDirection = Navigator.getNavigator().rotateRight(this.direction);

        if (newDirection != null){
            this.direction = newDirection;
        }

        return this.direction;

    }

    @Override
    public Position move() {

        if (this.surface == null || this.position == null) {
            return null;
        }

        Position newPosition = Navigator.getNavigator().move(this.direction, this.position, Navigator.STEP_PER_MOVEMENT);

        if (surface.isPositionAvailable(newPosition)){
            this.position = newPosition;
        }

        return this.position;
    }

    @Override
    public String report() {
        if (this.surface == null || this.position == null) {
            return null;
        }
        return "Robot @ [" + this.position + ", " + this.direction + "]";
    }
}
