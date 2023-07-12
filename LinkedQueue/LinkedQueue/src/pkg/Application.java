package pkg;

// An application to simulate a waiting line in a bank using a queue data ADT
public class Application 
{
    public static void main(String[] args) 
    {
        Queue q= new Queue(); 
        
        // Adding 5 customers to the queue (waiting line) in a bank
        // The customers are represented by integers 1 to 5.
        System.out.print("\nNow 5 customers are entering the bank and heading");
        System.out.print(" to the waiting line in front of the teller to be");
        System.out.println(" served.");
        for (int i=1;i<=5;i++)
        {
            NodeData nd = new NodeData(i);
            q.enqueue(nd);
            System.out.print("Customer " + q.tail().value);
            System.out.println(" is entering the line now.");            
            delay(999888777);
        }
        
        System.out.println("\n=============================================\n");
        
        // Removing the customers from the queue
        System.out.println("The teller is now assisting the customers.");
        while(!q.isEmpty())
        {
            System.out.print("Customer " + q.head().value);
            System.out.println(" is leaving the line now.");
            q.dequeue();
            delay(999888777);
        }
        
        System.out.println();
    }// end main
    
    // This method is used to create a delay to waste time
    public static void delay (int howLong)
    {
        double x;
        for (int i = 1 ; i <= howLong ; i++)
            x =i +1;
    } // end delay



}
