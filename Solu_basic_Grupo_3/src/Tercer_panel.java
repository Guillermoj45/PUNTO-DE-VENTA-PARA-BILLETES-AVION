import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Tercer_panel extends JFrame {
    // Paneles detalles e importes
    private final JPanel Panel_detalles;
    private final JPanel Panel_importes;


    // Labels del panel detalles
    private JLabel Label_asiento;


    // TextFields del panel importes
    private JTextField Importes_asiento;
    private JTextField Importes_embarque;
    private JTextField Importes_equipaje;


    // Labels del panel importes
    private JLabel Importes_precio_total;


    // Sliders y botones
    private JSlider Seleccion_fila; // Slider para seleccionar la fila
    private ButtonGroup Seleccion_posiciones; // Grupo de botones para seleccionar una posición
    private JCheckBox Select_embarque, Select_equipaje; // CheckBox para seleccionar el embarque y el equipaje


    // Precios de los asientos, embarque y equipaje
    private int Precio_asiento;
    private int Precio_embarque;
    private int Precio_equipaje;


    // Constructor
    public Tercer_panel() {
        // Configuración del frame
        setTitle("Air Camela");
        setSize(800, 400); // Ajusta el tamaño del frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // Creación de los paneles
        Panel_detalles = new JPanel(new GridLayout(2, 1));
        Panel_importes = new JPanel(new GridLayout(7, 2));

        // Configuración del panel de detalles
        Panel_detalles_config();

        // Configuración del panel de importes
        Panel_importes_config();


        // Configuración del layout principal
        setLayout(new GridLayout(1, 2));

        // Agrega los paneles al layout principal
        add(Panel_detalles);
        add(Panel_importes);

        // Le doy un valor inicial a los precios
        Precio_asiento = 0;
        Precio_embarque = 0;
        Precio_equipaje = 0;
    }


    // Configuración del panel de detalles
    private void Panel_detalles_config() {
        Panel_detalles.setBorder(BorderFactory.createTitledBorder("Detalles"));

        // Panel asiento
        JPanel Panel_asiento = new JPanel(new GridLayout(3, 1));
        Panel_asiento.setBorder(BorderFactory.createTitledBorder("Asiento"));


        // Creal el Label filas
        Label_asiento = new JLabel("Filas:");

        // Agrega el Label_asiento al Panel_asiento
        Panel_asiento.add(Label_asiento);


        // Crea el slider para seleccionar la fila
        Seleccion_fila = new JSlider(1, 26, 1);
        Seleccion_fila.setMajorTickSpacing(5); // Separación entre los valores, las rayitas grandes
        Seleccion_fila.setMinorTickSpacing(1); // Separación entre los valores, las rayitas pequeñas
        Seleccion_fila.setPaintTicks(true); // Muestra las rayitas
        Seleccion_fila.setPaintLabels(true); // Muestra los valores


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

        // Crea los botones
        JRadioButton opcion_pasillo = new JRadioButton("Pasillo");
        JRadioButton opcion_centro = new JRadioButton("Centro");
        JRadioButton opcion_ventana = new JRadioButton("Ventana");

        // Agrega los botones al grupo
        Seleccion_posiciones.add(opcion_pasillo);
        Seleccion_posiciones.add(opcion_centro);
        Seleccion_posiciones.add(opcion_ventana);


        // Crea el Panel_extras
        JPanel Panel_extras = new JPanel(new GridLayout(2, 1));
        Panel_extras.setBorder(BorderFactory.createTitledBorder("Extras"));


        // Crea el Panel_embarque_equipaje
        JPanel Panel_embarque_equipaje = new JPanel(new GridLayout(1, 2));


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
        Panel_embarque_equipaje.add(Panel_embarque);
        Panel_embarque_equipaje.add(Panel_equipaje);


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

        // Agrega el Panel_embarque_equipaje al Panel_extras
        Panel_extras.add(Panel_embarque_equipaje);


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
        Panel_importes.setBorder(BorderFactory.createTitledBorder("Importes"));
        Panel_importes.setLayout(new GridLayout(4, 2, 5, 5)); // 4 rows, 2 columns, 5px horizontal and vertical gap


        // Agrega el Label_asiento al Panel_importes
        Panel_importes.add(new JLabel("Asiento:"));

        // Crea el JTextField para mostrar el precio del asiento
        Importes_asiento = new JTextField("0,00€"); // Valor inicial
        Importes_asiento.setEditable(false); // No se puede editar
        Importes_asiento.setBackground(Color.WHITE); // Poner el fondo blanco
        Panel_importes.add(Importes_asiento); // Agrega el JTextField al Panel_importes


        // Agrega el Label_embarque al Panel_importes
        Panel_importes.add(new JLabel("Embarque:"));

        // Crea el JTextField para mostrar el precio del embarque
        Importes_embarque = new JTextField("0,00€");
        Importes_embarque.setEditable(false);
        Importes_embarque.setBackground(Color.WHITE);
        Panel_importes.add(Importes_embarque);


        // Agrega el Label_equipaje al Panel_importes
        Panel_importes.add(new JLabel("Equipaje:"));

        // Crea el JTextField para mostrar el precio del equipaje
        Importes_equipaje = new JTextField("0,00€");
        Importes_equipaje.setEditable(false);
        Importes_equipaje.setBackground(Color.WHITE);
        Panel_importes.add(Importes_equipaje);


        // Agrega el Label_precio_total al Panel_importes
        Panel_importes.add(new JLabel("Precio Final:"));

        // Crea el JTextField para mostrar el precio total
        Importes_precio_total = new JLabel("0,00€");
        Panel_importes.add(Importes_precio_total);


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
        JButton Boton_tick = new JButton("Aceptar");
        JButton Boton_cancelar = new JButton("Cancelar");

        // Agrega ActionListener al botón de aceptar
        Boton_tick.addActionListener(new ActionListener() { // Se ejecuta cuando se hace click en el botón
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Precio_asiento == 0) {
                    JOptionPane.showMessageDialog(Tercer_panel.this, "Elija la fila antes de retirar su billete."); // Muestra un mensaje de error
                }
                else {
                    JOptionPane.showMessageDialog(Tercer_panel.this, "Ya puede retirar su billete."); // Muestra un mensaje
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

        // Agrega los botones al Panel_importes
        Panel_importes.add(Boton_tick);
        Panel_importes.add(Boton_cancelar);
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
        Importes_asiento.setText(String.format("%d ,00€", Precio_asiento));
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
        Importes_embarque.setText(String.format("%d ,00€", Precio_embarque));
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
        Importes_equipaje.setText(String.format("%d ,00€", Precio_equipaje));
    }

    // Método para actualizar el precio total
    private void Nuevo_precio_total() {
        // Calcula el precio total
        int Precio_Final = Precio_asiento + Precio_embarque + Precio_equipaje;

        // Actualiza el contenido del JLabel
        Importes_precio_total.setText(String.format("%d ,00€", Precio_Final));
    }


    // Método para vaciar los campos
    private void Vaciar_cancelar() {
        // Establece el valor inicial del slider
        Seleccion_fila.setValue(1); // Establece el valor del slider a 1
        Label_asiento.setText("Filas: "); // Establece el contenido del JLabel a vacío
        Precio_asiento = 0; // Establece el precio del asiento a 0

        // Desmarca los botones
        Seleccion_posiciones.clearSelection();

        // Desmarca los checkbox
        Select_embarque.setSelected(false);
        Select_equipaje.setSelected(false);

        // Establece el contenido de los JTextField a 0,00€
        Importes_asiento.setText("0,00€");
        Importes_embarque.setText("0,00€");
        Importes_equipaje.setText("0,00€");
        Importes_precio_total.setText("0,00€");
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
