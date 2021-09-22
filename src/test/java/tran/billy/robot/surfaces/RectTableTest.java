package tran.billy.robot.surfaces;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tran.billy.robot.navigation.Position;

class RectTableTest {

    RectTable testSurface;
    @BeforeEach
    void setup() {
        testSurface = new RectTable(5,5);
    }

    @Test
    void isPositionAvailable_Valid_Position(){
        Assertions.assertTrue(testSurface.isPositionAvailable(new Position(3,3)),"Position inside surface's boundary should return true");
    }

    @Test
    void isPositionAvailable_Invalid_Position(){
        Assertions.assertFalse(testSurface.isPositionAvailable(new Position(5,5)),"Position outside surface's boundary should return false");
        Assertions.assertFalse(testSurface.isPositionAvailable(new Position(0,5)),"Position outside surface's boundary should return false");
        Assertions.assertFalse(testSurface.isPositionAvailable(new Position(0,-1)),"Position outside surface's boundary should return false");
    }
}