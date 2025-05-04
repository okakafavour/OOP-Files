package DataStructures;

public class ArrayList {
    private int[] array;
    private int count;

    public ArrayList(int size) {
        this.array = new int[size];
        this.count = 0;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void add(int item) {
        if(count == array.length - 1){
            int[] newArray = new int[array.length * count];
            for(int count = 0;count < array.length;count++){
                newArray[count] = array[count];
            }
            array = newArray;
            array[count] =  item;
            item++;
        }
        if(count >= array.length) {
        }else array[count] = item;
        count++;
    }

    public int size(){
        return count;
    }

    public void exception2(){throw new IllegalArgumentException("Arraylist is empty");}

    public boolean remove(int item) {
        for (int checker = 0; checker < count; checker++) {
            if (array[checker] == item) {
                for (int checker2 = checker; checker2 < count - 1; checker2++) {
                    array[checker2] = array[checker2 + 1];
                }
                --count;
                return true;
            }
        }
        return false;
    }
    public int get(int index) {
        if (index < 0 || index >= count) {
            exception2();
        }
        return array[index];
    }
}