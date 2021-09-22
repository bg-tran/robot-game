package tran.billy.robot.games;

public class RobotGame {


    private final String[] args;

    public RobotGame(String[] args) {

        this.args = args;
    }

    private void printHelp(){
        System.out.println("Welcome the robot game's interactive mode");
        System.out.println("A robot has been initialized and ready to placed onto a 5x5 unit table");
        System.out.println("\nYou must start the game with PLACE X,Y,F command to place the robot on the table at (0<= X < 5 , 0<= Y < 5) position");
        System.out.println("facing direction F (F could be NORTH, EAST, SOUTH or WEST)");
        System.out.println("PLACE command could be issued any time to reset the robot to specific position and direction");
        System.out.println("\nSubsequent commands could be issued only if the robot is placed successfully or they will be ignored:");
        System.out.println("MOVE - to move forward 1 unit while facing the same direction");
        System.out.println("LEFT - to rotate the robot 90 degrees counterclockwise while staying at same position");
        System.out.println("RIGHT - to rotate the robot 90 degrees clockwise while staying at same position");
        System.out.println("REPORT - to report current position and  direction");

        System.out.println("\nYou can also play the game in non-interactive mode: ");
        System.out.println("sh robot-game --command-file <command file>");
        System.out.println("\nPress enter to continue or 'quit' to exit");
    }

    private boolean isNonInteractiveMode(String[] args){
        return args != null && args.length > 0;
    }

    private void interactiveMode(){
        System.out.println("Interactive mode");
    }

    private void nonInteractiveMode(){
        System.out.println("Non-interactive mode");
    }

    public void run(){

        if (!isNonInteractiveMode(this.args)){
            printHelp();
            interactiveMode();
        }
        else {
            nonInteractiveMode();
        }

    }

    public static void main(String[] args) {

        RobotGame game = new RobotGame(args);

        game.run();
    }
}
