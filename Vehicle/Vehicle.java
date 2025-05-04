package Vehicle;

public class Vehicle {
    private String brand;
    private int speed;

    public Vehicle(String brand, int speed) {
        this.brand = brand;
        this.speed = speed;
        Validation();
    }

    public void Validation(){
        validateBrand();
        validateSpeed();
    }

    public void validateBrand(){
        boolean isInvalidBrand = brand.trim().isEmpty();
        if(isInvalidBrand) {throw new IllegalArgumentException("Invalid brand");}
    }

    public void validateSpeed(){
        boolean isInvalidSpeed = speed < 0;
        if(isInvalidSpeed) {throw new IllegalArgumentException("Invalid speed");}
    }

    public String getBrand() {
        return brand;
    }

    public int getSpeed() {
        return speed;
    }

    public int acceleration(int amount){
        return speed + amount;
    }

    public String displayInfo(){
        Validation();
        return "\n Brand: " + brand + " " + "\n Speed: " + speed;
    }
}
