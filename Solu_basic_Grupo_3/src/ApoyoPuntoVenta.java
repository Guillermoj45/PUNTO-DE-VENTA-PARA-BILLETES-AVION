import java.util.Scanner;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;

public class ApoyoPuntoVenta {


    // Parte de Vega - Opción 2
    public static String gener_hora_llegada() {

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nHora de despegue (hh:mm): ");
        String hora_despegue = scanner.next();
        System.out.print("Duración (en minutos): ");
        int duracion_min = scanner.nextInt();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime hora_despegue_fin = LocalTime.parse(hora_despegue, formatter);

        LocalTime hora_llegada = hora_despegue_fin.plusMinutes(duracion_min);

        return hora_llegada.format(formatter);
    }

    // Parte de Vega - Opción 3
    public static String gener_tabla_nombres() {

        String[] meses = {
                "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
                "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
        };

        String cadena_meses = "";

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("\nIntroduzca el mes en formato numérico: ");
            int num_mes = scanner.nextInt();

            System.out.println("\nLa tabla se está generando...");
            int primer_mes = num_mes - 1;

            if (primer_mes >= 0 && num_mes <= 12) {

                for (int i = 0; i < meses.length; i++) {
                    cadena_meses += (meses[(primer_mes + i) % meses.length] + ", ");
                }

                break;
            }
            else {
                System.out.println("\nMes no válido.");
            }
        }
        return cadena_meses.substring(0, cadena_meses.length() - 2);
    }

    // Parte de Pablo - Opción 1
    public static String transformaFecha(String[] args) {

        //Recepción de valores como parámetros de ejecución
        String arg1 = args[0];
        String arg2 = args[1];
        String arg3 = args[2];

        System.out.println("\nSe ha recibido como parámetro de ejecución\n");
        System.out.println("Día: " + arg1);
        System.out.println("Mes: " + arg2);
        System.out.println("Año: " + arg3);


        //Formateo de la fecha
        String fechaBasica = String.join("/", arg1, arg2, arg3);
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(fechaBasica, inputFormatter);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("d-MMMM-yyyy", new Locale("es", "ES"));
        String fechaSalida = date.format(outputFormatter);


        return fechaSalida;
    }

    // Parte de Pablo - Opción 4
    public static int numeroDiasMes() {

        //Introducir nombre del mes por teclado
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nIntroduzca el mes en formato cadena: ");
        String nombreMes = scanner.next();

        //Traducir el nombre del mes y hallar su longitud
        int diasMes = 0;
        boolean mesValido = false;
        for (Month month : Month.values()) {
            if (month.getDisplayName(TextStyle.FULL, Locale.forLanguageTag("es")).equalsIgnoreCase(nombreMes)) {
                diasMes = month.length(false);
                mesValido = true;
                break;
            }
        }
        if (mesValido = false) {
            System.out.print("\nMes no válido.\n");
        }
        return diasMes;
    }

    // Parte de Guille - Opción 5
    public static String RecoDate(String Ciudad, String CiudadDest){
        String mensaje = "";
        System.out.println();

        // Diccionario de las abreviaciones
        HashMap<String,String> IATA = new HashMap<>();

        // Aereopuertos publicos
        IATA.put("Alcobendas-Madrid", "MAD");
        IATA.put("Albacete", "ABC");
        IATA.put("Elche", "ALC");
        IATA.put("El Alquián", "LEI");
        IATA.put("Turias", "OVD");
        IATA.put("Talavera la Real", "BJZ");
        IATA.put("El Prat de Llobregat", "BCN");
        IATA.put("Lujua", "BIO");
        IATA.put("Burgos", "RGS");
        IATA.put("Córdoba", "ODB");
        IATA.put("Santa Fe", "GRX");
        IATA.put("Aiguaviva", "GRO");
        IATA.put("Telde", "LPA");
        IATA.put("Puerto del Rosario", "FUE");
        IATA.put("Culleredo", "LCG");
        IATA.put("San Bartolomé", "ACE");
        IATA.put("Monflorite", "HSK");
        IATA.put("San José", "IBZ");
        IATA.put("Jerez de la Frontera", "XRY");
        IATA.put("La Virjen del Camino", "LEN");
        IATA.put("Agoncillo", "RJL");
        IATA.put("Cuatro Vientos-Madrid", "MCV");
        IATA.put("Málaga", "AGP");
        IATA.put("Melilla", "MLN");
        IATA.put("Mahón", "MAH");
        IATA.put("Corvera", "RMU");
        IATA.put("Palma de Mallorca", "PMI");
        IATA.put("Noaín", "PNA");
        IATA.put("Reus", "REU");
        IATA.put("Sabadell", "QSA");
        IATA.put("Machacón", "SLM");
        IATA.put("Fuenterrabía", "EAS");
        IATA.put("Boqueijón", "SCQ");
        IATA.put("Sevilla", "SVQ");
        IATA.put("Camargo", "SDR");
        IATA.put("Marrachí", "SBO");
        IATA.put("San Cristóbal del La Laguna", "TFN");
        IATA.put("Granadilla de Abona", "TFS");
        IATA.put("Villa de Mazo", "SPC");
        IATA.put("Alajeró", "GMZ");
        IATA.put("Valverde", "VDE");
        IATA.put("Manises", "VLC");
        IATA.put("Villanubla", "VLL");
        IATA.put("Vigo", "VGO");
        IATA.put("Vitoria", "VIT");
        IATA.put("Zaragoza", "ZAZ");

        // Aereopuertos privados
        IATA.put("Montferrer Castellbó", "LEU");
        IATA.put("Benlloch", "CDT");
        IATA.put("Cañada de Calatrava", "CQM");
        IATA.put("Alguaire", "ILD");
        IATA.put("Teruel", "TEV");


        // Añadimos la megalista al diccionario
        HashMap<String, ArrayList<String> []> tempos = new HashMap<>();
        tempos.put("SVQ", CiuDate.San_Pablo());
        tempos.put("MAD", CiuDate.Barajas());
        tempos.put("ALC", CiuDate.El_Altet());



        String Origen = IATA.get(Ciudad);
        String Destino = IATA.get(CiudadDest);

        ArrayList<String> [] VueCiudad = tempos.get(Origen);
        LocalTime horaSalida;
        LocalTime horaVuelta;

        if (VueCiudad != null){
            for (ArrayList<String> vuelo : VueCiudad) {
                if (vuelo.getFirst().equals(Destino)){
                    horaSalida = LocalTime.parse(vuelo.get(1));
                    horaVuelta = LocalTime.parse(vuelo.get(2));

                    float Precio = (float) (Math.random()*25+35);
                    float Precio2 = (float) (Math.random()*25+35);

                    LocalTime horaEsti =horaSalida.plusMinutes(Integer.parseInt(vuelo.get(3)));
                    LocalTime horaEsti2 =horaVuelta.plusMinutes(Integer.parseInt(vuelo.get(3)));

                    NumberFormat formato = NumberFormat.getCurrencyInstance(new Locale("es","ES"));
                    mensaje = Ciudad + "(" + Origen + ")  =>  " + CiudadDest + "(" + Destino + ")\t" + horaSalida + "\t" +
                            horaEsti + "\t" + formato.format(Precio) +"\n";
                    mensaje += Ciudad+ "(" + Origen + ")  =>  " + CiudadDest + "(" + Destino + ")\t" + horaVuelta + "\t" +
                            horaEsti2 + "\t" + formato.format(Precio2);
                }
            }
            if (mensaje.isEmpty()){
                mensaje = "La ciudad de destino no fue encontrada";
            }
        }
        else {
            mensaje = "La ciudad de origen no a sido encontrada";
        }

        return mensaje;

    }



}