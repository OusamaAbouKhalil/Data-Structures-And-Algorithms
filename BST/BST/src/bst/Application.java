

package bst;

import java.util.*;

public class Application 
{
   public static void main(String[] args) 
    {
      
        // Declarations
        int value;
        Scanner scan;
        char option;
        BST bst1;
                
        bst1 = new BST();
        scan = new Scanner(System.in);
        
        do
        {
            System.out.println("Enter an option.");
            System.out.print("Enter i to insert, d to delete,  s to search, ");
            System.out.println("1 for inOrder traversal, 2 for preOrder traversal,");
             System.out.print("3 for postOrder traversal, ");
            System.out.print("c for the number of nodes, l for the number of leaves, ");
            System.out.println("v for the height, and x to exit:");
            option = scan.next().charAt(0);
            if(option == 'i')
            {
                System.out.print("Enter an integer value: ");
                value = scan.nextInt();
                NodeData nd = new NodeData(value);
                bst1.findOrInsert(nd);
            }
            else if(option == 'd')
            {
                System.out.print("Enter the value to delete: ");
                value = scan.nextInt();
                NodeData nd = new NodeData(value);
                bst1.delete(nd);
            }
            else if(option == 's')
            {
                System.out.print("Enter the value to search for: ");
                value = scan.nextInt();
                NodeData nd = new NodeData(value);
                if(bst1.search(nd))
                    System.out.println(value + " is in the BST.");
                else
                    System.out.println(value + " is not in the BST.");
            }
            else if(option == '1')
            {
                bst1.inOrder();
                System.out.println();
            }
            else if(option == '2')
            {
                    bst1.preOrder();
                    System.out.println();
            }
            else if(option == '3')
            {
                    bst1.postOrder();
                    System.out.println();
            }
            else if(option == 'c')
                    System.out.println("The number of nodes is: " + bst1.numNodes());
            else if(option == 'l')
                    System.out.println("The number of leaves is: " + bst1.numLeaves());
            else if(option == 'v')
                    System.out.println("The number of levels is: " + bst1.height());
            else if (option != 'x')
                 System.out.println("Invalid option.");
    
        }while (option != 'x');
        System.out.println("The end.");

    } // end main
   
} // end Application