package tran.billy.games.robot.command;

import tran.billy.games.robot.character.Robot;
import tran.billy.games.robot.navigation.Direction;
import tran.billy.games.robot.navigation.Position;

/**
 * A command interface to control the robot using Command design pattern
 */
@FunctionalInterface
public interface Command {

    Command VOID_COMMAND = (robot) -> {};

    void executeCommand(Robot robot);

    static Command parse(String cmd) {
        if(cmd == null || cmd.trim().equals("")) {
            return VOID_COMMAND;
        }
        String[] cmdTokens = cmd.toUpperCase().split(" ");

        switch(cmdTokens[0]) {
            case "PLACE":
                if (cmdTokens.length == 1){
                    return VOID_COMMAND;
                }
                String[] paramTokens = cmdTokens[1].split(",");
                final Position position = new Position(Integer.parseInt(paramTokens[0]),Integer.parseInt(paramTokens[0]));
                final Direction direction = Direction.findByName(paramTokens[2]);
                return robot ->  robot.place(position,direction);
            case "MOVE":
                return Robot::move;
            case "LEFT":
                return Robot::turnLeft;
            case "RIGHT":
                return Robot::turnRight;
            case "REPORT":
                return Robot::report;
            default:
                return VOID_COMMAND;
        }

    }

}
