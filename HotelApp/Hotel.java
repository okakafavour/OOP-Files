package HotelApp;

import java.util.HashMap;

public class Hotel {
    private String name;
    private String location;
    private HashMap<String,Room> rooms;
    private HashMap<String,Guest> guests;
    private HashMap<String, Reservation> reservations;

    public Hotel(String name, String location) {
        this.name = name;
        this.location = location;
        this.rooms = new HashMap<>();
        this.guests = new HashMap<>();
        this.reservations = new HashMap<>();
        Validation();
    }

    public void Validation(){
        validateName(name);
        validateLocation(location);
    }

    public boolean validateName(String name) {
        boolean isInvalid = name.trim().isEmpty();
        if(isInvalid){throw new IllegalArgumentException("invalid name");}
        return true;
    }

    public boolean validateLocation(String location) {
        boolean isInvalid = location.trim().isEmpty();
        if(isInvalid){throw new IllegalArgumentException("invalid location");}
        return true;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
        validateName(name);
    }

    public String getLocation(){
        return location;
    }

    public void addRoom(String roomNumber, Room newRoom) {
        if (rooms.containsKey(roomNumber)) {
            throw new IllegalArgumentException("Room with this number already exists.");
        }
        rooms.put(roomNumber, newRoom);
    }

    public String findRoom(String roomNumber) {
        if(!rooms.containsKey(roomNumber)){
            throw new IllegalArgumentException("Room with this number does not exist.");
        }
        return rooms.get(roomNumber).toString();
    }
}
