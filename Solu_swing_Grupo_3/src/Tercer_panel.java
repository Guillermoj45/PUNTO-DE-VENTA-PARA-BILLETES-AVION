import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Tercer_panel extends JFrame {
    private JPanel Tercer_panel; // Panel principal


    // Paneles detalles e importes
    private JPanel Panel_detalles;
    private JPanel Panel_segunda_parte;


    // Labels del panel detalles
    private JLabel Label_asiento;


    // TextFields del panel importes
    private JTextField Importes_asiento;
    private JTextField Importes_embarque;
    private JTextField Importes_equipaje;
    private JTextField Importes_precio_total;


    // Sliders y botones
    private JSlider Seleccion_fila; // Slider para seleccionar la fila
    private ButtonGroup Seleccion_posiciones; // Grupo de botones para seleccionar una posición
    private JCheckBox Select_embarque, Select_equipaje; // CheckBox para seleccionar el embarque y el equipaje


    // Precios de los asientos, embarque y equipaje
    private int Precio_asiento;
    private int Precio_embarque;
    private int Precio_equipaje;


    Integer numero_personas;

    Boolean if_ida;


    // Fotos billetes
    JLabel label_img_billete= new JLabel();


    Float precio_ida;
    Float precio_vuelta;



    // Constructor
    public JPanel Tercer_panel(int numero_personas, Boolean if_ida, Float precio_ida, Float precio_vuelta) {
        setTitle("Air Camela");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.numero_personas = numero_personas;
        this.if_ida = if_ida;
        this.precio_ida = precio_ida;
        this.precio_vuelta = precio_vuelta;

        Tercer_panel = new JPanel();

         // Crea el panel principal
        add(Tercer_panel); // Agrega el panel principal al frame


        Tercer_panel.setLayout(new BoxLayout(Tercer_panel, BoxLayout.X_AXIS)); // Establece el layout del panel principal


        // Creación de los paneles
        Panel_detalles = new JPanel(new GridLayout(2, 1));


        Panel_segunda_parte = new JPanel();
        Panel_segunda_parte.setLayout(new BoxLayout(Panel_segunda_parte, BoxLayout.Y_AXIS));

        // Configuración del panel de detalles
        Panel_detalles_config();

        // Configuración del panel de importes
        Panel_importes_config();


        // Configuración del layout principal
        setLayout(new GridLayout(1, 2));

        // Agrega los paneles al layout principal
        Tercer_panel.add(Panel_detalles);
        Tercer_panel.add(Panel_segunda_parte);

        // Le doy un valor inicial a los precios
        Precio_asiento = 12;
        Precio_embarque = 0;
        Precio_equipaje = 0;

        return Tercer_panel;
    }


    // Configuración del panel de detalles
    private void Panel_detalles_config() {
        Panel_detalles.setBorder(BorderFactory.createTitledBorder(BorderFactory.createTitledBorder(UIManager.getBorder("TitleBorder.border")),"Detalles", TitledBorder.CENTER, TitledBorder.TOP));

        // Panel asiento
        JPanel Panel_asiento = new JPanel(new GridLayout(3, 1));
        Panel_asiento.setBorder(BorderFactory.createTitledBorder("Asiento"));

        // Creal el Label filas
        Label_asiento = new JLabel("Filas: 1");
        Label_asiento.setHorizontalAlignment(SwingConstants.CENTER); // Alinea el texto al centro

        // Agrega el Label_asiento al Panel_asiento
        Panel_asiento.add(Label_asiento);


        // Crea el slider para seleccionar la fila
        Seleccion_fila = new JSlider(1, 26, 1);
        Seleccion_fila.setMajorTickSpacing(5); // Separación entre los valores, las rayitas grandes
        Seleccion_fila.setMinorTickSpacing(1); // Separación entre los valores, las rayitas pequeñas
        Seleccion_fila.setPaintTicks(true); // Muestra las rayitas
        Seleccion_fila.setPaintLabels(true); // Muestra los valores
        Seleccion_fila.setBorder(BorderFactory.createEmptyBorder(0,15,0,15)); // Borde vacío

        // Agrega el ChangeListener al JSlider para actualizar el número de filas
        Seleccion_fila.addChangeListener(new ChangeListener() { // Se ejecuta cuando el valor del slider cambia
            @Override
            public void stateChanged(ChangeEvent e) {
                Label_asiento.setText("Filas: " + Seleccion_fila.getValue()); // Actualiza el contenido del JLabel
                Nuevo_precio_total(); // Actualiza el precio total
            }
        });


        // Agrega el slider al Panel_asiento
        Panel_asiento.add(Seleccion_fila);


        // Crea el grupo de botones
        Seleccion_posiciones = new ButtonGroup();

        // Crea el Panel_posicion
        JPanel Panel_posicion = new JPanel(new GridLayout(1, 3));
        Panel_posicion.setBorder(BorderFactory.createTitledBorder("Posición"));
        Panel_posicion.setLayout(new GridBagLayout());

        // Crea los botones
        JRadioButton opcion_pasillo = new JRadioButton("Pasillo");
        JRadioButton opcion_centro = new JRadioButton("Centro");
        JRadioButton opcion_ventana = new JRadioButton("Ventana");

        // Agrega los botones al grupo
        Seleccion_posiciones.add(opcion_pasillo);
        Seleccion_posiciones.add(opcion_centro);
        Seleccion_posiciones.add(opcion_ventana);


        // Crea el Panel_extras
        JPanel Panel_extras = new JPanel(new GridLayout(1, 2));
        Panel_extras.setBorder(BorderFactory.createTitledBorder("Extras"));
        Panel_extras.setLayout(new GridBagLayout());


        // Crea el Panel_embarque
        JPanel Panel_embarque = new JPanel(new FlowLayout(FlowLayout.LEFT));

        // Crea el checkbox para seleccionar el embarque
        Select_embarque = new JCheckBox("Embarque Prior.");

        // Agrega el checkbox al Panel_embarque
        Panel_embarque.add(Select_embarque);


        // Crea el Panel_equipaje
        JPanel Panel_equipaje = new JPanel(new FlowLayout(FlowLayout.LEFT));

        // Crea el checkbox para seleccionar el equipaje
        Select_equipaje = new JCheckBox("Equipaje");

        // Agrega el checkbox al Panel_equipaje
        Panel_equipaje.add(Select_equipaje);


        // Agrega los paneles al Panel_embarque_equipaje
        Panel_extras.add(Panel_embarque);
        Panel_extras.add(Panel_equipaje);


        // Agrega el Panel_embarque_equipaje al Panel_extras
        Panel_detalles.add(Panel_asiento);


        // Agrega el Panel_posicion al Panel_detalles
        Panel_detalles.add(Panel_posicion);

        // Agrega las opciones al Panel_posicion
        Panel_posicion.add(opcion_pasillo);
        Panel_posicion.add(opcion_centro);
        Panel_posicion.add(opcion_ventana);


        // Agrega el Panel_extras al Panel_detalles
        Panel_detalles.add(Panel_extras);


        // Crea el Panel_primera_mitad
        JPanel Panel_primera_mitad = new JPanel(new BorderLayout());
        Panel_primera_mitad.add(Panel_asiento, BorderLayout.CENTER); // Agrega Panel_asiento al centro

        // Agrega Panel_primera_mitad al Panel_detalles
        Panel_detalles.add(Panel_primera_mitad);


        // Crea el Panel_segunda_mitad
        JPanel Panel_segunda_mitad = new JPanel(new GridLayout(2, 1));

        // Agrega Panel_posicion y Panel_extras al Panel_segunda_mitad
        Panel_segunda_mitad.add(Panel_posicion);
        Panel_segunda_mitad.add(Panel_extras);

        // Agrega Panel_segunda_mitad al Panel_detalles
        Panel_detalles.add(Panel_segunda_mitad);
    }


    // Configuración del panel de importes
    private void Panel_importes_config() {
        // Crea los paneles para los importes y los billetes
        JPanel Panel_importes = new JPanel();

        JPanel Panel_billetes = new JPanel(new GridBagLayout());
        Panel_billetes.setPreferredSize(new Dimension( 200, 240));

        // Agrega Panel_posicion y Panel_extras al Panel_segunda_mitad
        Panel_segunda_parte.add(Panel_importes);
        Panel_segunda_parte.add(Panel_billetes);

        Panel_importes.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1),"Importes"));

        Panel_billetes.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1),"Billetes"));


        JPanel Panel_izq_importes = new JPanel();
        Panel_izq_importes.setLayout(new GridLayout(2, 1));

        Panel_importes.add(Panel_izq_importes);

        JPanel Panel_precios = new JPanel();
        JPanel Panel_precio_final = new JPanel();

        Panel_izq_importes.add(Panel_precios);
        Panel_izq_importes.add(Panel_precio_final);


        JPanel Panel_der_importes = new JPanel();

        Panel_importes.add(Panel_der_importes);

        Panel_der_importes.setLayout(new GridLayout(2, 1));


        // Agrega el Label_asiento al Panel_importes
        Panel_precios.add(new JLabel("Asiento:"));


        // Crea el JTextField para mostrar el precio del asiento
        Importes_asiento = new JTextField("12,00€", 4); // Valor inicial
        Importes_asiento.setHorizontalAlignment(SwingConstants.CENTER); // Alinea el texto al centro
        Importes_asiento.setEditable(false); // No se puede editar
        Importes_asiento.setBackground(Color.WHITE); // Poner el fondo blanco
        Importes_asiento.setFont(new Font("Tahona", Font.BOLD, 14)); // Cambiar la fuente
        Panel_precios.add(Importes_asiento); // Agrega el JTextField al Panel_importes


        // Agrega el Label_embarque al Panel_importes
        Panel_precios.add(new JLabel("Embarque:"));

        // Crea el JTextField para mostrar el precio del embarque
        Importes_embarque = new JTextField("0,00€", 4);
        Importes_embarque.setHorizontalAlignment(SwingConstants.CENTER);
        Importes_embarque.setEditable(false);
        Importes_embarque.setBackground(Color.WHITE);
        Importes_embarque.setFont(new Font("Tahona", Font.BOLD, 14));
        Panel_precios.add(Importes_embarque);


        // Agrega el Label_equipaje al Panel_importes
        Panel_precios.add(new JLabel("Equipaje:"));

        // Crea el JTextField para mostrar el precio del equipaje
        Importes_equipaje = new JTextField("0,00€", 4);
        Importes_equipaje.setHorizontalAlignment(SwingConstants.CENTER);
        Importes_equipaje.setEditable(false);
        Importes_equipaje.setBackground(Color.WHITE);
        Importes_equipaje.setFont(new Font("Tahona", Font.BOLD, 14));
        Panel_precios.add(Importes_equipaje);


        // Agrega el Label_precio_total al Panel_importes
        Panel_precio_final.add(new JLabel("Precio Final:"));
        Panel_precio_final.getComponent(0).setFont(new Font("Default", Font.BOLD, 20)); // Cambia la fuente del JLabel (precio final)

        int Precio_Final = numero_personas * 12;
        // Crea el JTextField para mostrar el precio total
        Importes_precio_total = new JTextField(6);
        Importes_precio_total.setText(String.format("%d,00€", Precio_Final));
        Importes_precio_total.setHorizontalAlignment(SwingConstants.CENTER);
        Importes_precio_total.setEditable(false);
        Importes_precio_total.setBackground(Color.WHITE);
        Importes_precio_total.setFont(new Font("Tahona", Font.BOLD, 20));
        Panel_precio_final.add(Importes_precio_total);


        // Agrega el ChangeListener al JSlider para actualizar el precio del billete
        Seleccion_fila.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                Nuevo_precio_asiento(); // Actualiza el precio del asiento
                Nuevo_precio_total(); // Actualiza el precio total
            }
        });


        // Agrega ItemListener al checkbox de embarque
        Select_embarque.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                Nuevo_precio_embarque(); // Actualiza el precio del embarque
                Nuevo_precio_total(); // Actualiza el precio total
            }
        });


        // Agrega ItemListener al checkbox de equipaje
        Select_equipaje.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                Nuevo_precio_equipaje(); // Actualiza el precio del equipaje
                Nuevo_precio_total(); // Actualiza el precio total
            }
        });


        // Crea los botones
        JButton Boton_tick = new JButton();
        Panel_der_importes.add(Boton_tick);
        ImageIcon tick = new ImageIcon("aceptar.png");
        Boton_tick.setIcon(tick);

        JButton Boton_cancelar = new JButton();
        Panel_der_importes.add(Boton_cancelar);
        ImageIcon cancelar = new ImageIcon("rechazar.png");
        Boton_cancelar.setIcon(cancelar);


        // Agrega el label_img_billete al Panel_billetes
        Panel_billetes.add(label_img_billete);


        // Agrega ActionListener al botón de aceptar
        Boton_tick.addActionListener(new ActionListener() { // Se ejecuta cuando se hace click en el botón
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(Tercer_panel.this, "Ya puede retirar su billete."); // Muestra un mensaje
                if (if_ida) {
                    ImageIcon img_ida = new ImageIcon("ico_bill_av_ida.png");
                    img_ida = new ImageIcon(img_ida.getImage().getScaledInstance(350,-1, Image.SCALE_DEFAULT));
                    label_img_billete.setIcon(img_ida);
                }
                else {
                    ImageIcon img_iv = new ImageIcon("ico_bill_av_iv.png");
                    img_iv = new ImageIcon(img_iv.getImage().getScaledInstance(350, -1, Image.SCALE_DEFAULT));
                    label_img_billete.setIcon(img_iv);
                }
            }
        });

        // Agrega ActionListener al botón de cancelar
        Boton_cancelar.addActionListener(new ActionListener() { // Se ejecuta cuando se hace click en el botón
            @Override
            public void actionPerformed(ActionEvent e) {
                Vaciar_cancelar(); // Vacía los campos
            }
        });
    }


    // Método para actualizar el precio del asiento
    private void Nuevo_precio_asiento() {
        // Obtiene el valor del slider
        int num_fila = Seleccion_fila.getValue();

        // Establece el precio según el rango de valores en el slider
        if (num_fila >= 1 && num_fila <= 6) {
            Precio_asiento = 12;
        } else if (num_fila >= 7 && num_fila <= 19) {
            Precio_asiento = 8;
        } else {
            Precio_asiento = 4;
        }

        // Actualiza el contenido del JTextField
        Importes_asiento.setText(String.format("%d,00€", Precio_asiento));
    }

    // Método para actualizar el precio del embarque
    private void Nuevo_precio_embarque() {
        // Establece el precio según si el checkbox está seleccionado o no
        if (Select_embarque.isSelected()) {
            Precio_embarque = 10;
        } else {
            Precio_embarque = 0;
        }

        // Actualiza el contenido del JTextField
        Importes_embarque.setText(String.format("%d,00€", Precio_embarque));
    }


    // Método para actualizar el precio del equipaje
    private void Nuevo_precio_equipaje() {
        // Establece el precio según si el checkbox está seleccionado o no
        if (Select_equipaje.isSelected()) {
            Precio_equipaje = 25;
        } else {
            Precio_equipaje = 0;
        }

        // Actualiza el contenido del JTextField
        Importes_equipaje.setText(String.format("%d,00€", Precio_equipaje));
    }

    // Método para actualizar el precio total
    private void Nuevo_precio_total() {
        // Calcula el precio total
        Float Precio_Final;


        if (if_ida) {
            Precio_Final = (Precio_asiento + Precio_embarque + Precio_equipaje + precio_ida) * numero_personas;
        }
        else {
            Precio_Final = (Precio_asiento + Precio_embarque + Precio_equipaje + precio_ida + precio_vuelta) * numero_personas;
        }

        // Actualiza el contenido del JLabel
        Importes_precio_total.setText(String.valueOf(Precio_Final));
        Importes_precio_total.setText(String.format("%.2f€", Precio_Final));
    }


    // Método para vaciar los campos
    private void Vaciar_cancelar() {
        // Establece el valor inicial del slider
        Seleccion_fila.setValue(1); // Establece el valor del slider a 1
        Label_asiento.setText("Filas: 1"); // Establece el contenido del JLabel a vacío
        Precio_asiento = 1; // Establece el precio del asiento a 0

        // Desmarca los botones
        Seleccion_posiciones.clearSelection();

        // Desmarca los checkbox
        Select_embarque.setSelected(false);
        Select_equipaje.setSelected(false);

        // Establece el contenido de los JTextField a 0,00€
        Importes_asiento.setText("12,00€");
        Importes_embarque.setText("0,00€");
        Importes_equipaje.setText("0,00€");
        int Precio_Final = numero_personas * 12;
        Importes_precio_total.setText(String.format("%d,00€", Precio_Final));

        // Borrar la imagen
        label_img_billete.setIcon(null);
    }

    // Método para mostrar el precio total
    public static void main(String[] args) { // Método principal
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() { // Se ejecuta cuando se inicia la aplicación
                // Crea un nuevo objeto de la clase Tercer_panel
                new Tercer_panel().setVisible(true);
            }
        });
    }
}
