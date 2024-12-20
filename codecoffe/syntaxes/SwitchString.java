package syntaxes;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class SwitchString {

    public static void main(String[] args) {
        if (args.length > 0) {
            switch (args[0].toLowerCase()) {
                case "data":
                    System.out.println(DateFormat.getDateInstance()
                            .format(new Date())); // 20 de dez. de 2024
                    break;
                case "hora":
                    System.out.println(DateFormat.getTimeInstance()
                            .format(new Date())); // 20:07:58
                    break;
                case "nova-data":
                    System.out.println(LocalDate.now()
                            .format(DateTimeFormatter.ofPattern("dd/MMMM/yyyy"))); // 20/dezembro/2024
                    break;
                case "nova-hora":
                    System.out.println(LocalTime.now()
                            .format(DateTimeFormatter.ofPattern("hh:mm:ss"))); // 08:08:46
                    break;
                default:
                    System.out.println("Comando não reconhecido!");
            }
        } else {
            System.out.println("Não foi fornecido argumento.");
        }
    }
}