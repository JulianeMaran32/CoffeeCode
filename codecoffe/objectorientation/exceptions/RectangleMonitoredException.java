package objectorientation.exceptions;

/**
 * Classe para representação melhorada do Retângulo com Exceção Monitorada
 *
 * @author Juliane Maran
 */
public class RectangleMonitoredException {

    /**
     * Dimensões são campos privados
     */
    private double width; // largura
    private double height; // altura

    /**
     * Construtor 'default' aciona outro construtor com 'this'
     */
    public RectangleMonitoredException() throws Exception {
        this(2, 1);
    }

    /**
     * Construtor parametrizado
     */
    public RectangleMonitoredException(double width, double height) throws Exception {
        this.setSize(width, height);
    }

    public void setSize(double width, double height) throws Exception {
        // Verifica valor das variáveis locais
        if (width >= 0 && height >= 0) { // Uso explícito do 'this'
            // Campos recebem valor das variáveis locais
            this.width = width;
            this.height = height;
        }
        // Se dimensões forem inválidas, deve lança exceção monitorada
        throw new Exception("Invalid dimensions!");
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
