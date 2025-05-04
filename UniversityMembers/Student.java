package UniversityMembers;

public class Student extends Person {
   private int id;
    public Student(String name, int age, int id) {
        super(name, age);
        this.id = id;
    }

    public String displayInfo(){
        return super.displayInfo() + "\n Student ID :" + id;
    }
}
