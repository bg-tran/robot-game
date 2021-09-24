package tran.billy.robot.machinery;

import tran.billy.robot.controller.CommandStatus;
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
    private Surface surface;
    private Navigator navigator;
    private CoordinateCalculator calculator;

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Surface getSurface() {
        return surface;
    }

    public Navigator getNavigator() {
        return navigator;
    }

    public CoordinateCalculator getCalculator() {
        return calculator;
    }

    public void setSurface(Surface surface) {
        this.surface = surface;
    }

    public void setNavigator(Navigator navigator) {
        this.navigator = navigator;
    }

    public void setCalculator(CoordinateCalculator calculator) {
        this.calculator = calculator;
    }

    /**
     *  Constructor
     *  @param targetSurface a surface for this robot to be placed on
     */
    public SimpleRobot(Surface targetSurface, Navigator navigator, CoordinateCalculator calculator){
        setSurface(targetSurface);
        setNavigator(navigator);
        setCalculator(calculator);
    }

    @Override
    public CommandStatus place(Position position, Direction direction) {

        if (getSurface() == null
                || !getSurface().isPositionAvailable(position)
                || direction == null
                || Direction.UNDEFINED.equals((direction))){
            return new CommandStatus(Boolean.FALSE);
        }

        setPosition(position);
        setDirection(direction);

        return new CommandStatus((Boolean.TRUE));
    }

    @Override
    public CommandStatus turnLeft() {

        Direction newDirection = getNavigator().rotateLeft(getDirection());
        if (newDirection != null){
            setDirection(newDirection);
        }

        return new CommandStatus(getDirection());
    }

    @Override
    public CommandStatus turnRight() {

        Direction newDirection = getNavigator().rotateRight(getDirection());
        if (newDirection != null){
            setDirection(newDirection);
        }

        return new CommandStatus(getDirection());

    }

    @Override
    public CommandStatus move() {

        if (getSurface() == null || getPosition() == null) {
            return new CommandStatus(null);
        }

        Position newPosition = getCalculator().nextCoordinates(getDirection(),getPosition());
        if (getSurface().isPositionAvailable(newPosition)){
            setPosition(newPosition);
        }

        return new CommandStatus(getPosition());
    }

    @Override
    public CommandStatus report() {
        return new CommandStatus(toString());
    }

    @Override
    public String toString(){
        if (getSurface() == null || getPosition() == null) {
            return null;
        }
        return "Robot @ [" + this.position + ", " + this.direction + "]";
    }
}
