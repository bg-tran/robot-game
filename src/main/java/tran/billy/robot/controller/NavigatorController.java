package tran.billy.robot.controller;


import tran.billy.robot.navigation.Direction;
import tran.billy.robot.navigation.Navigator;


/**
 * A command interface of a navigator following Command design pattern
 */

@FunctionalInterface
public interface NavigatorController {

    Direction use(Navigator navigator);

    static NavigatorController navigateLeft(Direction direction){
        return (navigator) -> navigator.rotateLeft(direction);
    }

    static NavigatorController navigateRight(Direction direction){
        return (navigator) -> navigator.rotateRight(direction);
    }
}
