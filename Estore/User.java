package Estore;

public class User {
    private int age;
    private String emailAddress;
    private Address homeAddress;
    private String name;
    private String password;
    private String phone;

  public User(int age, String emailAddress, Address homeAddress, String name, String password, String phone) {
      this.age = age;
      this.emailAddress = emailAddress;
      this.homeAddress = homeAddress;
      this.name = name;
      this.password = password;
      this.phone = phone;
  }

}
