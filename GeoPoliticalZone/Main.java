package GeoPoliticalZone;
import java.util.Arrays;
import java.util.Scanner;

import static GeoPoliticalZone.GeoPoliticalZone.getGeoPoliticalZone;

public class Main {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);


       System.out.print("Enter your state: ");
       String input = scanner.nextLine();

       GeoPoliticalZone zone = getGeoPoliticalZone(input);
        boolean isNotValid = input == null;

       if(isNotValid){System.out.println("Invalid input");
       } else {System.out.print("your state is: " + zone);}







    }
}
