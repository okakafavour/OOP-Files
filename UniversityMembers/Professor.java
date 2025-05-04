package UniversityMembers;

public class Professor extends Person{
    private String department;

    public Professor(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }

    public String displayInfo(){
        return super.displayInfo() + "\nDepartment: " + department;
    }
}
