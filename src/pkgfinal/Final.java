/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal;

import java.util.Scanner;
/** class Final instantiates the AI class and serves as the driver for the animal name guessing game
 *
 * @author Steven Warren
 */
public class Final {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        char charChoice;
        char charEnd;
        AI gameAI = new AI();
        
        Scanner in  = new Scanner(System.in);
		
        System.out.println("Hello! I will do my best to guess your animal!");
        //check char entered allow user to re-enter args.
        do{
		System.out.println("Ok. Think of an animal. Ready? ('y' to continue)");
		charChoice = in.nextLine().toUpperCase().charAt(0);
		if (charChoice == 'Y'){
                    //ask questions
			do{
			gameAI.askQuestion();
			
			do{
			System.out.println("Would you like to play again? (y/n)");
			charEnd = in.nextLine().toUpperCase().charAt(0);
			if (charEnd != 'Y' && charEnd != 'N'){
				System.out.println("Invalid Character.");
			}}while(charEnd != 'Y' && charEnd != 'N');
			}while(charEnd != 'N');
		}
		else if(charChoice == 'N'){
			System.out.println("I'll wait.");
		}
		else{
			System.out.println("Invalid Character. Try Again.");
		}
		}while(charChoice != 'Y');
		
		in.close(); 
    }
    
}
