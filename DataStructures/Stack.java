package DataStructures;

public class Stack {
    private int count;
    private int[] result;

    public Stack (int size){
        this.count = 0;
        this.result = new int[size];

    }

    public boolean empty() {
        return true;
    }

    public int push(int number) {
        if(count < result.length){
            result[count] = number;
            count++;
         return count;
        }
        throw new IndexOutOfBoundsException("DataStructures.Stack overflow");
    }


    public int pop() {
        if(count == 0){
            throw new IndexOutOfBoundsException("DataStructures.Stack underflow");
        }
        return result[--count];
    }

    public int size() {
        if(count == 0){
            throw new IndexOutOfBoundsException("DataStructures.Stack underflow");
        }
        return count;
    }

    public int peek() {
     if(count == 0){
         throw new IndexOutOfBoundsException("DataStructures.Stack underflow");
     }
     return result[count -1];
    }


    public int search(int number) {
        for(int i = count -1; i >= 0; i--){
           if(result[i] == number){
               return count -i;
           }
        }
       return -1;
    }
}
