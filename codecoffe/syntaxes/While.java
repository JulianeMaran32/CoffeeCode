package syntaxes;

import java.util.Scanner;

public class While {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Valor inteiro inicial? ");
        int j = scanner.nextInt();
        while (j >= 0) {
            System.out.println(j);
            j--;
        }
        scanner.close();
    }

}
