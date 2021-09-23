package tran.billy.robot.navigation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SimpleNavigatorTest {

    Navigator navigator = SimpleNavigator.getNavigator();

    @Test
    void rotateLeft() {
        Assertions.assertEquals(navigator.rotateLeft(Direction.EAST),Direction.NORTH,"NORTH is left side of EAST");
        Assertions.assertEquals(navigator.rotateLeft(Direction.NORTH),Direction.WEST,"WEST is left side of NORTH");
        Assertions.assertEquals(navigator.rotateLeft(Direction.WEST),Direction.SOUTH,"SOUTH is left side of WEST");
        Assertions.assertEquals(navigator.rotateLeft(Direction.SOUTH),Direction.EAST,"EAST is left side of SOUTH");
    }

    @Test
    void rotateRight() {
        Assertions.assertEquals(navigator.rotateRight(Direction.EAST),Direction.SOUTH,"SOUTH is right side of EAST");
        Assertions.assertEquals(navigator.rotateRight(Direction.SOUTH),Direction.WEST,"WEST is right side of SOUTH");
        Assertions.assertEquals(navigator.rotateRight(Direction.WEST),Direction.NORTH,"NORTH is right side of WEST");
        Assertions.assertEquals(navigator.rotateRight(Direction.NORTH),Direction.EAST,"EAST is right side of NORTH");
    }

//    @Test
//    void move() {
//        Assertions.assertEquals(new Position(1,0), navigator.move(Direction.EAST, new Position(0,0),1),"Move EAST increases column by 1");
//        Assertions.assertEquals(new Position(0,0), navigator.move(Direction.WEST, new Position(1,0),1),"Move WEST decreases column by 1");
//        Assertions.assertEquals(new Position(0,1), navigator.move(Direction.NORTH, new Position(0,0),1),"Move NORTH increases row by 1");
//        Assertions.assertEquals(new Position(0,0), navigator.move(Direction.SOUTH, new Position(0,1),1),"Move SOUTH decreases row by 1");
//        Assertions.assertNull(navigator.move(null, new Position(0,0),1),"Invalid input should be ignored");
//        Assertions.assertNull(navigator.move(Direction.SOUTH, null,1),"Invalid input should be ignored");
//        Assertions.assertNull(navigator.move(Direction.UNDEFINED, new Position(0,0),1),"Invalid direction should be ignored");
//    }
}