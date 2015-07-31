/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal;

/**Creates a Binary tree that holds String Nodes.
 *
 * @author Steven Warren
 */
public class BinaryTree {
    
    /**
     *
     */
    public Node root;

    /**
     *
     */
    public Node current;
    
    /**Constructor sets root and current to null.
     *
     */
    public BinaryTree()
    {
        root = null;
        current = null;     
    }
    
    /**Uses private method to insert info into tree
     *
     * @param info value to be inserted in binary tree.
     * @param move values considered in order to properly place value.
     */
    public void insert(String info, String move)           
    {
        root = insertItem(root, info, move);
    }
    
    /**Prints tree using private printTree method.
     *
     */
    public void print()
    {
        printTree(root);
    }
    
    /**Checks if tree is empty
     *
     * @return if tree is empty.
     */
    public boolean isEmpty()
    {
        return (root == null);
    }
    
    /**checks if current is a leaf.
     *
     * @return if current is a leaf.
     */
    public boolean atEnd()
    {
        return (current!= null) && (current.left == null && current.right == null);            
    }
    
    /**Return current data.
     *
     * @return current data.
     */
    public String getCurrentData()
    {
        return current.data;
    }
    
    /**Moves current to right node.
     *
     */
    public void moveCurrentY()
    {
        current = current.right;        
    }
    
    /**Move current to left node.
     *
     */
    public void moveCurrentN()
    {
        current = current.left;
        
    }
    
    /**Moves current to root.
     *
     */
    public void setCurrentToRoot()
    {
        current = root;
    }
    /**Inserts item into tree.
     * 
     * @param newRoot node to be inserted.
     * @param val String to be inserted into node.
     * @param move String determines where to place
     * @return node inserted into tree.
     */
    
    private Node insertItem(Node newRoot, String val, String move)
    {
        if(newRoot == null)
        {
            newRoot = new Node(val);
            System.out.println("Root inserted");
            return newRoot;
        }
        else if(move == "Y")
        {
            System.out.println("Y inserted");
            newRoot.right = insertItem(newRoot.right, val, move);
        }
        else
        {
            System.out.println("N inserted");
            newRoot.left = insertItem(newRoot.left, val, move);
        }
        return newRoot;
    }
    /**Prints tree.
     * 
     * @param root start node.
     */
    private void printTree(Node root)
    {
        if(root != null)
            System.out.println(root.data);
	    printTree(root.left);
	    printTree(root.right);
        
    }
}
