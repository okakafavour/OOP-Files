package DataStructures;

public class Queue {
    private int size;
    private int front;
    private int view;
    private int[] array;
    private int count;

    public Queue(int size){
        this.size = size;
        this.front = 0;
        this.view = 0;
        this.count = 0;
        this.array = new int[size];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return count;
    }


    public void enqueue(int number) {
        if(size == count) {
        int[] newArray = new int[size * 2];
        for (int count = 0; count < size; count++) {
            newArray[count] = array[count];
        }
            array = newArray;
            view = count;
            size = size * 2;
        }
        array[view] = number;
        view = (view + 1) % size;
        count++;
    }


    public int denqueue() {
        if(isEmpty()){
            throw new IllegalStateException("DataStructures.Queue is empty");
        }
        int number = array[front];
        front = (front + 1) % size;
        count--;
        return number;

    }

    public int peek() {
        if(isEmpty()){throw new IllegalStateException("DataStructures.Queue is empty");}
        return array[front];
    }

    public void clear() {
        if(isEmpty()){
            throw new IllegalStateException("DataStructures.Queue is empty");
        }
        for(int count = front; count < size; count++){
            array[count] = 0;
        }
        front = 0;
        view = 0;
        count = 0;
    }
}
