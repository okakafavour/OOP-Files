package Estore;

public class CreditCardInformation {
    private String cardCvv;
    private int cardExpirationyear;
    private int cardExpirationMonth;
    private String creditCardNumber;
    private String nameOnCard;
    private CardType cardType;

 public CreditCardInformation(String cardCvv, int cardExpirationyear, int cardExpirationMonth, String creditCardNumber, String nameOnCard) {
     this.cardCvv = cardCvv;
     this.cardExpirationyear = cardExpirationyear;
     this.cardExpirationMonth = cardExpirationMonth;
     this.creditCardNumber = creditCardNumber;
     this.nameOnCard = nameOnCard;
     this.cardType = cardType;
 }

}
