package HealthCareApp;

public class Person {
    private String name;
    private int age;
    private String Id;

    public Person(String name, int age, String Id) {
        this.name = name;
        this.age = age;
        this.Id = Id;
        Validation();
    }
    public void Validation() {
        validateName(name);
        validateAge(age);
        validateId(Id);
    }

    private boolean validateName(String name) {
        boolean isInvalid = name.trim().isEmpty();
        if(isInvalid) {throw new IllegalArgumentException("Name cannot be empty");}
        return true;
    }

    public boolean validateAge(int age) {
        boolean isInvalid = age < 0;
        if(isInvalid) {throw new IllegalArgumentException("Age cannot be negative");}
        return true;
    }

    public boolean validateId(String Id) {
        boolean isInvalid = Id.trim().isEmpty();
        if(isInvalid) {throw new IllegalArgumentException("Id cannot be empty");}
        return true;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getId() {
        return Id;
    }

    public String details(){
        Validation();
        return "Name: " + name + "\nAge: " + age + "\nID: " + Id;
    }
}
