package Problem3.Level1;

import Problem3.Operands;

import java.util.Scanner;

/**
 * Created by Lisa Ramel
 * Date: 2021-04-14
 * Time: 17:51
 * Project: ProgrammingTest
 * Copywrite: MIT
 */
public class CalculatorLevel1 {

    // Method that locates one of the symbols +-/* in the input
    public Integer operator(String input, String c, int start) {

        // Returns the index when one of the symbols are found, else it returns -1
        for (int i = start; i < input.length(); i++)
            if (c.indexOf(input.charAt(i)) >= 0)
                return i;
        return -1;
    }

    public void calculate(String input) {

        Operands o = new Operands();
        double result = 0.0;

        // Saves the index of the symbol with the method operator()
        int charPosition = operator(input, "+-*/", 1);

        // Checks if a symbol has been find
        if (charPosition == 1) {

            try {

                // Saves the first number
                String position1 = input.substring(0, charPosition);
                double number1 = Double.parseDouble(position1);

                // Saves the operator symbol
                String calcChar = input.substring(charPosition, charPosition + 1);

                // Saves the second number
                String position2 = input.substring(charPosition + 1);
                double number2 = Double.parseDouble(position2);

                // Refers to the method countItTogether() in the Operator class
                // It checks operator and counts the two numbers together
                result = o.countItTogether(calcChar, number1, number2);

                // Error message is shown when division with 0 occurs
                // Error messages when a calculation is not valid
                if (result == Double.NEGATIVE_INFINITY || result == Double.POSITIVE_INFINITY) {
                    System.out.println("Cannot divide with 0. Try another calculation.");
                // Prints the result
                } else
                    System.out.println("Equals: " + result);
            } catch (NumberFormatException e) {
                System.out.println("Not a valid calculation. Try again.");
            }
        } else {
            System.out.println("Not a valid calculation. Try again.");
        }
    }

    public static void main(String[] args) {

        while(true) {

            Scanner scan = new Scanner(System.in);

            System.out.println("Enter calculation:");
            String input = scan.nextLine();
            if(input.equals("")){
                System.exit(0);
            }

            CalculatorLevel1 cLvl1 = new CalculatorLevel1();
            cLvl1.calculate(input);
            System.out.println();
        }
    }
}
