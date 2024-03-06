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
     JFrame frame;
    HashMap<String,Component> componentes = new HashMap<>();

    // TODO: Para vega :=)
    Integer numeroDePerosnas;
    Float precioIda;
    Float precioTotalVuelta;
    String [] holo;
    String [] holo1;

    protected void iniciar(){
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

    private void addComponente(String nombre, Component componente){
        componentes.put(nombre, componente);
    }

    private JPanel tituloPanel(){

        // creamos el panel
        JPanel titulo = new JPanel();
        JLabel texto = new JLabel("PUNTOS DE VENTA DE BILLETES");

        // aplicamos Verdana, 20, Negrita Borde hundido
        texto.setFont(new Font("Verdana", Font.BOLD, 20));
        titulo.setBorder(BorderFactory.createRaisedBevelBorder());
        titulo.add(texto);

        return titulo;
    }

    private JPanel panelCentral(){
        // creamos el panel
        JPanel panelCentral = new JPanel();

        // aplicamos un borde al panel
        panelCentral.setLayout(new GridLayout(1, 2, 40, 0));
        panelCentral.add(panelIzquierdo());
        panelCentral.add(panelDerecho());

        // añadimos el panel al diccionario
        JButton boton = (JButton) componentes.get("Buscar");
        boton.addActionListener(e->{

            // comprobamos que a selecionado un origen y un destino
            if (((JComboBox<?>) componentes.get("Origen")).getSelectedItem().equals("-------------") || ((JComboBox<?>) componentes.get("Destino")).getSelectedItem().equals("-------------")){
                // mostramos un mensaje de error
                JOptionPane.showMessageDialog(null, "Por favor, seleccione un origen y un destino");
            }
            else {
                // preguntamos si quiere hacer una nueva cuenta
                int si = JOptionPane.showConfirmDialog(null, mensajes());

                // sí quiere hacer una nueva cuenta
                if (si == 0) {

                    // comprobamos si hay un panel 2
                    if (((JPanel)(componentes.get("panel"))).getComponentCount() > 1){

                        // eliminamos el panel 2
                        ((JPanel) componentes.get("panel")).remove(1);
                    }

                    // obtenemos el número de personas
                    numeroDePerosnas = ((Integer) ((JSpinner) componentes.get("NumPersonas")).getValue());

                    // añadimos el panel 2
                    ((JPanel) componentes.get("panel")).add(panel2());

                    // actualizamos el frame
                    frame.pack();

                } // si no quiere hacer una nueva cuenta
                else if (si== 1){
                    borronCuentaNueva();
                    JOptionPane.showMessageDialog(null, "Todos los ajustes se restablecieron");
                }
            }
        });

        return panelCentral;
    }

    private String mensajes (){
        // Un if para que te muestre el mensaje correcto
        String mensaje = null;
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
            mensaje += "Vuelta: " + ((JComboBox<?>) componentes.get("Destino")).getSelectedItem() + "/" + ((JComboBox<?>) componentes.get("Origen")).getSelectedItem() + " " + ((JSpinner) componentes.get("DiaVuelta")).getValue() + "-" + ((JSpinner) componentes.get("MesVuelta")).getValue() + "-" + ((JSpinner) componentes.get("AnioVuelta")).getValue() + "\n";
            mensaje += "(" + ((JSpinner) componentes.get("NumPersonas")).getValue() + " persona)";
        }
        else if (((JRadioButton) componentes.get("idaVuelta")).isSelected() && (Integer) ((JSpinner) componentes.get("NumPersonas")).getValue() > 1) {

            mensaje = "Ida: " + ((JComboBox<?>) componentes.get("Origen")).getSelectedItem() + "/" + ((JComboBox<?>) componentes.get("Destino")).getSelectedItem() + " " + ((JSpinner) componentes.get("Dia")).getValue() + "-" + ((JSpinner) componentes.get("Mes")).getValue() + "-" + ((JSpinner) componentes.get("Anio")).getValue() + "\n";
            mensaje += "Vuelta: " + ((JComboBox<?>) componentes.get("Destino")).getSelectedItem() + "/" + ((JComboBox<?>) componentes.get("Origen")).getSelectedItem() + " " + ((JSpinner) componentes.get("DiaVuelta")).getValue() + "-" + ((JSpinner) componentes.get("MesVuelta")).getValue() + "-" + ((JSpinner) componentes.get("AnioVuelta")).getValue() + "\n";
            mensaje += "(" + ((JSpinner) componentes.get("NumPersonas")).getValue() + " personas)";
        }
        return mensaje;
    }

    private void borronCuentaNueva(){
        // Eliminamos el panel y lo generamos de nuevo
        ((JPanel) componentes.get("panel")).removeAll();
        JPanel panel = (JPanel) componentes.get("panel");
        componentes.clear();

        // añadimos los componentes al panel
        panel.add(primerPanel());
        addComponente("panel", panel);
        componentes.get("panel").revalidate();
        frame.pack();
    }

    private JPanel panelPrincipal(){
        // creamos el panel
        JPanel PanelPrincipal = new JPanel();
        PanelPrincipal.add(primerPanel());
        PanelPrincipal.setBorder(BorderFactory.createRaisedBevelBorder());
        PanelPrincipal.setLayout(new BoxLayout(PanelPrincipal, BoxLayout.Y_AXIS));

        componentes.put("panel", PanelPrincipal);

        return PanelPrincipal;
    }

    private JPanel panelIzquierdo(){
        // creamos el panel
        JPanel panelIzquierdo = new JPanel();

        // aplicamos un borde al panel
        panelIzquierdo.setLayout (new GridLayout(3, 0, 0, 0));
        panelIzquierdo.add(modalidad());
        JPanel fechaida = panelFechas("Fecha de Ida");
        JPanel fechavuelta = panelFechas("Fecha Vuelta");

        // añadimos los paneles al panel
        panelIzquierdo.add(fechaida);
        panelIzquierdo.add(fechavuelta);

        // añadimos los componentes al diccionario
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

        // Creamos una interfaz funcionar con expression lambda para que las fechas de ida y vuelta sean iguales
        dias.addChangeListener(e->{
            if (componentes.get("DiaVuelta").isEnabled()) {
                int dia = (int) dias.getValue();
                diaVuelta.setValue(dia);
            }
        });

        // Creamos una interfaz funcionar con expression lambda para que las fechas de ida y vuelta sean iguales
        mes.addChangeListener(e->{
            if (componentes.get("DiaVuelta").isEnabled()) {
                String mes1 = (String) mes.getValue();
                mesVuelta.setValue(mes1);
            }
        });

        // Creamos una interfaz funcionar con expression lambda para que las fechas de ida y vuelta sean iguales
        anio.addChangeListener(e->{
            if (componentes.get("DiaVuelta").isEnabled()) {
                int anio1 = (int) anio.getValue();
                anioVuelta.setValue(anio1);
            }
        });

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

    // Hacemos que bloquee o desbloquee los componentes
    private void bloqueoComponente(Component componente){
        for (Component c : ((Container) componente).getComponents()) {
            c.setEnabled(false);
        }
    }

    private void desbloqueoComponente(Component componente){
        for (Component c : ((Container) componente).getComponents()) {
            c.setEnabled(true);
        }
    }

    // Creamos el panel de modalidad
    private JPanel modalidad(){
        JPanel panelModalidad = new JPanel();

        // creamos los botones
        JRadioButton ida = new JRadioButton("Ida Sólo");
        JRadioButton idaVuelta = new JRadioButton("Ida/Vuelta");
        ButtonGroup grupo = new ButtonGroup();
        ida.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 50));
        idaVuelta.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 50));

        // añadimos los botones al panel
        addComponente("ida", ida);
        addComponente("idaVuelta", idaVuelta);

        // añadimos los botones al panel
        panelModalidad.add(ida);
        panelModalidad.add(idaVuelta);

        // dibujamos un borde alrededor del panel con el título "Modalidad" centrado
        TitledBorder centerBorder = BorderFactory.createTitledBorder("Modalidad");
        centerBorder.setTitleJustification(TitledBorder.CENTER);
        panelModalidad.setBorder(centerBorder);

        // añadimos los botones al grupo
        grupo.add(ida);
        grupo.add(idaVuelta);

        return panelModalidad;
    }

    private JPanel panelFechas(String titulo){
        // creamos el panel de fechas
        JPanel fechaIda = new JPanel();
        JSpinner dias = new JSpinner(new SpinnerNumberModel(1, 1, 31, 1));

        // Hacemos que el tamaño del JSpinner sea fijo
        dias.setPreferredSize(new Dimension(50, (int) dias.getPreferredSize().getHeight()));

        // Hacemos que días no se pueda cambiar manualmente
        dias.setEditor(new JSpinner.DefaultEditor(dias));

        // Creamos un array con los nombres de los meses
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

        // Actualizaciones de los Meses
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

        // Actualizaciones de los Años
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

        // añadimos los componentes al panel
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

    private JPanel panelDerecho(){
        JPanel trayecto = new JPanel();

        // dibujamos un borde alrededor del panel con el título "Trayecto" centrado
        trayecto.setLayout(new GridLayout(3, 1, 0, 0));
        TitledBorder centerBorder = BorderFactory.createTitledBorder("Trayecto");
        centerBorder.setTitleJustification(TitledBorder.CENTER);
        trayecto.setBorder(centerBorder);

        // añadimos los paneles al panel
        JPanel origen = jBoxLugares(" Origen: ");
        JPanel destino = jBoxLugares("Destino: ");
        JPanel personas = Personas();

        // añadimos los componentes al diccionario
        addComponente("Origen", origen.getComponent(1));
        addComponente("Destino", destino.getComponent(1));

        // Creamos un listener para que cuando cambie el origen, cambie el destino
        ((JComboBox<?>) origen.getComponent(1)).addActionListener(e -> {
            JComboBox<?> ida = (JComboBox<?>) e.getSource();
            String lugar = (String) ida.getSelectedItem();
            trayecto.remove(1);
            trayecto.add(sustituirPanel(lugar), 1);
            trayecto.revalidate();
        });

        // añadimos los paneles al panel
        origen.setBounds(50, 50, 90, 20);
        trayecto.add(origen);
        trayecto.add(destino);
        trayecto.add(personas);
        return trayecto;
    }

    //Creamos el pane de personas
    private JPanel Personas(){
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

    private JPanel sustituirPanel(String lugar){
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

    // Creamos el panel de lugares
    private JPanel jBoxLugares(String texto){
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

    private JPanel primerPanel(){
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

    // Parte Gráfica 2 Pablo (QUE AL FINAL HA HECHO GUILLE) -- Se debe de hacer en un panel para facilitar la implementación con devolución del panel

    private JPanel panel2(){
        JPanel panel = new JPanel();
        // Aplicamos bordes y además añadimos los componentes al panel
        panel.setLayout(new BorderLayout());
        panel.add(titulo2P(), BorderLayout.NORTH);
        panel.add(idaVuelta(), BorderLayout.CENTER);
        panel.setBorder(BorderFactory.createLoweredBevelBorder());
        panel.add(botonIdaVuelta(), BorderLayout.SOUTH);
        return panel;
    }

    private JPanel botonIdaVuelta(){
        JPanel panel = new JPanel();
        JButton boton = new JButton("Confirmar Elecciones");
        boton.setPreferredSize(new Dimension(170, 25));
        panel.add(boton);

        boton.addActionListener(e -> {
            //todo HO
            // Comprobamos que a seleccionado un origen y un destino

            if (((JRadioButton) componentes.get("idaPrimeraHora")).isSelected()){
                precioIda = Float.valueOf(holo[1]);
            }else {
                precioIda = Float.valueOf(holo[2]);
            }
            if (((JRadioButton) componentes.get("vueltaPrimeraHora")).isSelected()){
                precioTotalVuelta = Float.valueOf(holo1[1]);
            } else if (((JRadioButton) componentes.get("vueltaUltimaHora")).isSelected()){
                precioTotalVuelta = Float.valueOf(holo1[2]);
            }

            if (((JRadioButton) componentes.get("ida")).isSelected()) {
                if (!((JRadioButton) componentes.get("idaPrimeraHora")).isSelected() && !((JRadioButton) componentes.get("idaUltimaHora")).isSelected()) {
                    JOptionPane.showMessageDialog(null, "Por favor, seleccione un vuelo de ida");

                }
                else {
                    //TODO: Añadir panel de vega
                    Tercer_panel tercerPanel = new Tercer_panel();
                    ((JPanel) componentes.get("panel")).add(tercerPanel.Tercer_panel(numeroDePerosnas, ((JRadioButton) componentes.get("ida")).isSelected(), precioIda, precioTotalVuelta));
                    frame.pack();
                }
            }
            else if (((JRadioButton) componentes.get("idaVuelta")).isSelected()) {
                if (!((JRadioButton) componentes.get("idaPrimeraHora")).isSelected() && !((JRadioButton) componentes.get("idaUltimaHora")).isSelected() || !((JRadioButton) componentes.get("vueltaPrimeraHora")).isSelected() && !((JRadioButton) componentes.get("vueltaUltimaHora")).isSelected()) {
                    JOptionPane.showMessageDialog(null, "Por favor, seleccione un vuelo de ida y uno de vuelta");
                }
                else {
                    //TODO: Añadir panel de vega
                    Tercer_panel tercerPanel = new Tercer_panel();
                    ((JPanel) componentes.get("panel")).add(tercerPanel.Tercer_panel(numeroDePerosnas, ((JRadioButton) componentes.get("ida")).isSelected(), precioIda, precioTotalVuelta));
                    frame.pack();
                }
            }
        });
        return panel;
    }


    private JPanel idaVuelta(){
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 2, 50, 0));

        String Origen = (String) ((JComboBox<?>) componentes.get("Origen")).getSelectedItem();
        String Destino = (String) ((JComboBox<?>) componentes.get("Destino")).getSelectedItem();
        holo = ApoyoPuntoVenta.recoDate(Origen, Destino);
        holo1 = ApoyoPuntoVenta.recoDate(Destino, Origen);


        JPanel ida = idaDispo(holo[0], "Ida");
        JPanel vuelta = idaDispo(holo1[0], "Vuelta");

        panel.add(ida);
        if (((JRadioButton) componentes.get("idaVuelta")).isSelected()){
            panel.add(vuelta);
        }else{
            panel.add(new JPanel());
        }

        //todo:datos
        // añadimos los componentes al diccionario
        addComponente("idaPrimeraHora", ida.getComponent(0));
        addComponente("idaUltimaHora", ida.getComponent(1));
        addComponente("vueltaPrimeraHora", vuelta.getComponent(0));
        addComponente("vueltaUltimaHora", vuelta.getComponent(1));

        return panel;
    }

    private JPanel idaDispo(String Primero, String Ettiqueta){

        // creamos el panel
        JPanel panel = new JPanel();

        // aplicamos un borde al panel
        panel.setBorder(BorderFactory.createTitledBorder(Ettiqueta));
        panel.setLayout(new GridLayout(3, 1, 0, 0));
        String[] datos = Primero.split("\n");

        // creamos los botones
        JRadioButton ida = new JRadioButton(datos[0]);
        JRadioButton idaVuelta = new JRadioButton(datos[1]);
        ButtonGroup grupo = new ButtonGroup();

        // añadimos los botones al panel
        panel.add(ida);
        panel.add(idaVuelta);
        grupo.add(ida);
        grupo.add(idaVuelta);

        return panel;
    }

    private JPanel titulo2P(){
        JPanel panel = new JPanel();

        JLabel texto = new JLabel("LOS VUELOS DISPONIBLES SON:");

        // aplicamos Verdana, 20, Negrita Borde hundido
        texto.setFont(new Font("Verdana", Font.BOLD, 15));
        panel.add(texto);


        //panel.add(texto);
        return panel;
    }


    // Parte Gráfica 3 Vega -- Se debe de hacer en un panel para facilitar la implementación con devolución del panel


}
