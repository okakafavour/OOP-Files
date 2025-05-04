package UniversityMembers;


public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public boolean validation(){
        return ValidateName() && ValidateAge();
    }

    public boolean ValidateName(){
        boolean isInvalidName = name == null || name.trim().isEmpty();
        if(isInvalidName){throw new IllegalArgumentException("Invalid input");}
        return true;
    }

    public boolean ValidateAge(){
        boolean isInvalidAge = age < 0;
        if(isInvalidAge){throw new IllegalArgumentException("Invalid input");}
        return true;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String displayInfo(){
        validation();
        return "\n Name : " + name + " " + "\n Age : " + age;

    }

}
