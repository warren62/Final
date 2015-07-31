/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal;

/**Creates Node with left and right place yholders.
 *
 * @author Steven
 */
public class Node {
    
    public Node left;
    public Node right;
    public String data;
    
    public Node()
    {
        left = null;
        right = null;
    }
    
    public Node (String info)
    {
        left = null;
        right = null;
        data = info;
    }
    
}
