import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class HotelServiceTest {

    @Test
    public void testRoomStatus() {

        // Create Mock Object
        HotelDatabase mockDatabase = mock(HotelDatabase.class);

        // Stub Method
        when(mockDatabase.getRoomStatus(101))
                .thenReturn("Available");

        // Create Service Object
        HotelService service = new HotelService(mockDatabase);

        // Call Method
        String status = service.checkRoomStatus(101);

        // Verify Result
        assertEquals("Available", status);
    }

    @Test
    public void testVerifyRoomStatusRequest() {

        HotelDatabase mockDatabase = mock(HotelDatabase.class);

        HotelService service = new HotelService(mockDatabase);

        service.checkRoomStatus(101);

        verify(mockDatabase).getRoomStatus(101);
    }
}