package HotelApp;

import java.util.Date;

public class Reservations extends Reservation{
    private Guest guest;
    private Room room;
    private Date checkInDate;
    private Date checkOutDate;
    private String status;
    private String paymentId;

    public Reservations(String reservationId,Guest guest, Room room, Date checkInDate, Date checkOutDate, String status, String paymentId) {
        super(reservationId);
        this.guest = guest;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.status = status;
        this.paymentId = paymentId;
        validation();
    }

    public void validation() {
        validateCheckInDate(checkInDate);
        validateCheckOutDate(checkOutDate);
        validateStatus(status);
        validatePaymentId(paymentId);
    }

    public boolean validateCheckInDate(Date checkInDate) {
        boolean isInvalid = checkInDate.after(checkOutDate);
        if(isInvalid) {throw new IllegalArgumentException("invalid date");}
        return true;
    }

    public boolean validateCheckOutDate(Date checkOutDate) {
        boolean isInvalid = checkOutDate.before(checkInDate);
        if(isInvalid) {throw new IllegalArgumentException("invalid date");}
        return true;
    }

    public boolean validateStatus(String status) {
        boolean isInvalid = status.trim().equals("");
        if(isInvalid) {throw new IllegalArgumentException("invalid status");}
        return true;
    }

    public boolean validatePaymentId(String paymentId) {
        boolean isInvalid = paymentId.trim().equals("");
        if(isInvalid) {throw new IllegalArgumentException("invalid paymentId");}
        return true;
    }

    public Guest getGuests() {
        return guest;
    }

    public Room getRoom() {
        return room;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public String getStatus() {
        return status;
    }

    public String getPaymentId() {
        return paymentId;
    }
}
