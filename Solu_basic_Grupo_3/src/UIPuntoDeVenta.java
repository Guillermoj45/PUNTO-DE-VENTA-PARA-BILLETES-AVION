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
    static JFrame frame;
    public static void main(String[] args) {

        frame = new JFrame("Air Camela");

        frame.setSize(600, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLocationRelativeTo(null);
        JPanel primerPanel = panelPrincipal();
        frame.add(primerPanel);

        frame.setVisible(true);
        frame.pack();
        frame.setResizable(false);
    }


    // Parte Gráfica 1 Guillermo -- Se debe de hacer en un panel para facilitar la implementación con devolución del panel

    static HashMap<String,Component> componentes = new HashMap<>();

    // TODO: Para vega :=)
    static Integer numeroDePerosnas;

    private static void addComponente(String nombre, Component componente){
        componentes.put(nombre, componente);
    }

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
        panelCentral.add(panelDerecho());

        JButton boton = (JButton) componentes.get("Buscar");
        boton.addActionListener(e->{
            String mensaje = null;
            if (((JComboBox<?>) componentes.get("Origen")).getSelectedItem().equals("-------------") || ((JComboBox<?>) componentes.get("Destino")).getSelectedItem().equals("-------------")){
                JOptionPane.showMessageDialog(null, "Por favor, seleccione un origen y un destino");
            }
            else {
                if (((JRadioButton) componentes.get("ida")).isSelected() && ((JSpinner) componentes.get("NumPersonas")).getValue().equals(1)) {

                    mensaje = "Ida: " + ((JComboBox<?>) componentes.get("Origen")).getSelectedItem() + "/" + ((JComboBox<?>) componentes.get("Destino")).getSelectedItem() + " " + ((JSpinner) componentes.get("Dia")).getValue() + "-" + ((JSpinner) componentes.get("Mes")).getValue() + "-" + ((JSpinner) componentes.get("Anio")).getValue() + "\n";
                    mensaje += "(" + ((JSpinner) componentes.get("NumPersonas")).getValue() + " persona)";
                }
                else if (((JRadioButton) componentes.get("ida")).isSelected() && (Integer) ((JSpinner) componentes.get("NumPersonas")).getValue() > 1) {

                    mensaje = "Ida: " + ((JComboBox<?>) componentes.get("Origen")).getSelectedItem() + "/" + ((JComboBox<?>) componentes.get("Destino")).getSelectedItem() + " " + ((JSpinner) componentes.get("Dia")).getValue() + "-" + ((JSpinner) componentes.get("Mes")).getValue() + "-" + ((JSpinner) componentes.get("Anio")).getValue() + "\n";
                    mensaje += "(" + ((JSpinner) componentes.get("NumPersonas")).getValue() + " personas)";
                }
                else if (((JRadioButton) componentes.get("idaVuelta")).isSelected() && ((JSpinner) componentes.get("NumPersonas")).getValue().equals(1)) {

                    mensaje = "Ida: " + ((JComboBox<?>) componentes.get("Origen")).getSelectedItem() + "/" + ((JComboBox<?>) componentes.get("Destino")).getSelectedItem() + " " + ((JSpinner) componentes.get("Dia")).getValue() + "-" + ((JSpinner) componentes.get("Mes")).getValue() + "-" + ((JSpinner) componentes.get("Anio")).getValue() + "\n";
                    mensaje += "Vuelta: " + ((JComboBox<?>) componentes.get("Destino")).getSelectedItem() + "/" + ((JComboBox<?>) componentes.get("Origen")).getSelectedItem() + " " + ((JSpinner) componentes.get("Dia")).getValue() + "-" + ((JSpinner) componentes.get("Mes")).getValue() + "-" + ((JSpinner) componentes.get("Anio")).getValue() + "\n";
                    mensaje += "(" + ((JSpinner) componentes.get("NumPersonas")).getValue() + " persona)";
                }
                else if (((JRadioButton) componentes.get("idaVuelta")).isSelected() && (Integer) ((JSpinner) componentes.get("NumPersonas")).getValue() > 1) {

                    mensaje = "Ida: " + ((JComboBox<?>) componentes.get("Origen")).getSelectedItem() + "/" + ((JComboBox<?>) componentes.get("Destino")).getSelectedItem() + " " + ((JSpinner) componentes.get("Dia")).getValue() + "-" + ((JSpinner) componentes.get("Mes")).getValue() + "-" + ((JSpinner) componentes.get("Anio")).getValue() + "\n";
                    mensaje += "Vuelta: " + ((JComboBox<?>) componentes.get("Destino")).getSelectedItem() + "/" + ((JComboBox<?>) componentes.get("Origen")).getSelectedItem() + " " + ((JSpinner) componentes.get("Dia")).getValue() + "-" + ((JSpinner) componentes.get("Mes")).getValue() + "-" + ((JSpinner) componentes.get("Anio")).getValue() + "\n";
                    mensaje += "(" + ((JSpinner) componentes.get("NumPersonas")).getValue() + " personas)";
                }

                int si = JOptionPane.showConfirmDialog(null, mensaje);

                if (si == 0) {

                    if (((JPanel)(componentes.get("panel"))).getComponentCount() > 1){

                        ((JPanel) componentes.get("panel")).remove(1);

                    }

                    numeroDePerosnas = ((Integer) ((JSpinner) componentes.get("NumPersonas")).getValue());
                    System.out.println(numeroDePerosnas);

                    ((JPanel) componentes.get("panel")).add(panel2());

                    frame.pack();
                } else if (si== 1){
                    borronCuentaNueva();
                    JOptionPane.showMessageDialog(null, "Todos los ajustes se restablecieron");
                } else if (si == 2){

                    JOptionPane.showMessageDialog(null, "cancelada");
                }
            }
        });

        return panelCentral;
    }

    private static void borronCuentaNueva(){
        ((JPanel) componentes.get("panel")).removeAll();
        JPanel panel = (JPanel) componentes.get("panel");
        componentes.clear();

        (panel).add(primerPanel());
        addComponente("panel", panel);
        componentes.get("panel").revalidate();
        frame.pack();
    }

    private static JPanel panelPrincipal(){
        JPanel PanelPrincipal = new JPanel();
        PanelPrincipal.add(primerPanel());
        PanelPrincipal.setBorder(BorderFactory.createRaisedBevelBorder());
        PanelPrincipal.setLayout(new BoxLayout(PanelPrincipal, BoxLayout.Y_AXIS));

        componentes.put("panel", PanelPrincipal);

        return PanelPrincipal;
    }
    private static JPanel panelIzquierdo(){
        JPanel panelIzquierdo = new JPanel();

        panelIzquierdo.setLayout (new GridLayout(3, 1, 0, 0));
        panelIzquierdo.add(modalidad());
        JPanel fechaida = panelFechas("Fecha de Ida");
        JPanel fechavuelta = panelFechas("Fecha Vuelta");

        panelIzquierdo.add(fechaida);
        panelIzquierdo.add(fechavuelta);

        addComponente("Dia", fechaida.getComponent(1));
        addComponente("Mes", fechaida.getComponent(3));
        addComponente("Anio", fechaida.getComponent(5));

        addComponente("DiaVuelta", fechavuelta.getComponent(1));
        addComponente("MesVuelta", fechavuelta.getComponent(3));
        addComponente("AnioVuelta", fechavuelta.getComponent(5));


        // TODO: Optimizar esto con el diccionario(si da tiempo)
        // hacemos que sea el mismo valor en ida y vuelta

        JPanel fecha = (JPanel) panelIzquierdo.getComponent(1);
        JSpinner dias = (JSpinner) fecha.getComponent(1);
        JSpinner mes = (JSpinner) fecha.getComponent(3);
        JSpinner anio = (JSpinner) fecha.getComponent(5);

        JSpinner diaVuelta = (JSpinner) ((JPanel) panelIzquierdo.getComponent(2)).getComponent(1);
        JSpinner mesVuelta = (JSpinner) ((JPanel) panelIzquierdo.getComponent(2)).getComponent(3);
        JSpinner anioVuelta = (JSpinner) ((JPanel) panelIzquierdo.getComponent(2)).getComponent(5);


        dias.addChangeListener(e->{
            if (componentes.get("DiaVuelta").isEnabled()) {
                int dia = (int) dias.getValue();
                diaVuelta.setValue(dia);
            }
        });
        mes.addChangeListener(e->{
            if (componentes.get("DiaVuelta").isEnabled()) {
                String mes1 = (String) mes.getValue();
                mesVuelta.setValue(mes1);
            }
        });
        anio.addChangeListener(e->{
            if (componentes.get("DiaVuelta").isEnabled()) {
                int anio1 = (int) anio.getValue();
                anioVuelta.setValue(anio1);
            }
        });

        // Creamos una interfaz funcionar con expression lambda para que las fechas de ida y vuelta sean iguales
        // Declaramos las variables que luego usaremos para bloquear y desbloquear los paneles
        JPanel panel = (JPanel) panelIzquierdo.getComponent(0);
        JRadioButton ida = (JRadioButton) panel.getComponent(0);
        JRadioButton vuelta = (JRadioButton) panel.getComponent(1);

        // hacemos que el botón de ida esté seleccionado por defecto
        vuelta.setSelected(true);

        // TODO:Hacer que eso se ejecute solo cuando esta activado no desactivado

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

        addComponente("ida", ida);
        addComponente("idaVuelta", idaVuelta);

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
        meses.setValue("Septiembre");

        // Hacemos que el tamaño del JSpinner sea fijo
        meses.setPreferredSize(new Dimension(90, (int) meses.getPreferredSize().getHeight()));

        JSpinner anios = new JSpinner(new SpinnerNumberModel(2002, 2002, 2030, 1));
        anios.setEditor(new JSpinner.DefaultEditor(anios));

        //TODO: Optimizar esta parte (si da tiempo)
        meses.addChangeListener(e -> {
                String mes = (String) meses.getValue();
                int diasMes;
                for (Month month : Month.values()) {
                    if (month.getDisplayName(TextStyle.FULL, Locale.forLanguageTag("es")).equalsIgnoreCase(mes)) {
                        diasMes = month.length(LocalDate.parse("12/2/" + anios.getValue(), DateTimeFormatter.ofPattern("dd/M/yyyy")).isLeapYear());
                        dias.setModel(new SpinnerNumberModel(Integer.parseInt(String.valueOf(dias.getValue())), 1, diasMes, 1));
                    }
                }
        });

        anios.addChangeListener(e ->{
            String mes = (String) meses.getValue();
            int diasMes;
            for (Month month : Month.values()) {
                if (month.getDisplayName(TextStyle.FULL, Locale.forLanguageTag("es")).equalsIgnoreCase(mes)) {
                    diasMes = month.length(LocalDate.parse("12/2/" + anios.getValue(), DateTimeFormatter.ofPattern("dd/M/yyyy")).isLeapYear());
                    dias.setModel(new SpinnerNumberModel(Integer.parseInt(String.valueOf(dias.getValue())), 1, diasMes, 1));
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

    private static JPanel panelDerecho(){
        JPanel trayecto = new JPanel();
        trayecto.setLayout(new GridLayout(3, 1, 0, 0));
        TitledBorder centerBorder = BorderFactory.createTitledBorder("Trayecto");
        centerBorder.setTitleJustification(TitledBorder.CENTER);
        trayecto.setBorder(centerBorder);

        JPanel origen = jBoxLugares(" Origen: ");
        JPanel destino = jBoxLugares("Destino: ");
        JPanel personas = Personas();

        addComponente("Origen", origen.getComponent(1));
        addComponente("Destino", destino.getComponent(1));


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
        addComponente("NumPersonas", numPersonas);
        addComponente("Buscar", boton);
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
        componentes.remove("Destino");
        componentes.put("Destino", origen);

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

    private static JPanel panel2(){
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(titulo2P(), BorderLayout.NORTH);
        panel.add(idaVuelta(), BorderLayout.CENTER);
        panel.setBorder(BorderFactory.createLoweredBevelBorder());
        panel.add(botonIdaVuelta(), BorderLayout.SOUTH);
        return panel;
    }

    private static JPanel botonIdaVuelta(){
        JPanel panel = new JPanel();
        JButton boton = new JButton("Confirmar Elecciones");
        boton.setPreferredSize(new Dimension(170, 25));
        panel.add(boton);

        boton.addActionListener(e->{
            ((JPanel) componentes.get("panel")).add(panel3());
        });
        return panel;
    }

    private static JPanel idaVuelta(){
        JPanel panel = new JPanel();
        String Origen = (String) ((JComboBox<?>) componentes.get("Origen")).getSelectedItem();
        String Destino = (String) ((JComboBox<?>) componentes.get("Destino")).getSelectedItem();


        JPanel ida = idaDispo(ApoyoPuntoVenta.recoDate(Origen, Destino), "Ida");
        JPanel vuelta = idaDispo(ApoyoPuntoVenta.recoDate(Destino, Origen), "Vuelta");

        panel.add(ida);
        if (((JRadioButton) componentes.get("idaVuelta")).isSelected()){
            panel.add(vuelta);
            panel.setLayout(new GridLayout(1, 2, 0, 0));
        }else {
            panel.setLayout(new GridLayout(1, 1, 0, 0));
        }

        addComponente("idaPrimeraHora", ida.getComponent(0));
        addComponente("idaUltimaHora", ida.getComponent(1));
        addComponente("vueltaPrimeraHora", vuelta.getComponent(0));
        addComponente("vueltaUltimaHora", vuelta.getComponent(1));

        return panel;
    }

    private static JPanel idaDispo(String Primero,String Ettiqueta){
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder(Ettiqueta));
        panel.setLayout(new GridLayout(2, 1, 0, 0));
        String[] datos = Primero.split("\n");

        JRadioButton ida = new JRadioButton(datos[0]);
        JRadioButton idaVuelta = new JRadioButton(datos[1]);
        ButtonGroup grupo = new ButtonGroup();


        panel.add(ida);
        panel.add(idaVuelta);
        grupo.add(ida);
        grupo.add(idaVuelta);
        return panel;
    }

    private static JPanel titulo2P(){
        JPanel panel = new JPanel();

        JLabel texto = new JLabel("LOS VUELOS DISPONIBLES SON:");

        // aplicamos Verdana, 20, Negrita Borde hundido
        texto.setFont(new Font("Verdana", Font.BOLD, 15));
        panel.add(texto);


        //panel.add(texto);
        return panel;
    }


    // Parte Gráfica 3 Vega -- Se debe de hacer en un panel para facilitar la implementación con devolución del panel
    private static JPanel panel3(){
        Tercer_panel tercerPanel = new Tercer_panel();
        JPanel panel = new JPanel();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() { // Se ejecuta cuando se inicia la aplicación
                // Crea un nuevo objeto de la clase Tercer_panel
                new Tercer_panel().setVisible(true);
            }
        });
        return panel;
    }

}
