package Algorithm;

import java.util.Arrays;

class StackByArray{
    int size;
    int arr[];
    int top;

    StackByArray
            (int size) {

        this.size = size;
        this.arr = new int[size];
        this.top = -1;
    }

    public void push(int pushedElement) {
        if (!isFull()) {
            top++;
            arr[top] = pushedElement;
            System.out.println("Pushed element:" + pushedElement);
        } else {
            System.out.println("Stack is full !");
        }
    }

    public int pop() {
        if (!isEmpty()) {
            int returnedTop = top;
            top--;
            System.out.println("Popped element :" + arr[returnedTop]);
            return arr[returnedTop];

        } else {
            System.out.println("Stack is empty !");
            return -1;
        }
    }

    public int peek() {
        return arr[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (size - 1 == top);
    }

}
class Queue{
    private int capacity;
    int size;
    int []data;
    int front;
    int rear;
    Queue(int size){
        this.size=size;
        this.data = new int[size];
        front =0;
        rear =-1;
    }

    public void enqueue(int item) {
        if (isQueueFull()) {
            System.out.println("Overflow ! Unable to add element: "+item);
        } else {
            rear++;
            if(rear == capacity-1){
                rear = 0;
            }
            data[rear] = item;
            size++;
            System.out.println("Element " + item+ " is pushed to Queue !");
        }
    }
    public void dequeue() {
        if (isQueueEmpty()) {
            System.out.println("Underflow ! Unable to remove element from Queue");
        } else {
            front++;
            if(front == capacity-1){
                System.out.println("Pop operation done ! removed: "+data[front-1]);
                front = 0;
            } else {
                System.out.println("Pop operation done ! removed: "+data[front-1]);
            }
            size--;
        }
    }
    public boolean isQueueEmpty(){
        boolean status = false;
        if (size == 0){
            status = true;
        }
        return status;
    }
    public boolean isQueueFull(){
        boolean status = false;
        if (size == capacity){
            status = true;
        }
        return status;
    }


}


public class StackAppQueueApp {
    public static void main(String[] args){
        StackByArray stackByArray = new StackByArray(7);
        stackByArray.push(23);
        stackByArray.push(24);
        stackByArray.push(25);
        //stackByArray.print();
        System.out.print(" "+stackByArray.pop());
        System.out.print(" "+stackByArray.pop());
        System.out.println("\n");
        //stackByArray.print();




        Queue queue = new Queue(10);
        queue.enqueue(23);
        queue.enqueue(19);
        queue.enqueue(2);
        queue.dequeue();

    }
}