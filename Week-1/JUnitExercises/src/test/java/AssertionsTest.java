import org.junit.Test;

import static org.junit.Assert.*;

public class AssertionsTest {

    @Test
    public void testAssertions() {

        // Assert Equals
        assertEquals(5000, 5 * 1000);

        // Assert True
        assertTrue(10 > 5);

        // Assert False
        assertFalse(5 > 10);

        // Assert Null
        assertNull(null);

        // Assert Not Null
        assertNotNull(new Object());
    }
}