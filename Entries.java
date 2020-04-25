
/**
 * 
 * 
 * This class instantiates entry objects with four private instance variables
 * all methods are getter methods
 *
 * @author Peter
 * @version 04/24/2020
 */

public class Entries{

	//declaration of private instance variables
	private String myUser, myPass, myWhereFrom;

	// char array for char. 
	// preTranslate array - all char in string would be replaced to post Translate
	private char [] preTranslate =   {'a','b','c','d','e','f','g',
										'h','i','j','k','l','m','n',
										'o','p','q','r','s','t','u',
										'v','w','x','y','z'};
	//
	private char [] postTranslate =  {'v','w','x','y','z','g','r',
										's','t','u','h','i','j','k',
										'l','m','n','f','o','p','q',
										'a','d','e','b','c'};
	private int i = 0;

	//default constructor
	public Entries(String str1, String str2, String str3){
		myUser = str1;
		myPass = str2;
		myWhereFrom = str3;
	}


	//getter method for myUser (Username)
	public String getUser(){
		return myUser;
	}

	//getter method for myPass (Password)
	public String getPass(){
		return myPass;
	}

	//getter method for myWhereFrom (WhereFrom)
	public String getWhereFrom(){
		return myWhereFrom;
	}

	//method to code the string and returns the new coded string
	public StringBuffer codeString(String str1){
		
		StringBuffer codedString = new StringBuffer(str1);

		// hot af selection thing that replaces each character of a string with char array. This does the encryption code thing.
		for (int i = 0; i<str1.length();i++){
			
			for (int k = 0; k<26; k++){
				if (str1.charAt(i) == preTranslate[k]){
					
					codedString.setCharAt(i,postTranslate[k]);

				}
			}

		} 
		return codedString;
	}

	//mutator method to decode string and returns the original coded string
	public StringBuffer decodeString(String str1){

		StringBuffer decodedString = new StringBuffer(str1);

		for (int i = 0; i<str1.length();i++){
			
			for (int k = 0; k<26; k++){
				if (str1.charAt(i) == postTranslate[k]){
					
					decodedString.setCharAt(i,preTranslate[k]);

				}
			}

		} 
		return decodedString;
	}


}
