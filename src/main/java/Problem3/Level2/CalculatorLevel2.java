package Problem3.Level2;

import Problem3.Operands;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Lisa Ramel
 * Date: 2021-04-14
 * Time: 17:51
 * Project: ProgrammingTest
 * Copywrite: MIT
 */
public class CalculatorLevel2 {

    // Method that checks if a list contains + and/or - or * and/or /
    public Boolean checkOperands(List<String> allOperands) {

        int countSubAndAdd = 0;
        int countDivAndMulti = 0;

        for (String s : allOperands) {
            if (s.equals("+") || s.equals("-")) {
                countSubAndAdd++;
            } else {
                countDivAndMulti++;
            }
        }

        // If the list is the same length as one of the counters the method returns true
        return countSubAndAdd == allOperands.size() || countDivAndMulti == allOperands.size();
    }

    public void calculate(String input) {

        Operands o = new Operands();
        List<Double> numbers = new ArrayList<>();
        List<String> operands = new ArrayList<>();

        // Uses Regex to find the operands +-/*
        Pattern pattern = Pattern.compile("[-+/*]");
        Matcher matcher = pattern.matcher(input);
        boolean found = matcher.find();

        int counter = 0;
        double result = 0.0;

        // Checks if one of the operands are found
        if (found) {

            try {

                // Creates a charArray from the input and removes whitespaces if necessary
                char[] inputArray = input.replaceAll(" ", "").toCharArray();

                for (int i = 0; i < inputArray.length; i++) {

                    // Converts the current char to String to check the Regex pattern
                    String charToString = Character.toString(inputArray[i]);
                    Matcher symbolMatcher = pattern.matcher(charToString);

                    // Saves the last number in the input to the list numbers
                    if (i == inputArray.length - 1) {
                        String lastNumber = input.substring(i - counter);
                        numbers.add(Double.parseDouble(lastNumber));
                    }

                    // Saves the value to the left of the operand to the list numbers
                    // Saves the operand to the list operands;
                    else if (symbolMatcher.find()) {
                        String number = input.substring((i - counter), i);
                        numbers.add(Double.parseDouble(number));
                        operands.add(charToString);
                        counter = 0;
                    }
                    else {
                        counter++;
                    }
                }

                for (int i = 0; i < operands.size(); i++) {

                    // Gets the current operand and saves it in getOperand
                    String getOperand = operands.get(i);

                    // Gets the first number in the calculation
                    if (i == 0) {
                        result = numbers.get(i);
                    }

                    // Refers to the method countItTogether() in the Operator class
                    // It checks operator and counts the two numbers together
                    result = o.countItTogether(getOperand, result, numbers.get(i + 1));
                }

                // Error message is shown when division with 0 occurs
                // Error messages when a calculation is not valid
                if (result == Double.NEGATIVE_INFINITY || result == Double.POSITIVE_INFINITY) {
                    System.out.println("Cannot divide with 0. Try another calculation.");
                }
                // Error message when the metod checkOperands turns false
                else if (!checkOperands(operands)) {
                    System.out.println("Calculation is only valid with + and/or - or with / and/or *. Try again.");
                }
                // Prints the result
                else
                    System.out.println("Equals: " + result);

            } catch (NumberFormatException e) {
                System.out.println("Not a valid calculation. Try again.");
            }
        } else
            System.out.println("Not a valid calculation. Try again.");
    }


    public static void main(String[] args) {

        while (true) {

            Scanner scan = new Scanner(System.in);

            System.out.println("Enter calculation:");
            String input = scan.nextLine();
            if(input.equals("")){
                System.exit(0);
            }

            CalculatorLevel2 cLvl2 = new CalculatorLevel2();
            cLvl2.calculate(input);
            System.out.println();
        }
    }
}
