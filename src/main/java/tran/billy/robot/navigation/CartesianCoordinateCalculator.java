package tran.billy.robot.navigation;

public class CartesianCoordinateCalculator implements CoordinateCalculator{

    public static final int UNIT_PER_MOVEMENT = 1;

    private static CoordinateCalculator calculator;

    @Override
    public Position nextCoordinates(Direction direction, Position position) {

        if (direction == null || position == null){
            return null;
        }

        switch (direction) {
            case EAST:
                return new Position(position.getCol() + UNIT_PER_MOVEMENT , position.getRow());

            case WEST:
                return new Position(position.getCol() - UNIT_PER_MOVEMENT , position.getRow());

            case NORTH:
                return new Position(position.getCol(), position.getRow() + UNIT_PER_MOVEMENT);

            case SOUTH:
                return new Position(position.getCol(), position.getRow() - UNIT_PER_MOVEMENT);

            default:
                return new Position(position.getCol(), position.getRow());
        }
    }

    public static CoordinateCalculator getCoordinateCalculator(){

        if (calculator == null) {
            calculator = new CartesianCoordinateCalculator();
        }
        return calculator;
    }
}

