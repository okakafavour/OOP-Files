package Vehicle;

public class MotoCycle extends Vehicle{
    private int engineCapacity;

    public MotoCycle(String brand, int speed, int engineCapacity){
        super(brand, speed);
        Validation();
        this.engineCapacity = engineCapacity;
    }

    public void Validation(){
        boolean isInvalid = engineCapacity < 0;
        if(isInvalid){throw new IllegalArgumentException("invalid engine capacity");}
    }

    public int getEngineCapacity(){
        return engineCapacity;
    }

    public String displayInfo(){
        return super.displayInfo() + "\nEngine Capacity: " + engineCapacity;
    }
}
