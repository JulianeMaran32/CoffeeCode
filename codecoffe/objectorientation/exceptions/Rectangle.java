package objectorientation.exceptions;

/**
 * Classe para representação melhorada do Retângulo
 *
 * @author Juliane Maran
 */
public class Rectangle {

    /**
     * Dimensões são campos privados
     */
    private double width; // largura
    private double height; // altura

    /**
     * Construtor 'default' aciona outro construtor com 'this'
     */
    public Rectangle() {
        this(2, 1);
    }

    /**
     * Construtor parametrizado
     */
    public Rectangle(double width, double height) {
        this.setSize(width, height);
    }

    public void setSize(double width, double height) {
        // Verifica valor das variáveis locais
        if (width >= 0 && height >= 0) { // Uso explícito do 'this'
            // Campos recebem valor das variáveis locais
            this.width = width;
            this.height = height;
        }
        // Se dimensões forem inválidas, deve lança exceção NÃO monitorada
        throw new RuntimeException("Invalid dimensions!");
    }

    /**
     * Uso implícito do 'this'
     *
     * @return retorna o valor de 'this.width'
     */
    public double getWidth() {
        return width;
    }

    /**
     * Uso implícito de 'this'
     *
     * @return retorna o valor de 'this.height'
     */
    public double getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Rectangle { " + "width = " + width + ", height = " + height + " }";
    }

}
