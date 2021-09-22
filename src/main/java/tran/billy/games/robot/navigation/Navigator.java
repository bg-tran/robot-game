package tran.billy.games.robot.navigation;

import java.util.HashMap;

/**
 * A navigator to help the robot finding its direction
 * as well as calculating its new position before moving forward
 */
public class Navigator {

    private static Navigator navigator;

    public static int STEP_PER_MOVEMENT = 1;

    private final HashMap<Direction,Direction> clockwise = new HashMap<Direction,Direction>() {{
        put(Direction.NORTH,Direction.EAST);
        put(Direction.EAST,Direction.SOUTH);
        put(Direction.SOUTH,Direction.WEST);
        put(Direction.WEST,Direction.NORTH);
    }};
    private final HashMap<Direction,Direction> counterClockwise = new HashMap<Direction,Direction>() {{
        put(Direction.NORTH,Direction.WEST);
        put(Direction.WEST,Direction.SOUTH);
        put(Direction.SOUTH,Direction.EAST);
        put(Direction.EAST,Direction.NORTH);
    }};

    /**
     * Calculate the new direction if the robot turns left from its current direction
     * @param direction current direction
     * @return new direction
     */
    public Direction rotateLeft(Direction direction){
        return counterClockwise.get(direction);
    }

    /**
     * Calculate the new direction if the robot turns right from its current direction
     * @param direction current direction
     * @return new direction
     */
    public Direction rotateRight(Direction direction){
        return clockwise.get(direction);
    }

    /**
     * Calculate the new position if the robot moves forward from its current position
     * @param direction current direction
     * @param position current position
     * @return new position
     */
    public Position move(Direction direction, Position position, int steps){

        if (direction == null || position == null){
            return null;
        }
        switch (direction) {
            case EAST:
                return new Position(position.getCol() + steps , position.getRow());

            case WEST:
                return new Position(position.getCol() - steps , position.getRow());

            case NORTH:
                return new Position(position.getCol(), position.getRow() + steps);

            case SOUTH:
                return new Position(position.getCol(), position.getRow() - steps);

            default:
                return null;
        }
    }

    /**
     * Create a singleton of Navigator class
     * @return a cached navigator
     */
    public static Navigator getNavigator(){

        if (navigator == null) {
            navigator = new Navigator();
        }

        return navigator;
    }
}
