package syntaxes;

import java.util.Calendar;
import java.util.Scanner;

public class SwitchExpression {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número do mês [1-12]: ");
        int mes = scanner.nextInt();
        int nDias = switch (mes) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 4, 6, 9, 11 -> 30;
            default -> 28 + (Calendar.getInstance().get(Calendar.YEAR) % 4 == 0 ? 1 : 0);
        };
        System.out.printf("Mês #%d tem %d dias.\n", mes, nDias);

    }
}