package tran.billy.games.robot.navigation;

import java.util.HashMap;

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


    public Direction rotateLeft(Direction direction){
        return counterClockwise.get(direction);
    }

    public Direction rotateRight(Direction direction){
        return clockwise.get(direction);
    }

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

    public static Navigator getNavigator(){

        if (navigator == null) {
            navigator = new Navigator();
        }

        return navigator;
    }
}
