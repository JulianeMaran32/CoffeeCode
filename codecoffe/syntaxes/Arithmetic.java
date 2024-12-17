package syntaxes;

public class Arithmetic {

    public static void main(String[] args) {
        int firstNumber = 5;
        int secondNumber = 2;
        System.out.println("Valores: firstNumber = " + firstNumber + ", secondNumber = " + secondNumber);
        System.out.println(" -secondNumber = " + (-secondNumber));
        System.out.println("firstNumber + secondNumber = " + (firstNumber + secondNumber));
        System.out.println("firstNumber - secondNumber = " + (firstNumber - secondNumber));
        System.out.println("firstNumber * secondNumber = " + (firstNumber * secondNumber));
        System.out.println("firstNumber / secondNumber = " + (firstNumber / secondNumber));
        System.out.println("(float) firstNumber / secondNumber = " + ((float) firstNumber / secondNumber));
        System.out.println("firstNumber % secondNumber = " + (firstNumber % secondNumber));
        System.out.println("firstNumber++ = " + (firstNumber++));
        System.out.println(" secondNumber = " + (secondNumber));
        System.out.println("Valores: firstNumber = " + firstNumber + ", secondNumber = " + secondNumber);
    }

}
