package syntaxes;

public class TestArg {

    public static void main(String[] args) {
        if (args.length > 0) { // Testa presença de argumentos
            int j = Integer.parseInt(args[0]);
            while (j >= 0) {
                System.out.println(j);
                j--;
            }
        } else { // Sinaliza problema
            System.out.println("Falta um argumento inteiro.");
        }
    }

}
