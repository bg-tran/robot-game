package tran.billy.robot.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CommandStatusTest {

    CommandStatus s = new CommandStatus("Foo");

    @Test
    void testEquals() {
        Assertions.assertTrue(s.equals(s));
        Assertions.assertTrue(s.equals(new CommandStatus("Foo")));
        Assertions.assertTrue((new CommandStatus(null)).equals(new CommandStatus("Ignored")));
        Assertions.assertFalse(s.equals(null));
        Assertions.assertFalse(s.equals(new Object()));

    }

    @Test
    void testHashCode() {
        Assertions.assertEquals(s.hashCode(),(new CommandStatus("Foo")).hashCode());
        Assertions.assertNotEquals(s.hashCode(),(new CommandStatus(null)).hashCode());
        Assertions.assertNotEquals(s.hashCode(),(new CommandStatus("bar")).hashCode());
    }
}