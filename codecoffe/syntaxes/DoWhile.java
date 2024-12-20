package syntaxes;

import java.util.Scanner;

public class DoWhile {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Valor inteiro inferior? ");
        int min = scanner.nextInt();
        System.out.print("Valor inteiro superior? ");
        int max = scanner.nextInt();
        do {
            System.out.println(min + " < " + max);
            min++;
            max--;
        } while (min < max);
        System.out.println(min + " == " + max + " Condição Final!");
        scanner.close();
    }

}
