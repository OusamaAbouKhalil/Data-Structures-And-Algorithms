/* Class BST to implement a Binary Search Tree with operations:
   Create an empty BST, findOrInsert an element, delete an element, search for 
   an element, isEmpty, traverse the tree (inOrder, preOrder, postOrder), numNodes, 
   numLeaves, and height (i.e. numLevels.)
 */ 

package bst;

public class BST
{
    private TreeNode root;
        
    public BST()
    {
        root = null;
    }
    
    public TreeNode getRoot()
    {
        return root;
    }
    
    public boolean isEmpty()
    {
        return root == null;
    }
    
    public boolean search(NodeData item)
    {
        TreeNode current = root;
        if (isEmpty())
            System.out.print("The search operation failed. The BST is empty.");
        else
            while(current != null)
            {
                if (item.compareTo(current.data)== 0)
                    return true;
                else if (item.compareTo(current.data) < 0)
                    current = current.left;
                else
                    current = current.right;
            }
        return false;
    }
    
    public void findOrInsert(NodeData item)
    {
        TreeNode current = root, parent = null, newNode;
        boolean found = false;
        if (isEmpty())
            root = new TreeNode(item);
        else
        {
            while(current != null)
            {
                if (item.compareTo(current.data) == 0) // item is found
                {
                    System.out.println("Insert Operation failed. The element is already in the BST.");
                    found = true;
                    break;
                }
                else if (item.compareTo(current.data)<0)
                {
                    parent = current;
                    current = current.left; // go left
                }
                else // item > current.getData()
                {
                    parent = current;
                    current = current.right;  // go right
                }
                    
            } // end while
            
            if (!found) // current is null in this case
            {
                newNode = new TreeNode(item);
                if (item.compareTo(parent.data)<0)
                    parent.left = newNode; // insert to the left of parent
                else
                    parent.right = newNode; // insert to the right of parent
            }// end if
        
        }// end else
             
    }// end findOrInsert

    // inOrder Traversal --> LNR
    public void inOrder() 
    {
        inOrderTraversal(root);
    } // end inOrder
    // inOrderTraversal  --> LNR
    private void inOrderTraversal(TreeNode current) 
    {
        if (current != null)
        {
            inOrderTraversal(current.left);
            System.out.print(current.data.value + " ");
            inOrderTraversal(current.right);
        }
    } // end inOrderTraversal
    
     // preOrder Traversal --> NLR
    public void preOrder() 
    {
        preOrderTraversal(root);
    } // end preOrder
    // preOrderTraversal --> NLR
    private void preOrderTraversal(TreeNode current) 
    {
        if (current != null)
        {
            System.out.print(current.data.value + " ");
            preOrderTraversal(current.left);
            preOrderTraversal(current.right);
        }
    } // end preOrderTraversal

      // postOrder Traversal --> LRN
    public void postOrder() 
    {
        postOrderTraversal(root);
    } // end postOrder
    // postOrderTraversal --> LRN
    private void postOrderTraversal(TreeNode current) 
    {
        if (current != null)
        {
            postOrderTraversal(current.left);
            postOrderTraversal(current.right);
            System.out.print(current.data.value + " ");
        }
    } // end postOrderTraversal  
    
    public void delete(NodeData item)
    {
        TreeNode parent = null, child, temp, current = root;
	boolean found = false;
        
        if (root == null) // empty BST
        {
            System.out.println("Delete operation failed. The BST is empty.");
            return; 
        }
        // loop to check if the element is already in the tree 
	while (current != null && !found) 
	{
            if (item.compareTo(current.data) == 0) // item equals node's data
                found = true;
            else if (item.compareTo(current.data) < 0) // item < node's data
            {
                parent = current;
		current = current.left; // go left
	    }
	    else // item > than node's data
	    {
		parent = current;
		current = current.right; // go right
	    }

	} // end while

	if (!found)
            System.out.println("Delete operation failed. The element is not in the BST.");
	else // found
	{
            if (current.left != null && current.right != null) // node with two children
	    {
                temp = current; // keep a pointer to the node containing the item
		// find the successor of item
		parent = current;
		current = current.right; // go right once
		while (current.left != null) // go left all the way
		{
                    parent = current;
		    current = current.left;
		} // end while
		// current now points to the node containing the successor of item
                // exchange the data of temp and that of current
		temp.data = current.data; 
	     } // end if two children - now current has one child or no children

            // case of a node with one child (left or right) or no children

	    child = current.left; // get the left child of the node to be deleted
	    if (child == null) // if it has no left child
                child = current.right; // get its right child
            if (current == root) // deleting the root
		root = child;
	    else if (parent.left == current) // if current is a left child
		parent.left = child; // connect parent of node to the child of node
	    else 
                parent.right = child;
	} // end else found

    } // end delete
    
    // Returns the number of nodes in the BST (i.e. the moment of the tree)
    public int numNodes()
    {
        return countNodes(root);
    }
    
    // Count the number of nodes in the BST 
    private int countNodes(TreeNode current)
    {
        if (current == null)        
            return 0;
        return 1 + countNodes(current.left) + countNodes(current.right);
    }
    
     // Returns the number of leaf nodes in the BST (i.e. the weight of the tree)
    public int numLeaves()
    {
       return countLeaves(root);
    }
    
     // Count the number of leaf nodes in the BST
    private int countLeaves(TreeNode current)
    {
        if (current == null)        
            return 0;
        if (current.left == null && current.right == null)        
            return 1;
        return countLeaves(current.left) + countLeaves(current.right);
    }
    
     // Returns the height of the BST
    public int height()
    {
        return countLevels(root);
    }
      // Count the number of levels in the BST
    private int countLevels(TreeNode current)
    {
        if (current == null)        
            return 0;
        return 1 + Math.max( countLevels(current.left), 
                             countLevels(current.right) );
    }
    

} // end BST
