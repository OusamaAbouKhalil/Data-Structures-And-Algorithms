/* 
 An array implementation of the Queue ADT with operations: create, enqueue,
 dequeue, head, tail, isEmpty, and isFull.
 The Queue is a FIFO (First In First Out) data structure.
 A cell is kept empty to differentiate between an empty queue and a full one.
 Assumption 1: head is the index of the cell that precedes the first element
 Assumption 2: tail is the index of the cell that contains the last element
*/

package queue;

public class Queue {

    private int[] queueArray;
    private int head, tail;

    // A no-arg constructor to create an empty queue of a size 100
    public Queue() {
        queueArray = new int[100];
        head = tail = 0; // initially both the head and the tail are at cell 0
    }
    
    // A constructor to create an empty queue of a specified size
    public Queue(int size) {
        queueArray = new int[size];
        head = tail = 0; // initially both the head and the tail are at cell 0
    }

    // A method to add an element at the tail of the queue
    public void enqueue(int item) {
        if (!isFull()) {
            tail = (tail + 1) % queueArray.length; //instead of just saying 
            // tail+1 in order to make the queue circular
            queueArray[tail] = item; // store the element at the tail
        } 
        else 
            System.out.println("Enqueue operation failed. The queue is full.");
    }// end enqueue

    // A method to remove and return the element at the head of the queue
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Dequeue operation failed. The queue is empty.");
            System.exit(1);
        } 
        else
            head = (head + 1) % queueArray.length; //instead of saying head + 1
        return queueArray[head]; // returns the removed element not the head one
    }// end dequeue

    // A method that returns the element at the head of the queue
    public int head() {
        if (isEmpty()) {
            System.out.println("Head operation failed. The queue is empty.");
            System.exit(1);
        }
        return queueArray[(head + 1) % queueArray.length];
    } // end head

    // A method that returns the element at the tail of the queue
    public int tail() {
        if (isEmpty()) {
            System.out.println("Tail operation failed. The queue is empty.");
            System.exit(1);
        }
        return queueArray[tail];
    }// end tail

    // A method that checks if the queue is empty
    public boolean isEmpty() {
        return tail == head;
    }

    // A method that checks if the queue is full
    public boolean isFull() {
        return (tail + 1) % queueArray.length == head; // only one empty cell
    }

} // end class queue
