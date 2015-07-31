/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal;

import java.util.Scanner;
import java.util.ArrayList;
/** class AI instantiates a BinaryTree and manipulates is using binary tree methods.
 *  this class creates the AI that serves as the programs voice and prompter
 *
 * @author Steven
 */
public class AI {
    
    BinaryTree gameTree;
    Scanner in = new Scanner(System.in);
    /**Constructor instantiates the Binary Tree.
     * 
     */
    
    public AI()
    {
        gameTree = new BinaryTree();
    }
    /**Asks questions until the correct answer is found.
     * 
     * 
     */
    
    public void askQuestion()
    {
        String animal;
        String question;
        char yOrN;
        
        if(gameTree.isEmpty())
        {
            giveUp();
            //System.out.println(root.data);
        }
        else if(gameTree.atEnd())
        {
            System.out.println("End");
            animal = gameTree.current.data;
	    question = "Is it " + correction(animal) + " " + animal + "?";
            
            do{
			System.out.println(question);
			yOrN = in.nextLine().toUpperCase().charAt(0);
			if (yOrN == 'Y'){
				System.out.println("I win!");
				gameTree.setCurrentToRoot();
			}
			else if (yOrN == 'N'){
				giveUp();
			}
			else{
				System.out.println("Invalid Character. Try Again.");
			}}while(yOrN != 'Y' && yOrN != 'N');
        }
        else
        {
            System.out.println("Asking");
            question =  gameTree.current.data;
            
            do{
			System.out.println(question);
			yOrN = in.nextLine().toUpperCase().charAt(0);
			if (yOrN == 'Y'){
				gameTree.moveCurrentY();
				askQuestion();
			}
			else if (yOrN == 'N'){
				if(gameTree.current.left == null){
					giveUp();
					
					
				}
				else{
					gameTree.moveCurrentN();
					askQuestion();
				}
			}
			else{
				System.out.println("Invalid Character. Try Again.");
			}
		}while(yOrN != 'Y' && yOrN != 'N');
        }
    }
    /**If AI cannot guess correct animal is will give up and ask the user 
     * to enter a question that can help is guess the animal.
     * 
     */
    public void giveUp()
    {
        String oldAnimal;
        String animal;
        String question;
        String newQuestion;
        
        System.out.println("I give up. What is it? ");
	animal = in.nextLine();
	question = "What question would tell me it is " 
					+ correction(animal) + " " + animal + "?";
	System.out.println(question);
        newQuestion = in.nextLine();
        
        if(gameTree.isEmpty())
        {
            gameTree.insert(newQuestion, "Y");
            gameTree.insert(animal, "Y");
	    gameTree.setCurrentToRoot();
        }
        else if(gameTree.current.data == gameTree.root.data)
        {
            gameTree.insert(newQuestion, "N");
            gameTree.moveCurrentN();
            gameTree.current.right = new Node(animal);
            gameTree.setCurrentToRoot();
        }
        else
        {
            if(gameTree.current.data.contains("?"))
            {
                gameTree.current.left = new Node(newQuestion);
                gameTree.current.left.right = new Node(animal);
                gameTree.setCurrentToRoot();
            }
            else
            {
                oldAnimal = gameTree.current.data;
                gameTree.current.data = newQuestion;
                gameTree.current.left = new Node(oldAnimal);
                gameTree.current.right = new Node(animal);
                gameTree.setCurrentToRoot();
            }
        }
        
    }
    /**Ensures that the sentence is correct with regards to a/an.
     * 
     * @param animal animal name;
     * @return correct word(a or an).
     */
    public String correction(String animal)
    {
        Character firstLet;
        
        ArrayList<Character> vowels = new ArrayList<Character>();
		vowels.add('A');
		vowels.add('E');
		vowels.add('I');
		vowels.add('O');
		vowels.add('U');
		
		firstLet = animal.toUpperCase().charAt(0);
		
		if (vowels.contains(firstLet)){
			return "an";
		}
		else{
			return "a";
		}
    }
    
}
