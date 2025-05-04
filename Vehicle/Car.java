package Vehicle;

public class Car extends Vehicle {
    private int numberOfDoors;

    public Car(String brand, int speed, int numberOfDoors){
        super(brand, speed);
        this.numberOfDoors = numberOfDoors;
    }

    public int numberOfDoors(){
        return numberOfDoors;
    }

    public String displayInfo(){
        return super.displayInfo() + "\nNumber of doors: " + " " + numberOfDoors;
    }

}
