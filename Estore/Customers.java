package Estore;

import java.util.List;

public class Customers extends User {
    private List<BillingInformation> billingInformation;
    private ShoppingCart shoppingCart;

    public Customers(int age, String emailAddress, Address homeAddress, String name, String password, String phone, List<BillingInformation> billingInformation, ShoppingCart shoppingCart) {
        super(age, emailAddress, homeAddress, name, password, phone);
        this.billingInformation = billingInformation;
        this.shoppingCart = shoppingCart;

    }

}
