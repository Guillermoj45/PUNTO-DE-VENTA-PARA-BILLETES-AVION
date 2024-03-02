import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;


public class UIPuntoDeVenta {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Air Camela");
        frame.setSize(600, 700);
        frame.setLayout(new GridLayout(3, 1,0,0));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        frame.add(primerPanel());
        frame.setVisible(true);
        // frame.pack();
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

    private static JPanel panelCentral(){
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new GridLayout(1, 2, 0, 0));
        panelCentral.add(panelIzquierdo());
        return panelCentral;
    }

    private static JPanel panelIzquierdo(){
        JPanel panelIzquierdo = new JPanel();
        panelIzquierdo.add(modalidad());
        return panelIzquierdo;
    }

    private static JPanel modalidad(){
        JPanel panelModalidad = new JPanel();
        panelModalidad.setLayout(new GridLayout(0, 2, 0, 0));

        JRadioButton ida = new JRadioButton("Solo Ida");
        JRadioButton idaVuelta = new JRadioButton("Ida/Vuelta");
        ButtonGroup grupo = new ButtonGroup();

        panelModalidad.add(ida);
        panelModalidad.add(idaVuelta);
        // dibujamos un borde alrededor del panel con el titulo "Modalidad" centrado
        TitledBorder centerBorder = BorderFactory.createTitledBorder("Modalidad");
        centerBorder.setTitleJustification(TitledBorder.CENTER);
        panelModalidad.setBorder(centerBorder);

        grupo.add(ida);
        grupo.add(idaVuelta);

        return panelModalidad;
    }

//    private static JPanel panelDerecho(){
//        JPanel FechaIda = new JPanel();
//
//       return panelDerecho;
//    }
    private static JPanel primerPanel(){
        JPanel granPanel = new JPanel();

        granPanel.setBorder(new EmptyBorder(10, 0, 10, 0));

        JPanel granPanelBorde = new JPanel();
        granPanelBorde.setBorder(BorderFactory.createLoweredBevelBorder());
        granPanel.add(granPanelBorde);

        granPanelBorde.setLayout(new BorderLayout(5,5));
        granPanelBorde.add(tituloPanel(), BorderLayout.NORTH);
        granPanelBorde.add(panelCentral(), BorderLayout.CENTER);
        return granPanel;
    }

    // Parte Gráfica 2 Pablo -- Se debe de hacer en un panel para facilitar la implementación con devolución del panel


    // Parte Gráfica 3 Vega -- Se debe de hacer en un panel para facilitar la implementación con devolución del panel


}
