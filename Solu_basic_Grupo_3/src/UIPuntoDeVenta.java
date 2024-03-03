import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.HashMap;


public class UIPuntoDeVenta {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Air Camela");
        frame.setSize(600, 700);
        frame.setLayout(new GridLayout(3, 1,0,0));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLocationRelativeTo(null);
        frame.add(primerPanel());
        frame.setVisible(true);
        frame.pack();
        frame.setResizable(false);
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
        panelCentral.add(trayectos());
        return panelCentral;
    }

    private static JPanel panelIzquierdo(){
        JPanel panelIzquierdo = new JPanel();
        panelIzquierdo.setLayout(new GridLayout(3, 1, 0, 0));
        panelIzquierdo.add(modalidad());
        panelIzquierdo.add(panelFechas("Fecha de Ida"));
        panelIzquierdo.add(panelFechas("Fecha Vuelta"));
        return panelIzquierdo;
    }

    private static JPanel modalidad(){
        JPanel panelModalidad = new JPanel();

        JRadioButton ida = new JRadioButton("Solo Ida");
        JRadioButton idaVuelta = new JRadioButton("Ida/Vuelta");
        ButtonGroup grupo = new ButtonGroup();

        panelModalidad.add(ida);
        panelModalidad.add(idaVuelta);
        // dibujamos un borde alrededor del panel con el título "Modalidad" centrado
        TitledBorder centerBorder = BorderFactory.createTitledBorder("Modalidad");
        centerBorder.setTitleJustification(TitledBorder.CENTER);
        panelModalidad.setBorder(centerBorder);

        grupo.add(ida);
        grupo.add(idaVuelta);

        return panelModalidad;
    }

    private static JPanel panelFechas(String titulo){
        JPanel fechaIda = new JPanel();
        JSpinner dias = new JSpinner(new SpinnerNumberModel(1, 1, 31, 1));
        dias.setBounds(70, 130, 50, 40);

        String[] nombreMes = { "Enero", "Febrero", "Marzo",
                "Abril", "Mayo", "Junio", "Julio", "Agosto",
                "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        JSpinner meses = new JSpinner(new SpinnerListModel(nombreMes));

        meses.setPreferredSize(new Dimension(90, (int) meses.getPreferredSize().getHeight()));

        JSpinner anios = new JSpinner(new SpinnerNumberModel(2022, 2000, 2030, 1));

        fechaIda.add(new JLabel("Día"));
        fechaIda.add(dias);
        fechaIda.add(new JLabel("Mes"));
        fechaIda.add(meses);
        fechaIda.add(new JLabel("Año"));
        fechaIda.add(anios);
        meses.getValue();
        fechaIda.setBorder(BorderFactory.createTitledBorder(titulo));
        return fechaIda;
    }

    private static JPanel trayectos(){
        JPanel trayecto = new JPanel();
        trayecto.setLayout(new GridLayout(3, 1, 0, 0));
        TitledBorder centerBorder = BorderFactory.createTitledBorder("Trayecto");
        centerBorder.setTitleJustification(TitledBorder.CENTER);
        trayecto.setBorder(centerBorder);

        JPanel origen = jBoxLugares("Origen: ");
        JPanel destino = jBoxLugares("Destino: ");
        JPanel personas = Personas();


        origen.setBounds(50, 50, 90, 20);
        trayecto.add(origen);
        trayecto.add(destino);
        trayecto.add(personas);
        return trayecto;
    }

    private static JPanel Personas(){
        JPanel personas = new JPanel();
        personas.add(new JLabel("Nº personas: "));
        JSpinner numPersonas = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));
        personas.add(numPersonas);
        JButton boton = new JButton("Buscar");
        personas.add(boton);
        return personas;
    }

    private static JPanel jBoxLugares(String texto){
        JPanel datos = new JPanel();
        JComboBox <String> origen = new JComboBox<>();
        HashMap <String,String> sitios = ApoyoPuntoVenta.lugares();
        for (String sitio : sitios.keySet()) {
            origen.addItem(sitio);
        }
        datos.add(new JLabel(texto));
        datos.add(origen);
        return datos;
    }

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
