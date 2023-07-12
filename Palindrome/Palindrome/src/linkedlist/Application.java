package linkedlist;

import java.util.*;

public class Application 
{
public static void main(String[]args)
   {
      Scanner scan = new Scanner(System.in);
      String s;
      LinkedList list1 = new LinkedList();
   
      System.out.print("Enter a string: ");
      s = scan.next();
   
     //Change the type of data in class NodeData from int to char
      for(int i=0;i<s.length();i++)
         list1.addTail(new NodeData(s.charAt(i)));  
      if(isPalindrome(list1))
         System.out.println(s + " is a palindrome");
      else
         System.out.println(s + " is not a palindrome");
     }

     public static boolean isPalindrome(LinkedList list1)
     {
        LinkedList list2 = list1.reverse();
        return (list1.equals(list2));
     } 
}
