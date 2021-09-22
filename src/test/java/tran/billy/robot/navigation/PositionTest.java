package tran.billy.robot.navigation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PositionTest {

    Position p = new Position(10,7);

    @Test
    void testToString() {

        Assertions.assertEquals("(10,7)", p.toString());
    }

    @Test
    void testEquals() {

        Assertions.assertTrue(p.equals(p));
        Assertions.assertTrue(p.equals(new Position(10,7)));
        Assertions.assertFalse(p.equals(null));
        Assertions.assertFalse(p.equals(new Object()));
        Assertions.assertFalse(p.equals(new Position(5,5)));
        Assertions.assertFalse(p.equals(new Position(10,5)));
        Assertions.assertFalse(p.equals(new Position(5,7)));
    }

    @Test
    void testHashCode() {
        Assertions.assertEquals(p.hashCode(),(new Position(10,7)).hashCode());
        Assertions.assertNotEquals(p.hashCode(),(new Position(10,5)).hashCode());
        Assertions.assertNotEquals(p.hashCode(),(new Position(1,7)).hashCode());
        Assertions.assertNotEquals(p.hashCode(),(new Position(5,5)).hashCode());
    }
}