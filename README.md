# Robot game
A simple toy robot game that the robot accepts below set of commands and executes accordingly.  
    
    PLACE X,Y,F - put the toy robot on the table in position X,Y 
                  and facing NORTH, SOUTH, EAST or WEST.

    Below commands can only be accepted after a valid PLACE command:

    MOVE        - move forward 1 unit
    LEFT        - rotate counterclockwise 90 degree 
    RIGHT       - rotate clockwise 90 degree 
    REPORT      - report position and direction

## Constraints
The toy robot must not fall off the table during movement. 
This also includes the initial placement of the toy robot. 
Any move that would cause the robot to fall must be ignored.

## Approach
In this coding challenge, I am using OOP and Command pattern to implement the game.
A robot is controlled by a controller which has a set of commands. Individual robot can respond differently to the same command.

The SimpleRobot, for instance, uses a navigator and a coordinate calculator to find direction and next position.
If there is a need to change navigating logic, we can implement another navigator and/or coordinate calculator.

### Assumptions
1. It is not required to provide any graphical output showing the movement of the toy robot.
2. Robot targets a square table top of dimensions 5 units x 5 units. 
3. The origin (0,0) can be considered to be the SOUTH WEST most corner.
4. There are obstruction on the table surface.

## Project structure
- [src/main/java/tran/billy/robot](./src/main/java/tran/billy/robot) - Source code
  - [controller](./src/main/java/tran/billy/robot/controller) - code for command interface to interpret input into robot's instruction 
  - [games](./src/main/java/tran/billy/robot/games) - code for main app/game
  - [machinery](./src/main/java/tran/billy/robot/machinery) - code for Robot interface and implementation
  - [navigation](./src/main/java/tran/billy/robot/navigation) - code for navigation including data structs for direction, position and navigation rules
  - [surfaces](./src/main/java/tran/billy/robot/surfaces) - data structs for table
- [src/main/resources](./src/main/resources) - Config location
- [src/test/java](./src/test/java) - Unit Test
- [src/test/data](./src/test/data) - Test data

## Installation
You can either download pre-built binary from Github Release, or build it from source code.
```shell script
./gradlew installDist
```
The binary will be installed at <project-root>/build/install/robot-game after above command executed

## Requirements
The below components are required to compile and run projects
- [Gradle 7.x and above](https://services.gradle.org/distributions/)
- [Java JDK 1.8 and above](https://www.oracle.com/java/technologies/downloads/)

## Common Usage
- Run directly from project root in non-interactive mode:
```shell script
$./gradlew run --args="<path-to-input-file>"
```
- or interactive mode:
```shell script
$./gradlew run --console=plain
```

- Run from binary installation in non-interactive mode:
```shell script
$ "<installation-dir>"/robot-game/bin/robot-game "<path-to-input-file>"
```
- or interactive mode:
```shell script
$ "<installation-dir>"/robot-game/bin/robot-game
```

## Development
Similar to other java projects, the compilation and test are done with the help of `gradlew`. For all the Make targets
and related details, please run `gradlew help` from the project root folder.

```shell script
$ gradlew help            

Welcome to Gradle 7.1.

To run a build, run gradlew <task> ...

To see a list of available tasks, run gradlew tasks

To see a list of command-line options, run gradlew --help

To see more detail about a task, run gradlew help --task <task>

For troubleshooting, visit https://help.gradle.org

$ gradlew tasks 
> Task :tasks

------------------------------------------------------------
Tasks runnable from root project 'robot-game'
------------------------------------------------------------

Application tasks
-----------------
run - Runs this project as a JVM application

Build tasks
-----------
assemble - Assembles the outputs of this project.
build - Assembles and tests this project.
buildDependents - Assembles and tests this project and all projects that depend on it.
buildNeeded - Assembles and tests this project and all projects it depends on.
classes - Assembles main classes.
clean - Deletes the build directory.
jar - Assembles a jar archive containing the main classes.
testClasses - Assembles test classes.

Build Setup tasks
-----------------
init - Initializes a new Gradle build.
wrapper - Generates Gradle wrapper files.

Distribution tasks
------------------
assembleDist - Assembles the main distributions
distTar - Bundles the project as a distribution.
distZip - Bundles the project as a distribution.
installDist - Installs the project as a distribution as-is.

Documentation tasks
-------------------
javadoc - Generates Javadoc API documentation for the main source code.

Help tasks
----------
buildEnvironment - Displays all buildscript dependencies declared in root project 'robot-game'.
dependencies - Displays all dependencies declared in root project 'robot-game'.
dependencyInsight - Displays the insight into a specific dependency in root project 'robot-game'.
help - Displays a help message.
javaToolchains - Displays the detected java toolchains.
outgoingVariants - Displays the outgoing variants of root project 'robot-game'.
projects - Displays the sub-projects of root project 'robot-game'.
properties - Displays the properties of root project 'robot-game'.
tasks - Displays the tasks runnable from root project 'robot-game'.

Verification tasks
------------------
check - Runs all checks.
jacocoTestCoverageVerification - Verifies code coverage metrics based on specified rules for the test task.
jacocoTestReport - Generates code coverage report for the test task.
test - Runs the unit tests.

Rules
-----
Pattern: clean<TaskName>: Cleans the output files of a task.
Pattern: build<ConfigurationName>: Assembles the artifacts of a configuration.

To see all tasks and more detail, run gradlew tasks --all

To see more detail about a task, run gradlew help --task <task>

```

## Compilation
```shell script
$./gradlew clean build
```
## Testing
```shell script
$./gradlew test
```
### Unit Test reports
- [build/reports/tests/test/index.html](build/reports/tests/test/index.html)

### Test coverage reports
- [build/jacocoHtml/index.html](build/jacocoHtml/index.html)

