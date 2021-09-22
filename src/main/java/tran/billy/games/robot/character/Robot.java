package tran.billy.games.robot.character;

import tran.billy.games.robot.navigation.Direction;
import tran.billy.games.robot.navigation.Position;

public interface Robot {
    boolean place(Position position, Direction direction);
    Direction turnLeft();
    Direction turnRight();
    Position move();
    String report();
}
