import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HotelManagementTest {

    private HotelManagement hotel;

    @Before
    public void setUp() {
        System.out.println("Initializing Hotel Management...");
        hotel = new HotelManagement();
    }

    @After
    public void tearDown() {
        System.out.println("Closing Hotel Management...");
    }

    @Test
    public void testCalculateBill() {

        int days = 3;
        int roomRate = 2000;

        int totalBill = hotel.calculateBill(days, roomRate);

        assertEquals(6000, totalBill);
    }

    @Test
    public void testRoomAvailability() {

        int availableRooms = 5;

        boolean result = hotel.isRoomAvailable(availableRooms);

        assertTrue(result);
    }
}