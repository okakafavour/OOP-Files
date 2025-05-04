package Estore;

public class BillingInformation {
    private String receiverPhoneNumber;
    private String receiverName;
    private Address deliveryAddress;
    private CreditCardInformation creditCardInformation;


 public BillingInformation(String receiverPhoneNumber, String receiverName, Address deliveryAddress, CreditCardInformation creditCardInformation) {
     this.receiverPhoneNumber = receiverPhoneNumber;
     this.receiverName = receiverName;
     this.deliveryAddress = deliveryAddress;
     this.creditCardInformation = creditCardInformation;
 }
}
