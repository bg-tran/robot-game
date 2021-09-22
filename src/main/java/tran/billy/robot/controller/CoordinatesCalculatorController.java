package tran.billy.robot.controller;

import tran.billy.robot.navigation.CoordinateCalculator;
import tran.billy.robot.navigation.Direction;
import tran.billy.robot.navigation.Position;

/**
 * A command interface of a coordinate calculator to find new position
 * following Command design pattern
 */

@FunctionalInterface
public interface CoordinatesCalculatorController {

    Position use(CoordinateCalculator calculator);

    static CoordinatesCalculatorController getNextCoordinates(Position position, Direction direction){
        return calculator -> calculator.nextCoordinates(direction,position);
    }
}
