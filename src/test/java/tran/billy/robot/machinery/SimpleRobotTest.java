package tran.billy.robot.machinery;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tran.billy.robot.controller.CommandStatus;
import tran.billy.robot.navigation.CartesianCoordinateCalculator;
import tran.billy.robot.navigation.Direction;
import tran.billy.robot.navigation.Position;
import tran.billy.robot.navigation.SimpleNavigator;
import tran.billy.robot.surfaces.RectTable;

class SimpleRobotTest {

    Robot robot;
    @BeforeEach
    void setup() {

        robot = new SimpleRobot(new RectTable(5,5), SimpleNavigator.getNavigator(), CartesianCoordinateCalculator.getCoordinateCalculator());
        robot.place(new Position(3,3), Direction.findByName("NORTH"));
    }

    @Test
    void place() {
        Assertions.assertEquals(new CommandStatus(Boolean.TRUE),robot.place(new Position(3,4), Direction.findByName("NORTH")), "Robot should be placed at (3, 4) facing NORTH on the 5x5 surface");
        Assertions.assertEquals(new CommandStatus(Boolean.FALSE),robot.place(null, Direction.findByName("NORTH")), "Robot should NOT be placed at an invalid position on the 5x5 surface");
        Assertions.assertEquals(new CommandStatus(Boolean.FALSE),robot.place(new Position(3,4), Direction.findByName("FOO")), "Robot should NOT be placed at (3, 4) of the 5x5 surface without a valid direction");
        Assertions.assertEquals(new CommandStatus(Boolean.FALSE),robot.place(new Position(3,4), Direction.findByName("UNDEFINED")), "Robot should NOT be placed at (3, 4) of the 5x5 surface without a valid direction");
        Assertions.assertEquals(new CommandStatus(Boolean.FALSE),robot.place(new Position(6,4), Direction.findByName("NORTH")), "Robot should be NOT placed outside of the 5x5 surface");
        Assertions.assertEquals(new CommandStatus(Boolean.FALSE),robot.place(new Position(3,-3), Direction.findByName("NORTH")), "Robot should be NOT placed outside of the 5x5 surface");
        Assertions.assertEquals(new CommandStatus(Boolean.FALSE),(new SimpleRobot(null, null, null)).place(new Position(3,4), Direction.findByName("NORTH")), "Robot should NOT be placed on an invalid surface");
    }

    @Test
    void turnLeft() {

        Assertions.assertEquals(new CommandStatus(Direction.WEST), robot.turnLeft(),"Robot should face WEST after turning left from NORTH");
        robot.turnLeft();
        Assertions.assertEquals(new CommandStatus(Direction.EAST), robot.turnLeft(), "Robot should face EAST after turning left 3 times from NORTH");
        Assertions.assertEquals(new CommandStatus(null), (new SimpleRobot(null, SimpleNavigator.getNavigator(), CartesianCoordinateCalculator.getCoordinateCalculator()).turnLeft()),"Robot must be placed on a surface before being able to turn left");
    }

    @Test
    void turnRight() {

        Assertions.assertEquals(new CommandStatus(Direction.EAST), robot.turnRight(),"Robot should face EAST after turning right from NORTH");
        robot.turnRight();
        Assertions.assertEquals(new CommandStatus(Direction.WEST), robot.turnRight(), "Robot should face WEST after turning right times from NORTH");
        Assertions.assertEquals(new CommandStatus(null), (new SimpleRobot(null, SimpleNavigator.getNavigator(), CartesianCoordinateCalculator.getCoordinateCalculator()).turnRight()),"Robot must be placed on a surface before being able to turn right");
    }

    @Test
    void move_NORTH() {

        // moving NORTH
        Assertions.assertEquals(new CommandStatus(new Position(3, 4)), robot.move(), "Robot @ [(3,3), NORTH] should move to (3,4)");
        Assertions.assertEquals(new CommandStatus(new Position(3, 4)), robot.move(), "Robot @ [(3,4), NORTH] should not move outside the surface");

        robot.place(new Position(0, 4), Direction.findByName("NORTH"));
        Assertions.assertEquals(new CommandStatus(new Position(0, 4)), robot.move(), "Robot @ [(0,4), NORTH] should not move outside the surface");

        robot.place(new Position(4, 4), Direction.findByName("NORTH"));
        Assertions.assertEquals(new CommandStatus(new Position(4, 4)), robot.move(), "Robot @ [(4,4), NORTH] should not move outside the surface");
    }

    @Test
    void move_EAST() {
        // moving EAST
        robot.place(new Position(3, 4), Direction.findByName("EAST"));
        Assertions.assertEquals(new CommandStatus(new Position(4, 4)), robot.move(), "Robot @ [(3,4), EAST] should move to (4,4)");
        Assertions.assertEquals(new CommandStatus(new Position(4, 4)), robot.move(), "Robot @ [(4,4), EAST] should not move outside the surface");

        robot.place(new Position(4, 0), Direction.findByName("EAST"));
        Assertions.assertEquals(new CommandStatus(new Position(4, 0)), robot.move(), "Robot @ [(4,0), EAST] should not move outside the surface");

        robot.place(new Position(4, 4), Direction.findByName("EAST"));
        Assertions.assertEquals(new CommandStatus(new Position(4, 4)), robot.move(), "Robot @ [(4,4), EAST] should not move outside the surface");

        robot.place(new Position(4, 0), Direction.findByName("NORTH"));
        robot.turnRight();
        Assertions.assertEquals(new CommandStatus(new Position(4, 0)), robot.move(), "Robot @ [(4,0), EAST] should not move outside the surface");
    }

    @Test
    void move_SOUTH() {
        // moving SOUTH
        robot.place(new Position(3, 1), Direction.findByName("SOUTH"));
        Assertions.assertEquals(new CommandStatus(new Position(3, 0)), robot.move(), "Robot @ [(3,1), SOUTH] should move to (3,0)");
        Assertions.assertEquals(new CommandStatus(new Position(3, 0)), robot.move(), "Robot @ [(3,0), SOUTH] should not move outside the surface");

        robot.place(new Position(4, 0), Direction.findByName("EAST"));
        robot.turnRight();
        Assertions.assertEquals(new CommandStatus(new Position(4, 0)), robot.move(), "Robot @ [(4,0), SOUTH] should not move outside the surface");

        robot.place(new Position(4, 0), Direction.findByName("WEST"));
        robot.turnLeft();
        Assertions.assertEquals(new CommandStatus(new Position(4, 0)), robot.move(), "Robot @ [(4,0), SOUTH] should not move outside the surface");

    }

    @Test
    void move_WEST() {
        // moving WEST
        robot.place(new Position(1, 4), Direction.findByName("WEST"));
        Assertions.assertEquals(new CommandStatus(new Position(0, 4)), robot.move(), "Robot @ [(1,4), WEST] should move to (0,4)");
        Assertions.assertEquals(new CommandStatus(new Position(0, 4)), robot.move(), "Robot @ [(0,4), WEST] should not move outside the surface");

        robot.place(new Position(0, 4), Direction.findByName("NORTH"));
        robot.turnLeft();
        Assertions.assertEquals(new CommandStatus(new Position(0, 4)), robot.move(), "Robot @ [(0,4), WEST] should not move outside the surface");

        robot.place(new Position(0, 4), Direction.findByName("SOUTH"));
        robot.turnRight();
        Assertions.assertEquals(new CommandStatus(new Position(0, 4)), robot.move(), "Robot @ [(0,4), WEST] should not move outside the surface");

    }

    @Test
    void move_Invalid_Movement() {
        // Invalid movement
        robot = new SimpleRobot(null, null, null);
        Assertions.assertEquals(new CommandStatus(null), robot.move(),"Robot should be placed on a surface before moving");

        robot = new SimpleRobot(new RectTable(5,5), SimpleNavigator.getNavigator(), CartesianCoordinateCalculator.getCoordinateCalculator());
        Assertions.assertEquals(new CommandStatus(null), robot.move(),"Robot should face a valid direction before moving");

        robot = new SimpleRobot(new RectTable(5,5), SimpleNavigator.getNavigator(), CartesianCoordinateCalculator.getCoordinateCalculator());
        robot.place(new Position(1,4), Direction.findByName("UNDEFINED"));
        Assertions.assertEquals(new CommandStatus(null), robot.move(),"Robot should face a valid direction before moving");

        robot.place(new Position(1,4), null);
        Assertions.assertEquals(new CommandStatus(null), robot.move(),"Robot should face a valid direction before moving");

        robot.place(null, Direction.findByName("WEST"));
        Assertions.assertEquals(new CommandStatus(null), robot.move(),"Robot should be placed at a valid position on a surface before moving");

    }

    @Test
    void report() {
        Assertions.assertEquals(new CommandStatus("Robot @ [(3,3), NORTH]"), robot.report(),"Robot is placed at (3,3), NORTH");

        robot.place(new Position(3,4), Direction.findByName("EAST"));
        Assertions.assertEquals(new CommandStatus("Robot @ [(3,4), EAST]"), robot.report(),"Robot is placed at (3,4), EAST");

        robot.place(new Position(1,4), Direction.findByName("WEST"));
        Assertions.assertEquals(new CommandStatus("Robot @ [(1,4), WEST]"), robot.report(),"Robot is placed at (1,4), WEST");

        robot.place(new Position(3,1), Direction.findByName("SOUTH"));
        Assertions.assertEquals(new CommandStatus("Robot @ [(3,1), SOUTH]"), robot.report(),"Robot is placed at (3,1), SOUTH");

        robot = new SimpleRobot(null, SimpleNavigator.getNavigator(), CartesianCoordinateCalculator.getCoordinateCalculator());
        Assertions.assertEquals(new CommandStatus(null), robot.report(),"Robot should be placed on a surface before reporting");

        robot = new SimpleRobot(new RectTable(5,5), SimpleNavigator.getNavigator(), CartesianCoordinateCalculator.getCoordinateCalculator());
        Assertions.assertEquals(new CommandStatus(null), robot.report(),"Robot should be placed on a surface before reporting");
    }
}