package UniversityMembers;

import java.util.Scanner;
public class Main {

    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        displayMenu();
    }

    public static void displayMenu() {
        while(true){

       System.out.println("\n1. Login has a Student");
       System.out.println("2. Login has a Teacher");

       System.out.println("Enter your choice: ");
       int choice = input.nextInt();
       input.nextLine();


       if(choice == 1){StudentLogin();}
       else if(choice == 2){TeachersLogin();}
       else{System.out.println("Invalid choice");}

        }
    }


    public static void StudentLogin() {
       String StudentName = name();
       int StudentAge = age();
       int StudentId = id();
      Student student = new Student(StudentName, StudentAge, StudentId);
      String info = student.displayInfo();
      System.out.println("\n------Student------");
      System.out.println(info);
    }


    public static void TeachersLogin() {
       String ProfName = name();
       int profAge = age();
       String ProfDepartment = department();

     Professor professor = new Professor(ProfName, profAge, ProfDepartment);
     String info = professor.displayInfo();
     System.out.println("\n------Professor-------");
     System.out.println(info);
    }


       public static String name(){
        String name = " ";
        try {
            System.out.print("Enter Name: ");
             name = input.nextLine();
        } catch(Exception e){System.out.println(e.getMessage());}
           ValidateName(name);
           return name;
       }

       public static int age(){
        int age = 0;
        try {
            System.out.print("Enter Age: ");
             age = input.nextInt();
            input.nextLine();
        } catch (Exception e) {System.out.println(e.getMessage());}
           ValidateAge(age);
           return age;
       }

       public static int id(){
         int id = 0;
        try {
            System.out.print("Enter ID: ");
            id = input.nextInt();
        } catch (Exception e) {System.out.println(e.getMessage());}
           ValidateId(id);
           return id;
       }

       public static String department(){
           System.out.print("Enter Department: ");
           String department = input.nextLine();
           VailidateDepartment(department);
           return department;
       }


       public static boolean ValidateName(String name){
           boolean isInValidName = name == null || name.isEmpty();
           if(isInValidName){throw new IllegalArgumentException("Invalid name");}
           return true;
       }

       public static boolean ValidateAge(int age){
           boolean isInValidAge = age < 0;
           if(isInValidAge){throw new IllegalArgumentException("Invalid age");}
           return true;
       }

       public static boolean VailidateDepartment(String department){
           boolean isInValidDepartment = department == null || department.isEmpty();
           if(isInValidDepartment){throw new IllegalArgumentException("Invalid department");}
           return true;
       }

       public static boolean ValidateId(int id){
           boolean isInValidId = id < 0;
           if(isInValidId){throw new IllegalArgumentException("Invalid id");}
           return true;
       }

}
