package Task;

import java.util.Arrays;
public class taskOne {
    public static void main(String[] args) {

        int[] number = {12,24,18};

        int result = 0;
        for(int count = 0; count < number.length; count++){
            for(int counter = 0; counter < 10; counter++){
                if (counter % count == 0){
                    result = counter;
                }
            }
        }
        System.out.println(result);
    }
}
