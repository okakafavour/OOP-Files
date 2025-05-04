package HotelApp;

public class Room {
    private String roomNumber;
    private String roomType;
    private Double price;
    private boolean isAvailable;

    public Room(String name, String location,String roomNumber, String roomType, Double price, boolean isAvailable) {

        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.price = price;
        this.isAvailable = isAvailable;
        Validation();
    }

    public void Validation(){
        validateRoomNumber(roomNumber);
        validateRoomType(roomType);
        validatePrice(price);
    }

    public boolean validateRoomNumber(String roomNumber){
        boolean isInvalid = !roomNumber.matches("^[0-9]{9}$");
        if(isInvalid){throw new IllegalArgumentException("invalid room number");}
        return true;
    }

    public boolean validateRoomType(String roomType){
        boolean isInvalid = roomType.trim().isEmpty();
        if(isInvalid){throw new IllegalArgumentException("invalid room type");}
        return true;
    }

    public boolean validatePrice(Double price){
        boolean isInvalid = price < 0;
        if(isInvalid){throw new IllegalArgumentException("invalid price");}
        return true;
    }


    public String getRoomNumber() {
        return roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public Double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

}
