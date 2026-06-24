public class HotelService {

    private HotelDatabase database;

    public HotelService(HotelDatabase database) {
        this.database = database;
    }

    public String checkRoomStatus(int roomNumber) {
        return database.getRoomStatus(roomNumber);
    }
}