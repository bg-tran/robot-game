package tran.billy.robot.games;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

class RobotGameTest {

    private ByteArrayOutputStream byteArrayOutputStream;
    private PrintStream console;

    @BeforeEach
    public void setup() {

        console = System.out;

    }

    @Test
    void run_InteractiveMode() {

        String cmd = "PLACE 0,0,NORTH\nREPORT\nQUIT";
        runTest_Interactive(cmd);
        Assertions.assertTrue(byteArrayOutputStream.toString().contains("true"),"Robot should be placed at (0,0) facing NORTH on the 5x5 surface");
        Assertions.assertTrue(byteArrayOutputStream.toString().contains("Robot @ [(0,0), NORTH]"),"Robot should be placed at (0,0) facing NORTH");

        cmd = "PLACE 0,0,NORTH\nMOVE\nPLACE 3,3,SOUTH\nREPORT\nQUIT";
        runTest_Interactive(cmd);
        Assertions.assertTrue(byteArrayOutputStream.toString().contains("Robot @ [(3,3), SOUTH]"),"Robot should be at (3,3) facing SOUTH");

        cmd = "PLACE 0,0,SOUTH\nMOVE\nREPORT\nQUIT";
        runTest_Interactive(cmd);
        Assertions.assertTrue(byteArrayOutputStream.toString().contains("Robot @ [(0,0), SOUTH]"),"Robot should be at (0,0) facing SOUTH");

        cmd = "PLACE 0,0,EAST\nRIGHT\nMOVE\nREPORT\nQUIT";
        runTest_Interactive(cmd);
        Assertions.assertTrue(byteArrayOutputStream.toString().contains("Robot @ [(0,0), SOUTH]"),"Robot should be at (0,0) facing SOUTH");

        cmd = "PLACE 0,0,WEST\nLEFT\nMOVE\nREPORT\nQUIT";
        runTest_Interactive(cmd);
        Assertions.assertTrue(byteArrayOutputStream.toString().contains("Robot @ [(0,0), SOUTH]"),"Robot should be at (0,0) facing SOUTH");

        cmd = "PLACE 0,0,SOUTH\nRIGHT\nMOVE\nREPORT\nQUIT";
        runTest_Interactive(cmd);
        Assertions.assertTrue(byteArrayOutputStream.toString().contains("Robot @ [(0,0), WEST]"),"Robot should beat (0,0) facing WEST");

        cmd = "PLACE 0,0,WEST\nMOVE\nREPORT\nQUIT";
        runTest_Interactive(cmd);
        Assertions.assertTrue(byteArrayOutputStream.toString().contains("Robot @ [(0,0), WEST]"),"Robot should beat (0,0) facing WEST");

        cmd = "PLACE 0,0,NORTH\nLEFT\nMOVE\nREPORT\nQUIT";
        runTest_Interactive(cmd);
        Assertions.assertTrue(byteArrayOutputStream.toString().contains("Robot @ [(0,0), WEST]"),"Robot should beat (0,0) facing WEST");

        cmd = "PLACE 4,4,NORTH\nRIGHT\nMOVE\nREPORT\nQUIT";
        runTest_Interactive(cmd);
        Assertions.assertTrue(byteArrayOutputStream.toString().contains("Robot @ [(4,4), EAST]"),"Robot should be at (4,4) facing EAST");

        cmd = "PLACE 4,4,SOUTH\nLEFT\nMOVE\nREPORT\nQUIT";
        runTest_Interactive(cmd);
        Assertions.assertTrue(byteArrayOutputStream.toString().contains("Robot @ [(4,4), EAST]"),"Robot should be at (4,4) facing EAST");

        cmd = "PLACE 4,4,EAST\nMOVE\nREPORT\nQUIT";
        runTest_Interactive(cmd);
        Assertions.assertTrue(byteArrayOutputStream.toString().contains("Robot @ [(4,4), EAST]"),"Robot should be at (4,4) facing EAST");

        cmd = "PLACE 4,4,NORTH\nMOVE\nREPORT\nQUIT";
        runTest_Interactive(cmd);
        Assertions.assertTrue(byteArrayOutputStream.toString().contains("Robot @ [(4,4), NORTH]"),"Robot should be at (4,4) facing NORTH");

        cmd = "PLACE 4,4,EAST\nLEFT\nMOVE\nREPORT\nQUIT";
        runTest_Interactive(cmd);
        Assertions.assertTrue(byteArrayOutputStream.toString().contains("Robot @ [(4,4), NORTH]"),"Robot should be at (4,4) facing NORTH");

        cmd = "PLACE 4,4,WEST\nRIGHT\nMOVE\nREPORT\nQUIT";
        runTest_Interactive(cmd);
        Assertions.assertTrue(byteArrayOutputStream.toString().contains("Robot @ [(4,4), NORTH]"),"Robot should be at (4,4) facing NORTH");

        cmd = "PLACE 0,0,NORTH\nMOVE\nREPORT\nQUIT";
        runTest_Interactive(cmd);
        Assertions.assertTrue(byteArrayOutputStream.toString().contains("Robot @ [(0,1), NORTH]"),"Robot should be at (1,0) facing NORTH");

        cmd = "PLACE 0,0,NORTH\nMOVE\nRIGHT\nMOVE\nLEFT\nMOVE\nRIGHT\nMOVE\nLEFT\nMOVE\nRIGHT\nMOVE\nLEFT\nMOVE\nRIGHT\nMOVE\nREPORT\nQUIT";
        runTest_Interactive(cmd);
        Assertions.assertTrue(byteArrayOutputStream.toString().contains("Robot @ [(4,4), EAST]"),"Robot should be at (4,4) facing EAST");

        cmd = "PLACE 0,0,NORTH\nMOVE\nMOVE\nMOVE\nMOVE\nMOVE\nREPORT\nQUIT";
        runTest_Interactive(cmd);
        Assertions.assertTrue(byteArrayOutputStream.toString().contains("Robot @ [(0,4), NORTH]"),"Robot should be at (0,4) facing NORTH");

        cmd = "PLACE 0,0,EAST\nMOVE\nMOVE\nMOVE\nMOVE\nMOVE\nREPORT\nQUIT";
        runTest_Interactive(cmd);
        Assertions.assertTrue(byteArrayOutputStream.toString().contains("Robot @ [(4,0), EAST]"),"Robot should be at (4,0) facing EAST");

        cmd = "PLACE 4,0,NORTH\nMOVE\nMOVE\nMOVE\nMOVE\nMOVE\nREPORT\nQUIT";
        runTest_Interactive(cmd);
        Assertions.assertTrue(byteArrayOutputStream.toString().contains("Robot @ [(4,4), NORTH]"),"Robot should be at (4,4) facing NORTH");

        cmd = "PLACE 4,0,WEST\nMOVE\nMOVE\nMOVE\nMOVE\nMOVE\nREPORT\nQUIT";
        runTest_Interactive(cmd);
        Assertions.assertTrue(byteArrayOutputStream.toString().contains("Robot @ [(0,0), WEST]"),"Robot should be at (0,0) facing WEST");

        cmd = "PLACE 0,4,EAST\nMOVE\nMOVE\nMOVE\nMOVE\nMOVE\nREPORT\nQUIT";
        runTest_Interactive(cmd);
        Assertions.assertTrue(byteArrayOutputStream.toString().contains("Robot @ [(4,4), EAST]"),"Robot should be at (4,4) facing EAST");

        cmd = "PLACE 0,4,SOUTH\nMOVE\nMOVE\nMOVE\nMOVE\nMOVE\nREPORT\nQUIT";
        runTest_Interactive(cmd);
        Assertions.assertTrue(byteArrayOutputStream.toString().contains("Robot @ [(0,0), SOUTH]"),"Robot should be at (4,0) facing SOUTH");

        cmd = "PLACE 4,4,SOUTH\nMOVE\nMOVE\nMOVE\nMOVE\nMOVE\nREPORT\nQUIT";
        runTest_Interactive(cmd);
        Assertions.assertTrue(byteArrayOutputStream.toString().contains("Robot @ [(4,0), SOUTH]"),"Robot should be at (4,0) facing SOUTH");

        cmd = "PLACE 4,4,WEST\nMOVE\nMOVE\nMOVE\nMOVE\nMOVE\nREPORT\nQUIT";
        runTest_Interactive(cmd);
        Assertions.assertTrue(byteArrayOutputStream.toString().contains("Robot @ [(0,4), WEST]"),"Robot should be at (0,4) facing WEST");

        cmd = "\nQUIT";
        runTest_Interactive(cmd);
        Assertions.assertTrue(byteArrayOutputStream.toString().contains("Invalid command"),"Invalid command should be ignored");

        cmd = "\" \"\nQUIT";
        runTest_Interactive(cmd);
        Assertions.assertTrue(byteArrayOutputStream.toString().contains("Invalid command"),"Invalid command should be ignored");

        cmd = "FOO\nQUIT";
        runTest_Interactive(cmd);
        Assertions.assertTrue(byteArrayOutputStream.toString().contains("Invalid command"),"Invalid command should be ignored");

        cmd = "PLACE\nQUIT";
        runTest_Interactive(cmd);
        Assertions.assertTrue(byteArrayOutputStream.toString().contains("Invalid command"),"Invalid command should be ignored");

        cmd = "PLACE 0\nQUIT";
        runTest_Interactive(cmd);
        Assertions.assertTrue(byteArrayOutputStream.toString().contains("Invalid command"),"Invalid PLACE command should be ignored");

        cmd = "PLACE FOO,BAR\nQUIT";
        runTest_Interactive(cmd);
        Assertions.assertTrue(byteArrayOutputStream.toString().contains("Invalid command"),"Invalid PLACE command should be ignored");

        cmd = "PLACE FOO,0,BAR\nQUIT";
        runTest_Interactive(cmd);
        Assertions.assertTrue(byteArrayOutputStream.toString().contains("false"),"Invalid PLACE command should be ignored");

        cmd = "PLACE 0,0,FOO,BAR\nQUIT";
        runTest_Interactive(cmd);
        Assertions.assertTrue(byteArrayOutputStream.toString().contains("Invalid command"),"Invalid PLACE command should be ignored");

    }

    private void runTest_Interactive(final String data) {
        String[] args = {};
        byteArrayOutputStream = new ByteArrayOutputStream();
        final InputStream input = new ByteArrayInputStream(data.getBytes(StandardCharsets.UTF_8));
        final InputStream old = System.in;

        try {
            System.setOut(new PrintStream(byteArrayOutputStream));
            System.setIn(input);
            RobotGame.main(args);

        } finally {
            System.setOut(console);
            System.setIn(old);
        }
    }

    @Test
    void run_NonInteractiveMode() {

        String[] args = {"./src/test/data/robot_0-0-E_move_to_4-0-E.txt"};
        runTest_NonInteractive(args);
        Assertions.assertTrue(byteArrayOutputStream.toString().contains("Robot @ [(4,0), EAST]"),"Robot should be at (4,0) facing EAST");

        args = new String[]{"./src/test/data/robot_0-0-N_move_to_0-4-N.txt"};
        runTest_NonInteractive(args);
        Assertions.assertTrue(byteArrayOutputStream.toString().contains("Robot @ [(0,4), NORTH]"),"Robot should be at (0,4) facing NORTH");

        args = new String[]{"./src/test/data/robot_0-0-N_move_to_4-4-E.txt"};
        runTest_NonInteractive(args);
        Assertions.assertTrue(byteArrayOutputStream.toString().contains("Robot @ [(4,4), EAST]"),"Robot should be at (0,4) facing EAST");

        args = new String[]{"./src/test/data/robot_0-4-E_move_to_4-4-E.txt"};
        runTest_NonInteractive(args);
        Assertions.assertTrue(byteArrayOutputStream.toString().contains("Robot @ [(4,4), EAST]"),"Robot should be at (0,4) facing EAST");

        args = new String[]{"./src/test/data/robot_0-4-S_move_to_0-0-S.txt"};
        runTest_NonInteractive(args);
        Assertions.assertTrue(byteArrayOutputStream.toString().contains("Robot @ [(0,0), SOUTH]"),"Robot should be at (0,0) facing SOUTH");

        args = new String[]{"./src/test/data/robot_4-0-N_move_to_4-4-N.txt"};
        runTest_NonInteractive(args);
        Assertions.assertTrue(byteArrayOutputStream.toString().contains("Robot @ [(4,4), NORTH]"),"Robot should be at (4,4) facing NORTH");

        args = new String[]{"./src/test/data/robot_0-4-S_move_to_4-0-E.txt"};
        runTest_NonInteractive(args);
        Assertions.assertTrue(byteArrayOutputStream.toString().contains("Robot @ [(4,0), EAST]"),"Robot should be at (4,0) facing EAST");

        args = new String[]{"./src/test/data/robot_4-0-W_move_to_0-0-W.txt"};
        runTest_NonInteractive(args);
        Assertions.assertTrue(byteArrayOutputStream.toString().contains("Robot @ [(0,0), WEST]"),"Robot should be at (0,0) facing WEST");

        args = new String[]{"./src/test/data/robot_4-4-S_move_to_4-0-S.txt"};
        runTest_NonInteractive(args);
        Assertions.assertTrue(byteArrayOutputStream.toString().contains("Robot @ [(4,0), SOUTH]"),"Robot should be at (4,0) facing SOUTH");

        args = new String[]{"./src/test/data/robot_4-0-W_move_to_0-4-N.txt"};
        runTest_NonInteractive(args);
        Assertions.assertTrue(byteArrayOutputStream.toString().contains("Robot @ [(0,4), NORTH]"),"Robot should be at (0,4) facing NORTH");

        args = new String[]{"./src/test/data/robot_4-4-W_move_to_0-0-S.txt"};
        runTest_NonInteractive(args);
        Assertions.assertTrue(byteArrayOutputStream.toString().contains("Robot @ [(0,0), SOUTH]"),"Robot should be at (0,0) facing SOUTH");
        args = new String[]{"./src/test/data/robot_4-4-W_move_to_0-4-W.txt"};
        runTest_NonInteractive(args);
        Assertions.assertTrue(byteArrayOutputStream.toString().contains("Robot @ [(0,4), WEST]"),"Robot should be at (0,4) facing WEST");

        args = new String[]{"./src/test/data/robot_invalid_cmd.txt"};
        runTest_NonInteractive(args);
        Assertions.assertTrue(byteArrayOutputStream.toString().contains("Invalid command"),"Should report invalid command");
        Assertions.assertTrue(byteArrayOutputStream.toString().contains("false"),"Invalid PLACE command should report false");
        Assertions.assertTrue(byteArrayOutputStream.toString().contains("Ignored"),"Should ignore valid command if robot has not been placed");
        Assertions.assertFalse(byteArrayOutputStream.toString().contains("true"),"Invalid PLACE command should report false");
        Assertions.assertFalse(byteArrayOutputStream.toString().contains("Robot @ [("),"Robot should not report status before a valid PLACE command issued");

        args = new String[]{"foo.txt"};
        runTest_NonInteractive(args);
        Assertions.assertTrue(byteArrayOutputStream.toString().contains("Invalid input file"),"Should report invalid input file");

    }

    private void runTest_NonInteractive(final String[] args) {
        byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            System.setOut(new PrintStream(byteArrayOutputStream));
            RobotGame.main(args);

        } finally {
            System.setOut(console);
        }
    }
}