package tran.billy.robot.controller;

import tran.billy.robot.machinery.Robot;
import tran.billy.robot.navigation.Direction;
import tran.billy.robot.navigation.Position;

/**
 * A command interface to control the robot using Command design pattern
 */
@FunctionalInterface
public interface RobotController {

    RobotController VOID_COMMAND = (robot) -> new CommandStatus("Invalid command");

    CommandStatus executeCommand(Robot robot);

    static RobotController getCommand(String cmd) {
        if(cmd.isEmpty()) {
            return VOID_COMMAND;
        }
        String[] cmdTokens = cmd.toUpperCase().split(" ");

        switch(cmdTokens[0]) {
            case "PLACE":
                if (cmdTokens.length == 1){
                    return VOID_COMMAND;
                }
                String[] paramTokens = cmdTokens[1].split(",");
                if (paramTokens.length != 3){
                    return VOID_COMMAND;
                }
                final Position position = Position.getPosition(paramTokens[0],paramTokens[1]);
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
