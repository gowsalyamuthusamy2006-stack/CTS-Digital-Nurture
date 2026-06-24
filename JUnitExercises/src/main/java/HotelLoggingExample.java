import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HotelLoggingExample {

    private static final Logger logger =
            LoggerFactory.getLogger(HotelLoggingExample.class);

    public static void main(String[] args) {

        logger.error("Room booking failed due to database error");

        logger.warn("Only 2 rooms are available");

    }
}