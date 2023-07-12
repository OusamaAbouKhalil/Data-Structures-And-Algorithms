// The Queue ADT implemented using a Linked List

package pkg;

public class Queue 
{
    private Node head, tail;
    
    //create an empty queue
    public Queue()
    {
        head = tail = null;
    }
    
    // check if the queue is empty
    public boolean isEmpty ()
    {
        return(head == null);   // or return (tail == null)
    }
    
    // Adds an element at the tail
    public void enqueue(NodeData item)   
    {
        Node newNode = new Node(item);
        if (isEmpty())
        {
            head = newNode;
            tail = newNode;
        }
        else
        {
            tail.next = newNode;
            tail = newNode;
        }
    } // end enqueue
    
    // Removes and returns the element at the head
    public NodeData dequeue()  
    {  
        if(isEmpty())
        {
            System.out.println("The queue is empty. Dequeue operation failed.");
            System.exit(1);
        }
        NodeData nd = head.data;
        head = head.next;
        if (head == null) // if the queue becomes empty
            tail = null;
        return nd;
    }  // end dequeue
    
     // Returns the element at the head without removing it
    public NodeData head() 
    {  
        if(isEmpty())
        {
            System.out.println("The queue is empty. Head operation failed.");
            System.exit(1);
        }
        return head.data;
    }  // end head
    
      // Returns the element at the tail without removing it
    public NodeData tail() 
    {  
        if(isEmpty())
        {
            System.out.println("The queue is empty. Tail operation failed.");
            System.exit(1);
        }
        return tail.data;
    }  // end tail



}
