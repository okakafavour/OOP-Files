package HotelApp;

public abstract class Reservation {
    String reservationId;

    public Reservation(String reservationId) {
        this.reservationId = reservationId;
    }

    public String getReservationId() {
        return reservationId;
    }
}
