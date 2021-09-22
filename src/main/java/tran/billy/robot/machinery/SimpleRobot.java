package tran.billy.robot.machinery;

import tran.billy.robot.controller.CoordinatesCalculatorController;
import tran.billy.robot.controller.NavigatorController;
import tran.billy.robot.navigation.CoordinateCalculator;
import tran.billy.robot.navigation.Navigator;
import tran.billy.robot.navigation.Direction;
import tran.billy.robot.navigation.Position;
import tran.billy.robot.surfaces.Surface;

/**
 *  An implementation of Robot
 */
public class SimpleRobot implements Robot {

    private Position position;
    private Direction direction;
    private final Surface surface;
    private final Navigator navigator;
    private final CoordinateCalculator calculator;


    /**
     *  Constructor
     *  @param targetSurface a surface for this robot to be placed on
     */
    public SimpleRobot(Surface targetSurface, Navigator navigator, CoordinateCalculator calculator){
        this.surface = targetSurface;
        this.navigator = navigator;
        this.calculator = calculator;
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

        Direction newDirection = NavigatorController.navigateLeft(this.direction).use(this.navigator);

        if (newDirection != null){
            this.direction = newDirection;
        }

        return this.direction;
    }

    @Override
    public Direction turnRight() {

        Direction newDirection = NavigatorController.navigateRight(this.direction).use(this.navigator);
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

        Position newPosition = CoordinatesCalculatorController.getNextCoordinates(this.position, this.direction).use(this.calculator);

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
