package Vehicle;

import java.util.Scanner;

public class MainApp {
    private static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        displayMenu();
    }

    public static void displayMenu(){
        System.out.print("""
                 \nWhat would you like to enter?\s
                1. Car
                2. Motocycle
               \s""");
        int choice = input.nextInt();
        switch(choice){
            case 1 -> {Car();break;}
            case 2 -> {Motocycle(); break;}

        }
    }

    private static void Motocycle() {
        String MotocycleBrand = brand();
        int Speed = speed();
        int Accelerate = accelerate();
        displayInformationForMotoCycle(MotocycleBrand,Speed,Accelerate);

    }

    public static void displayInformationForMotoCycle(String MotocycleBrand, int Speed, int accelerate){
        MotoCycle motoCycle = new MotoCycle(MotocycleBrand, Speed, accelerate);
        String info = motoCycle.displayInfo();
        System.out.println(info);
    }

    public static void Car(){
        String carBrand = brand();
        int Speed = speed();
        int numOfDoor = numberOfDoor();
        displayInformation(carBrand,Speed,numOfDoor);
    }

    private static int numberOfDoor() {
         int numOfDoors = 0;
        try{
            System.out.print("Enter number of doors: ");
             numOfDoors = input.nextInt();
            input.nextLine();
        } catch(Exception e){System.out.println(e.getMessage());}
        return numOfDoors;
    }

    private static int accelerate() {
        int accelerate = 0;
        try{
            System.out.print("How much do you want to accelerate: ");
            accelerate = input.nextInt();
            input.nextLine();
        } catch(Exception e){System.out.println(e.getMessage());}
        ValidateAccleration(accelerate);
        return accelerate;
    }

    private static boolean ValidateAccleration(int accelerate) {
        boolean isInvalid = accelerate < 0;
        if(isInvalid){throw new IllegalArgumentException("Invalid accelerate");}
        return true;
    }


    public static void displayInformation(String carBrand, int Speed, int accelerate){
        Car car = new Car(carBrand, Speed, accelerate);
        String info = car.displayInfo();
        System.out.println(info);
    }

    public static String brand(){
        String brand = " ";
        try{
            System.out.print("What is the brand: ");
            brand = input.next();
            input.nextLine();
        } catch(Exception e){System.out.println(e.getMessage());}
        ValidateBrand(brand);
        return brand;
    }

    public static int speed(){
        int speed = 0;
        try {
         System.out.print("What is the initial speed: ");
         speed = input.nextInt();
         input.nextLine();
        } catch(Exception e){System.out.println(e.getMessage());}
         validateSpeed(speed);
        return speed;
    }

    private static boolean validateSpeed(int speed) {
        boolean isInvalid = speed < 0;
        if(isInvalid){throw new IllegalArgumentException("invalid spped");}
        return true;
    }

    private static boolean ValidateBrand(String brand) {
        boolean isInvalid = brand.trim().isEmpty();
        if(isInvalid){throw new IllegalArgumentException("invalid brand");}
        return true;
    }

}
