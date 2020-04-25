
/**
 *
 * Java program that can save username and passwords. The program is password protected. 
 * The resulting .txt file that is generated is encrypted.
 *
 *
 * @author Peter
 * @version 04/24/2020
 */

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class passwordVault{

	// initialize variables

	
	// Adds password
	public static void addPass() throws IOException {
		Scanner in = new Scanner(System.in);

		// user input
		System.out.print("Username/Email Address: ");
		String username = in.next();
		System.out.print("Password: ");
		String password = in.next();
		System.out.print("Account Type: ");
		String whereFrom = in.next();

		// turn entry into object
		Entries newEntry = new Entries(username, password, whereFrom);

		// append into existing file "passwordVault.txt"
		FileWriter fileWriter = new FileWriter("passwordVault.txt", true);
		PrintWriter pw = new PrintWriter(fileWriter);
		// pw.printf("%-25s%-20s%-15s",username, password, whereFrom);


		pw.printf("%-25s%-25s%-25s",newEntry.codeString(username) , newEntry.codeString(password) , newEntry.codeString(whereFrom));
		//pw.printf("%-25s%-20s%-15s",newEntry.getUser() , newEntry.getPass() , newEntry.getWhereFrom());
		pw.println();
		pw.close();

	} 
	

	// Shows current passwords
	public static void showPass() throws IOException {
		
		//initialize variables
		String token = "";
		int total = 0;
		int counter = 0;
		int index = 0;

		File fileName = new File("passwordVault.txt");
		Scanner inFile = new Scanner(fileName);
		System.out.printf("%-10s%-25s%-25s%-25s%n","Entry #" ,"Username/Email" ,"Password" , "Account Type");
		System.out.println("===========================================================================");

		while (inFile.hasNext() && counter == 0){
			
			String token1 = inFile.next();
			String token2 = inFile.next();
			String token3 = inFile.next();
			counter++;
			index++;

			while (counter == 1){
				String username = "";
				String password = "";
				String whereFrom = "";
				Entries newEntry = new Entries(username, password, whereFrom);
				
				
				StringBuffer newToken1 = newEntry.decodeString(token1);
				StringBuffer newToken2 = newEntry.decodeString(token2);
				StringBuffer newToken3 = newEntry.decodeString(token3);

				System.out.printf("%-10d%-25s%-25s%-25s%n",index, newToken1 ,newToken2, newToken3);
				counter--;
			}
			

		}
		inFile.close();
	}

	// Deletes passwords
	public static void deletePass() throws IOException{

		//initialize variables
		int counter = 0;
		int index = 1;

		File fileName = new File("passwordVault.txt");
		Scanner inFile = new Scanner(fileName);

		System.out.print("Indicate the Entry # to delete. ");
		Scanner in = new Scanner(System.in);
		int userInput = in.nextInt();


		while (inFile.hasNext() && counter == 0){
			
			counter++;
			
			// append existing file "tempPass.txt"
			FileWriter fileWriterAppend = new FileWriter("tempPass.txt", true);
			PrintWriter pw = new PrintWriter(fileWriterAppend);

			while (counter == 1){
				if (userInput == index){
					String username = "";
					String password = "";
					String whereFrom = "";
					Entries newEntry = new Entries(username, password, whereFrom);

					String tokenDel1 = inFile.next();
					String tokenDel2 = inFile.next();
					String tokenDel3 = inFile.next();

					StringBuffer newTokenDel1 = newEntry.decodeString(tokenDel1);
					StringBuffer newTokenDel2 = newEntry.decodeString(tokenDel2);
					StringBuffer newTokenDel3 = newEntry.decodeString(tokenDel3);

					System.out.printf("The entry: %s %s %s has been deleted. %n",newTokenDel1 ,newTokenDel2 ,newTokenDel3);

					index++;
					counter--;
					
				} else if (userInput != index){
					
					String token1 = inFile.next();
					String token2 = inFile.next();
					String token3 = inFile.next();

					pw.printf("%-25s%-25s%-25s",token1 ,token2 ,token3);
					pw.println();
					pw.close();

					index++;
					counter --;
					
				}

			}		
		}	
	}

	// Shows "tempPass.txt"
	public static void showTempPass() throws IOException {
		
		//initialize variables
		String token = "";
		int total = 0;
		int counter = 0;
		int index = 0;

		File fileName = new File("tempPass.txt");
		Scanner inFile = new Scanner(fileName);
		System.out.printf("%-10s%-25s%-25s%-25s%n","Entry #" ,"Username/Email" ,"Password" , "Account Type");
		System.out.println("===========================================================================");

		while (inFile.hasNext() && counter == 0){
			
			String token1 = inFile.next();
			String token2 = inFile.next();
			String token3 = inFile.next();
			counter++;
			index++;

			while (counter == 1){
				String username = "";
				String password = "";
				String whereFrom = "";
				Entries newEntry = new Entries(username, password, whereFrom);
				
				
				StringBuffer newToken1 = newEntry.decodeString(token1);
				StringBuffer newToken2 = newEntry.decodeString(token2);
				StringBuffer newToken3 = newEntry.decodeString(token3);

				System.out.printf("%-10d%-25s%-25s%-25s%n",index, newToken1 ,newToken2, newToken3);
				counter--;
			}
			

		}
		inFile.close();
	}

	// clears passwordVault.txt
	public static void clearPasswordVault() throws IOException{
		// overwrite existing file "passwordVault.txt"
		FileWriter fileWriterOverwrite = new FileWriter("passwordVault.txt", false);
	}


	// clears temPass.txt 
	public static void cleartempPass() throws IOException{
		// overwrite existing file "passwordVault.txt"
		FileWriter fileWriterOverwrite = new FileWriter("tempPass.txt", false);
	}

	// puts in values from tempPass.txt --> passwordVault.txt
	public static void tempIntoPass() throws IOException{

		//initialize variables
		int counter = 0;

		File fileName = new File("tempPass.txt");
		Scanner inFile = new Scanner(fileName);
		FileWriter fileWriter = new FileWriter("passwordVault.txt", true);
		PrintWriter pw = new PrintWriter(fileWriter);

		String token1, token2,token3;

		while (inFile.hasNext() && counter == 0){
			
			
			counter++;

			while (counter == 1){
				
				token1 = inFile.next();
				token2 = inFile.next();
				token3 = inFile.next();

				pw.printf("%-25s%-25s%-25s",token1 ,token2 ,token3);
				pw.println();

				counter--;
			}
			
		}
		pw.close();
		inFile.close();
	}

	// main method
	public static void main(String [] args) throws IOException {

		Scanner in = new Scanner(System.in);
		System.out.println("Welcome to Peter's password vault.");
		System.out.print("What is the password? ");
		String userInput = in.next();
		
		if (userInput.equals("password")){
			System.out.print("What action would you like to perform? (+ to add entry, - to delete entry, view to view entries, quit to quit program)");
			String addDeleteNeither = in.next();
			
			int counter2 = 0;

			while (addDeleteNeither.equals("+") && counter2 == 0){
				
				// add() method
				addPass();

				// asks again
				System.out.print("Would you like to add another password? (y/n) ");
				String addAnother = in.next();
				counter2 ++;
				if (addAnother.equals("y")){
					counter2 --;
				}
				showPass();
			}
			while (addDeleteNeither.equals("-") && counter2 == 0){
				
				// showPass() method
				showPass();

				// deletePass() method
				deletePass();

				clearPasswordVault();

				tempIntoPass();
				
				cleartempPass();
				
				showPass();

				// asks again
				System.out.println("Would you like to delete another password? (y/n) ");
				String deleteAnother = in.next();
				counter2 ++;
				if (deleteAnother.equals("y")){
					counter2 --;
				}


			}

			while (addDeleteNeither.equals("view") && counter2 == 0){
				showPass();
				counter2 ++;

			}

		}
		else {
			System.out.println("Get outta here!");

		}
		
	}

}




