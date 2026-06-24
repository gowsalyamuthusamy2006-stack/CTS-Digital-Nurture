public class HotelManagement {

    public int calculateBill(int days, int roomRate) {
        return days * roomRate;
    }

    public boolean isRoomAvailable(int availableRooms) {
        return availableRooms > 0;
    }
}