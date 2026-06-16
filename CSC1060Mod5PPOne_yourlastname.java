// Name: [Your Name]
// Date: [Date]
// Program Name: CSC1060Mod5PPOne_yourlastname.java
// Description: This program converts a user-entered integer into its decimal,
// hexadecimal, and binary forms. It also generates a random uppercase letter
// and determines if it is a vowel or a consonant.
// Inputs: An integer between 0 and 15.
// Outputs: The decimal, hexadecimal, and binary forms of the integer,
// as well as a random letter and its type.
//
import java.util.Scanner;

public class CSC1060Mod5PPOne_yourlastname {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Part 1: Number Conversion
        System.out.print("Enter an integer between 0 and 15: ");
        String userEntry = input.nextLine();
        
        // Validate input length and content to check if it's a valid number between 0-15
        boolean validNumber = true;
        int number = -1;
        
        // Check for valid single-digit numbers
        if (userEntry.length() == 1) {
            char ch = userEntry.charAt(0);
            if (ch >= '0' && ch <= '9') {
                number = ch - '0';
            } else {
                validNumber = false;
            }
        }
        // check for valid two-digit numbers (10-15)
        else if (userEntry.length() == 2) {
            if (userEntry.charAt(0) == '1' && userEntry.charAt(1) >= '0' && userEntry.charAt(1) <= '5') {
                number = Integer.parseInt(userEntry);
            } else {
                validNumber = false;
            }
        } else {
            validNumber = false;
        }
        
        // Check if the number is within the valid range
        if (!validNumber || number < 0 || number > 15) {
            System.out.println("Invalid input! Number must be between 0 and 15.");
        } else {
            System.out.println("Decimal: " + number);
            
            // Determine Hexadecimal 
            String hexadecimal;
            if (number < 10) {
                hexadecimal = String.valueOf(number);
            } else {
                switch (number) {
                    case 10: hexadecimal = "A"; break;
                    case 11: hexadecimal = "B"; break;
                    case 12: hexadecimal = "C"; break;
                    case 13: hexadecimal = "D"; break;
                    case 14: hexadecimal = "E"; break;
                    default: hexadecimal = "F"; break;
                }
            }
            System.out.println("Hexadecimal: " + hexadecimal);
            
            // Determine Binary 
            String binary = "";
            int temp = number;
            for (int i = 0; i < 4; i++) {
                binary = (temp % 2) + binary;
                temp = temp / 2;
            }
            System.out.println("Binary (4 digits): " + binary);
        }
        
        // Add a blank line for readability
        System.out.println();
        
        // Part 2: Random Letter Generation
        
        // Use Math.random() to generate a random number from 0 to 25
        int randomNumber = (int)(Math.random() * 26);
        char randomLetter = (char)('A' + randomNumber);
        System.out.println("Random Letter: " + randomLetter);
        
        // Determine if the letter is a vowel or consonant 
        if (randomLetter == 'A' || randomLetter == 'E' || randomLetter == 'I' ||
            randomLetter == 'O' || randomLetter == 'U') {
            System.out.println("Type: vowel");
        } else {
            System.out.println("Type: consonant");
        }
        
        input.close();
    }
}