package syntaxes;

public class If {

    public static void main(String[] args) {
        if (args.length > 0) {
            int max = Integer.parseInt(args[0]);
            for (int j = 0; j < max; j++)
                System.out.print(j + " ");
            System.out.println("\nFim da contagem!");
        }
        System.out.println("\nFim do programa!");
    }

}
