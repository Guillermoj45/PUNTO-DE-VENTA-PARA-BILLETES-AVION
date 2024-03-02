import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;


public class UIPuntoDeVenta {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Air Camela");
        frame.setSize(600, 700);
        frame.setLayout(new GridLayout(3, 1,0,0));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        frame.add(primerPanel());
    }
    // Parte Gráfica 1 Guillermo -- Se debe de hacer en un panel para facilitar la implementación con devolución del panel
    private static JPanel tituloPanel(){
        JPanel titulo = new JPanel();
        JLabel texto = new JLabel("PUNTOS DE VENTA DE BILLETES");
        // aplicamos Verdana, 20, Negrita Borde hundido
        texto.setFont(new Font("Verdana", Font.BOLD, 20));
        titulo.setBorder(BorderFactory.createRaisedBevelBorder());
        titulo.add(texto);
        return titulo;
    }
    private static JPanel primerPanel(){
        JPanel granPanel = new JPanel();
        // añadimos margenes
        granPanel.setBorder(new EmptyBorder(10, 40, 10, 40));

        JPanel panel1 = new JPanel();
        panel1.setBorder(BorderFactory.createLoweredBevelBorder());
        granPanel.add(panel1);

        panel1.add(tituloPanel());
        return granPanel;
    }

    // Parte Gráfica 2 Pablo -- Se debe de hacer en un panel para facilitar la implementación con devolución del panel


    // Parte Gráfica 3 Vega -- Se debe de hacer en un panel para facilitar la implementación con devolución del panel


}
