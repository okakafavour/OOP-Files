package DataStructures;

public class Set {
    private int counter;
    private int[] array;

    public Set(int size) {
        this.counter = 0;
        this.array = new int[size];
    };


    public boolean add(int numbers) {
        for(int count = 0; count < counter; count++) {
            if(array[count] == numbers){
            return false;
            }
        }
        if(counter >= array.length) {
            throw new IllegalStateException("Array is full");
        }
        array[counter++] = numbers;
        return true;
    }

    public int size() {
       return counter;
    }


    public boolean addAll(int[] numbers) {
        if(numbers == null) {
            throw new IllegalArgumentException("array is null");
        }
        boolean modified = false;
        for(int number : numbers){
            if(add(number)) {
                modified = true;
            }
        }
        return modified;
    }

    public boolean contains(int number) {
        for (int count = 0; count < counter; count++) {
            if (array[count] == number) {
                return true;
            }
        }
        return false;
    }


    public boolean remove(int number) {
        for (int i = 0; i < counter; i++) {
            if (array[i] == number) {
                for (int j = i; j < counter - 1; j++) {
                    array[j] = array[j + 1];
                }
                counter--;
                return true;
            }
        }
            return false;
    }


    public boolean removeAll() {
        for(int count = 0; count < counter; count++) {
            remove(array[count]);
        }
        return true;
    }
}
