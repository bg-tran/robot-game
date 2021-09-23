package tran.billy.robot.navigation;

import java.util.HashMap;

/**
 * A navigator to help the robot finding its direction
 * as well as calculating its new position before moving forward
 */
public class SimpleNavigator implements Navigator {

    private static Navigator navigator;

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
    @Override
    public Direction rotateLeft(Direction direction){
        return counterClockwise.get(direction);
    }

    /**
     * Calculate the new direction if the robot turns right from its current direction
     * @param direction current direction
     * @return new direction
     */
    @Override
    public Direction rotateRight(Direction direction){
        return clockwise.get(direction);
    }


    /**
     * Create a singleton of Navigator class
     * @return a cached navigator
     */
    public static Navigator getNavigator(){

        if (navigator == null) {
            navigator = new SimpleNavigator();
        }

        return navigator;
    }
}
