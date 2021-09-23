package tran.billy.robot.games;

import tran.billy.robot.controller.RobotController;
import tran.billy.robot.machinery.Robot;
import tran.billy.robot.machinery.SimpleRobot;
import tran.billy.robot.navigation.CartesianCoordinateCalculator;
import tran.billy.robot.navigation.SimpleNavigator;
import tran.billy.robot.surfaces.RectTable;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;

public class RobotGame {

    static final String QUIT_CMD = "quit";

    private final String[] args;
    private Robot robot;

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
        System.out.println("** Commands are case-insensitive");
        System.out.println("\nType a command to control the robot or 'quit' to exit");
    }

    private boolean isNonInteractiveMode(String[] args){
        return args.length > 0;
    }

    private void interactiveMode(){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!QUIT_CMD.equalsIgnoreCase(input)) {
            System.out.println(RobotController.getCommand(input).executeCommand(robot));

            input = scanner.nextLine();
        }
        System.out.println("Exiting ...");
        scanner.close();
    }

    private void nonInteractiveMode() throws FileNotFoundException {

        Scanner scanner = new Scanner(new File(args[0]));
        String inputCmd;
        while (scanner.hasNextLine()) {
            inputCmd = scanner.nextLine();
            System.out.println(inputCmd);
            System.out.println(RobotController.getCommand(inputCmd).executeCommand(robot));
        }

        scanner.close();
    }

    private void initialiseGame(){
        robot = new SimpleRobot(new RectTable(5,5),
                SimpleNavigator.getNavigator(),
                CartesianCoordinateCalculator.getCoordinateCalculator());
    }

    public void run(){

        initialiseGame();

        if (isNonInteractiveMode(this.args)){
            try {
                nonInteractiveMode();
            } catch (FileNotFoundException e) {
                System.out.println("Invalid input file");
            }
        }
        else {
            printHelp();
            interactiveMode();

        }

    }

    public static void main(String[] args) {

        RobotGame game = new RobotGame(args);

        game.run();
    }
}
