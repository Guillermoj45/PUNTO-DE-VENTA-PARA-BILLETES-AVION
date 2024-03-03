import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.HashMap;
import java.util.Locale;


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
   // TODO: sacar el mensaje mostrando toda la información
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

        panelIzquierdo.setLayout (new GridLayout(3, 1, 0, 0));
        panelIzquierdo.add(modalidad());
        panelIzquierdo.add(panelFechas("Fecha de Ida"));
        panelIzquierdo.add(panelFechas("Fecha Vuelta"));

        // hacemos que sea el mismo valor en ida y vuelta
        JPanel fecha = (JPanel) panelIzquierdo.getComponent(1);
        JSpinner dias = (JSpinner) fecha.getComponent(1);
        JSpinner mes = (JSpinner) fecha.getComponent(3);
        JSpinner anio = (JSpinner) fecha.getComponent(5);

        JSpinner diaVuelta = (JSpinner) ((JPanel) panelIzquierdo.getComponent(2)).getComponent(1);
        JSpinner mesVuelta = (JSpinner) ((JPanel) panelIzquierdo.getComponent(2)).getComponent(3);
        JSpinner anioVuelta = (JSpinner) ((JPanel) panelIzquierdo.getComponent(2)).getComponent(5);

        // Creamos una interfaz funcionar con expression lambda para que las fechas de ida y vuelta sean iguales
        dias.addChangeListener(e->{
            int dia = (int) dias.getValue();
            diaVuelta.setValue(dia);
        });
        mes.addChangeListener(e->{
            String mes1 = (String) mes.getValue();
            mesVuelta.setValue(mes1);
        });
        anio.addChangeListener(e->{
            int anio1 = (int) anio.getValue();
            anioVuelta.setValue(anio1);
        });

        // Declaramos las variables que luego usaremos para bloquear y desbloquear los paneles
        JPanel panel = (JPanel) panelIzquierdo.getComponent(0);
        JRadioButton ida = (JRadioButton) panel.getComponent(0);
        JRadioButton vuelta = (JRadioButton) panel.getComponent(1);

        // hacemos que el botón de ida esté seleccionado por defecto
        vuelta.setSelected(true);


        // bloqueamos el panel de vuelta
        ida.addActionListener(e -> {
            if (ida.isSelected()) {
                bloqueoComponente(panelIzquierdo.getComponent(2));
            }
        });

        // desbloqueamos el panel de vuelta
        vuelta.addActionListener(e -> {
            if (vuelta.isSelected()) {
                desbloqueoComponente(panelIzquierdo.getComponent(2));
            }
        });

        return panelIzquierdo;
    }

    private static void bloqueoComponente(Component componente){
        for (Component c : ((Container) componente).getComponents()) {
            c.setEnabled(false);
        }
    }

    private static void desbloqueoComponente(Component componente){
        for (Component c : ((Container) componente).getComponents()) {
            c.setEnabled(true);
        }
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
        JSpinner dias = new JSpinner(new SpinnerNumberModel(Integer.parseInt(String.valueOf(LocalDate.now().getDayOfMonth())), 1, 31, 1));

        dias.setPreferredSize(new Dimension(50, (int) dias.getPreferredSize().getHeight()));

        // Hacemos que días no se pueda cambiar manualmente
        dias.setEditor(new JSpinner.DefaultEditor(dias));

        String[] nombreMes = { "Enero", "Febrero", "Marzo",
                "Abril", "Mayo", "Junio", "Julio", "Agosto",
                "Septiembre", "Octubre", "Noviembre", "Diciembre"};

        // Introducimos los meses en el JSpinner
        JSpinner meses = new JSpinner(new SpinnerListModel(nombreMes));
        meses.setEditor(new JSpinner.DefaultEditor(meses));

        // Para obtener el mes actual y seleccionarlo por defecto
        meses.setValue(nombreMes[LocalDate.now().getMonthValue() - 1]);

        // Hacemos que el tamaño del JSpinner sea fijo
        meses.setPreferredSize(new Dimension(90, (int) meses.getPreferredSize().getHeight()));

        JSpinner anios = new JSpinner(new SpinnerNumberModel(Integer.parseInt(String.valueOf(LocalDate.now().getYear())), 2002, 2030, 1));
        anios.setEditor(new JSpinner.DefaultEditor(anios));

        meses.addChangeListener(e -> {
                String mes = (String) meses.getValue();
                int diasMes = 0;
                for (Month month : Month.values()) {
                    if (month.getDisplayName(TextStyle.FULL, Locale.forLanguageTag("es")).equalsIgnoreCase(mes)) {
                        diasMes = month.length(LocalDate.parse("12/2/" + anios.getValue(), DateTimeFormatter.ofPattern("dd/M/yyyy")).isLeapYear());
                        dias.setModel(new SpinnerNumberModel(1, 1, diasMes, 1));
                    }
                }
        });

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


        ((JComboBox<?>) origen.getComponent(1)).addActionListener(e -> {
            JComboBox<?> ida = (JComboBox<?>) e.getSource();
            String lugar = (String) ida.getSelectedItem();
            trayecto.remove(1);
            trayecto.add(sustituirPanel(lugar), 1);
            trayecto.revalidate();
        });

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
        numPersonas.setEditor(new JSpinner.DefaultEditor(numPersonas));
        personas.add(numPersonas);
        JButton boton = new JButton("Buscar");
        personas.add(boton);
        return personas;
    }

    private static JPanel sustituirPanel(String lugar){
        JPanel datos = new JPanel();
        JComboBox <String> origen = new JComboBox<>();
        HashMap <String,String> sitios = ApoyoPuntoVenta.lugares();
        origen.addItem("-------------");

        sitios.remove(lugar);
        for (String sitio : sitios.keySet()) {
            origen.addItem(sitio);
        }
        datos.add(new JLabel("Destino: "));
        datos.add(origen);
        return datos;
    }

    private static JPanel jBoxLugares(String texto){
        JPanel datos = new JPanel();
        JComboBox <String> origen = new JComboBox<>();
        HashMap <String,String> sitios = ApoyoPuntoVenta.lugares();
        origen.addItem("-------------");

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
