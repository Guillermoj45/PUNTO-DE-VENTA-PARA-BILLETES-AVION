import java.text.DateFormat;
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
                diasMes = month.length(LocalDate.now().isLeapYear());
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
        IATA.put("Sevilla", "SVQ"); IATA.put("Madrid", "MAD"); IATA.put("Barcelona", "BCN"); IATA.put("Valencia", "VLC");
        IATA.put("Bilbao", "BIO"); IATA.put("Málaga", "AGP"); IATA.put("A Coruña", "LCG"); IATA.put("Santander", "SDR");
        IATA.put("Asturias", "OVD");

        // Añadimos la megalista al diccionario
        HashMap<String, ArrayList<String> []> tempos = new HashMap<>();
        tempos.put("SVQ", CiuDate.Sevilla());
        tempos.put("BCN", CiuDate.Barcelona());
        tempos.put("MAD", CiuDate.Madrid());
        tempos.put("VLC", CiuDate.Valencia());
        tempos.put("BIO", CiuDate.Bilbao());
        tempos.put("AGP", CiuDate.Malaga());
        tempos.put("LCG", CiuDate.ACoruna());
        tempos.put("SDR", CiuDate.Santander());
        tempos.put("OVD", CiuDate.Asturias());


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