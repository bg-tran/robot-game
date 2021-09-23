package tran.billy.robot.navigation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CartesianCoordinateCalculatorTest {

    CoordinateCalculator calculator = CartesianCoordinateCalculator.getCoordinateCalculator();

    @Test
    void nextCoordinates() {
        Assertions.assertEquals(new Position(1,0), calculator.nextCoordinates(Direction.EAST, new Position(0,0)),"Move EAST increases column by 1");
        Assertions.assertEquals(new Position(0,0), calculator.nextCoordinates(Direction.WEST, new Position(1,0)),"Move WEST decreases column by 1");
        Assertions.assertEquals(new Position(0,1), calculator.nextCoordinates(Direction.NORTH, new Position(0,0)),"Move NORTH increases row by 1");
        Assertions.assertEquals(new Position(0,0), calculator.nextCoordinates(Direction.SOUTH, new Position(0,1)),"Move SOUTH decreases row by 1");
        Assertions.assertEquals(new Position(0,0),calculator.nextCoordinates(Direction.UNDEFINED, new Position(0,0)),"Invalid direction should be ignored");
        Assertions.assertNull(calculator.nextCoordinates(null, new Position(0,0)),"Invalid input should be ignored");
        Assertions.assertNull(calculator.nextCoordinates(Direction.SOUTH, null),"Invalid input should be ignored");

    }
}