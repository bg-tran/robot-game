package tran.billy.robot.navigation;

import java.util.HashMap;
import java.util.Map;

/**
 * Direction for navigating the robot around the surface
 *
 */
public enum Direction {

    NORTH("NORTH"),
    NORTH_EAST("NORTH_EAST"),
    NORTH_WEST("NORTH_WEST"),
    WEST("WEST"),
    SOUTH("SOUTH"),
    SOUTH_EAST("SOUTH_EAST"),
    SOUTH_WEST("SOUTH_WEST"),
    EAST("EAST"),
    UNDEFINED("UNDEFINED");

    private static final Map<String, Direction> CACHE_BY_NAME = new HashMap<>();

    static {
        for (Direction direction: values()) {
            CACHE_BY_NAME.put(direction.name, direction);
        }
    }

    public static Direction findByName(String name) {
        return CACHE_BY_NAME.get(name);
    }

    public final String name;

    Direction(String name) {
        this.name = name;
    }
}
