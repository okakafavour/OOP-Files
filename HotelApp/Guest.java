package HotelApp;

public class Guest  {
    private String guestName;
    private String guestNumber;
    private String guestEmail;
    private String guestPhoneNumber;

     public Guest(String guestName, String guestNumber, String guestEmail, String guestPhoneNumber) {
         this.guestName = guestName;
         this.guestNumber = guestNumber;
         this.guestEmail = guestEmail;
         this.guestPhoneNumber = guestPhoneNumber;
         Validation();
     }

     public void Validation(){
         validateGuestName(guestName);
         validateGuestNumber(guestNumber);
         validateGuestEmail(guestEmail);
         validateGuestPhoneNumber(guestPhoneNumber);
     }

    public boolean validateGuestName(String guestName){
         boolean isInvalid = guestName.trim().isEmpty();
         if(isInvalid){throw new IllegalArgumentException("invalid name");}
         return true;
    }

    public boolean validateGuestNumber(String guestNumber){
         boolean isInvalid = guestNumber.trim().isEmpty();
         if(isInvalid){throw new IllegalArgumentException("invalid number");}
         return true;
    }

    public boolean validateGuestEmail(String guestEmail){
         boolean isInvalid = guestEmail.trim().isEmpty();
         if(isInvalid){throw new IllegalArgumentException("invalid email");}
         return true;
    }

    public boolean validateGuestPhoneNumber(String guestPhoneNumber){
         boolean isInvalid = guestPhoneNumber.trim().isEmpty() || guestPhoneNumber.length() > 11;
         if(isInvalid){throw new IllegalArgumentException("invalid phone number");}
         return true;
    }

    public String getGuestName() {
         return guestName;
    }

    public String getGuestNumber() {
         return guestNumber;
    }

    public String getGuestEmail() {
         return guestEmail;
    }

    public String getGuestPhoneNumber() {
         return guestPhoneNumber;
    }

}
