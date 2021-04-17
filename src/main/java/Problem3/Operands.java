package Problem3;

/**
 * Created by Lisa Ramel
 * Date: 2021-04-15
 * Time: 15:30
 * Project: ProgrammingTest
 * Copywrite: MIT
 */
public class Operands {

    public double countItTogether(String operand, double number1, double number2){

        double result = 0.0;
        boolean found = true;

        switch (operand) {
            case "+":
                result = number1 + number2;
                break;
            case "-":
                result = number1 - number2;
                break;
            case "*":
                result = number1 * number2;
                break;
            case "/":
               // if (number2 != 0) {
                    result = number1 / number2;
                    break;
            /*   }  else {
                    result = Double.NaN;
                }        */
        }

        return result;
    }
}
