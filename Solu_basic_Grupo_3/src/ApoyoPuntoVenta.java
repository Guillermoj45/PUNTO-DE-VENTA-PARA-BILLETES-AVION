import java.util.Scanner;
import java.util.Locale;
import java.time.LocalTime;
import java.time.LocalDate;
//import java.text.ParseException;
//import java.util.Date;
//import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.text.NumberFormat;
import java.util.ArrayList;


import java.time.Month;
import java.time.format.TextStyle;
public class ApoyoPuntoVenta {

    // Vuelos Sevilla
    public static ArrayList<String>[] Sevilla(){

        ArrayList<String> BCN = new ArrayList<>();
        BCN.add("BCN"); BCN.add("07:45"); BCN.add("18:55");BCN.add("90");

        ArrayList<String> MAD = new ArrayList<>();
        MAD.add("MAD"); MAD.add("08:25"); MAD.add("21:00");MAD.add("60");

        ArrayList<String> BIO = new ArrayList<>();
        BIO.add("BIO"); BIO.add("08:55"); BIO.add("20:15");BIO.add("85");

        ArrayList<String> VLC = new ArrayList<>();
        VLC.add("VLC"); VLC.add("09:15"); VLC.add("19:45");VLC.add("75");

        ArrayList<String> AGP = new ArrayList<>();
        AGP.add("AGP"); AGP.add("07:35"); AGP.add("22:00");AGP.add("30");

        ArrayList<String> LCG = new ArrayList<>();
        LCG.add("LCG"); LCG.add("08:45"); LCG.add("20:00");LCG.add("80");

        ArrayList<String> SDR = new ArrayList<>();
        SDR.add("SDR"); SDR.add("08:35"); SDR.add("20:45");SDR.add("85");

        ArrayList<String> OVD = new ArrayList<>();
        OVD.add("OVD"); OVD.add("08:55"); OVD.add("20:15");OVD.add("85");

        // Devolvemos la lista de valores
        return new ArrayList[] {BCN,MAD,BIO};
    }
    // Vuelos Barcelona
    public static ArrayList<String>[] Barcelona(){

        ArrayList<String> SVQ = new ArrayList<>();
        SVQ.add("SVQ"); SVQ.add("07:45"); SVQ.add("18:55");SVQ.add("90");

        ArrayList<String> MAD = new ArrayList<>();
        MAD.add("MAD"); MAD.add("07:35"); MAD.add("22:00");MAD.add("30");

        ArrayList<String> BIO = new ArrayList<>();
        BIO.add("BIO"); BIO.add("08:55"); BIO.add("20:15");BIO.add("85");

        ArrayList<String> VLC = new ArrayList<>();
        VLC.add("VLC"); VLC.add("09:15"); VLC.add("19:45");VLC.add("75");

        ArrayList<String> AGP = new ArrayList<>();
        AGP.add("AGP"); AGP.add("08:25"); AGP.add("21:00");AGP.add("60");

        ArrayList<String> LCG = new ArrayList<>();
        LCG.add("LCG"); LCG.add("08:45"); LCG.add("20:00");LCG.add("80");

        ArrayList<String> SDR = new ArrayList<>();
        SDR.add("SDR"); SDR.add("08:35"); SDR.add("20:45");SDR.add("85");

        ArrayList<String> OVD = new ArrayList<>();
        OVD.add("OVD"); OVD.add("08:55"); OVD.add("20:15");OVD.add("85");

        // Devolvemos la lista de valores
        return new ArrayList[] {SVQ,MAD,BIO,VLC,AGP,LCG,SDR,OVD};
    }
    public static ArrayList<String>[] Madrid(){
        ArrayList<String> SVQ = new ArrayList<>();
        SVQ.add("SVQ"); SVQ.add("07:45"); SVQ.add("18:55");SVQ.add("90");

        ArrayList<String> BCN = new ArrayList<>();
        BCN.add("BCN"); BCN.add("07:45"); BCN.add("18:55");BCN.add("90");

        ArrayList<String> BIO = new ArrayList<>();
        BIO.add("BIO"); BIO.add("08:55"); BIO.add("20:15");BIO.add("85");

        ArrayList<String> VLC = new ArrayList<>();
        VLC.add("VLC"); VLC.add("09:15"); VLC.add("19:45");VLC.add("75");

        ArrayList<String> AGP = new ArrayList<>();
        AGP.add("AGP"); AGP.add("08:25"); AGP.add("21:00");AGP.add("60");

        ArrayList<String> LCG = new ArrayList<>();
        LCG.add("LCG"); LCG.add("08:45"); LCG.add("20:00");LCG.add("80");

        ArrayList<String> SDR = new ArrayList<>();
        SDR.add("SDR"); SDR.add("08:35"); SDR.add("20:45");SDR.add("85");

        ArrayList<String> OVD = new ArrayList<>();
        OVD.add("OVD"); OVD.add("08:55"); OVD.add("20:15");OVD.add("85");

        // Devolvemos la lista de valores
        return new ArrayList[] {SVQ,BCN,BIO,VLC,AGP,LCG,SDR,OVD};
    }

    public static ArrayList<String>[] Valencia(){
        ArrayList<String> SVQ = new ArrayList<>();
        SVQ.add("SVQ"); SVQ.add("07:45"); SVQ.add("18:55");SVQ.add("90");

        ArrayList<String> BCN = new ArrayList<>();
        BCN.add("BCN"); BCN.add("07:45"); BCN.add("18:55");BCN.add("90");

        ArrayList<String> MAD = new ArrayList<>();
        MAD.add("MAD"); MAD.add("07:35"); MAD.add("22:00");MAD.add("30");

        ArrayList<String> BIO = new ArrayList<>();
        BIO.add("BIO"); BIO.add("08:55"); BIO.add("20:15");BIO.add("85");

        ArrayList<String> AGP = new ArrayList<>();
        AGP.add("AGP"); AGP.add("08:25"); AGP.add("21:00");AGP.add("60");

        ArrayList<String> LCG = new ArrayList<>();
        LCG.add("LCG"); LCG.add("08:45"); LCG.add("20:00");LCG.add("80");

        ArrayList<String> SDR = new ArrayList<>();
        SDR.add("SDR"); SDR.add("08:35"); SDR.add("20:45");SDR.add("85");

        ArrayList<String> OVD = new ArrayList<>();
        OVD.add("OVD"); OVD.add("08:55"); OVD.add("20:15");OVD.add("85");

        // Devolvemos la lista de valores
        return new ArrayList[] {SVQ,BCN,MAD,BIO,AGP,LCG,SDR,OVD};
    }

    public static ArrayList<String>[] Bilbao(){
        ArrayList<String> SVQ = new ArrayList<>();
        SVQ.add("SVQ"); SVQ.add("07:45"); SVQ.add("18:55");SVQ.add("90");

        ArrayList<String> BCN = new ArrayList<>();
        BCN.add("BCN"); BCN.add("07:45"); BCN.add("18:55");BCN.add("90");

        ArrayList<String> MAD = new ArrayList<>();
        MAD.add("MAD"); MAD.add("07:35"); MAD.add("22:00");MAD.add("30");

        ArrayList<String> VLC = new ArrayList<>();
        VLC.add("VLC"); VLC.add("09:15"); VLC.add("19:45");VLC.add("75");

        ArrayList<String> AGP = new ArrayList<>();
        AGP.add("AGP"); AGP.add("08:25"); AGP.add("21:00");AGP.add("60");

        ArrayList<String> LCG = new ArrayList<>();
        LCG.add("LCG"); LCG.add("08:45"); LCG.add("20:00");LCG.add("80");

        ArrayList<String> SDR = new ArrayList<>();
        SDR.add("SDR"); SDR.add("08:35"); SDR.add("20:45");SDR.add("85");

        ArrayList<String> OVD = new ArrayList<>();
        OVD.add("OVD"); OVD.add("08:55"); OVD.add("20:15");OVD.add("85");

        // Devolvemos la lista de valores
        return new ArrayList[] {SVQ,BCN,MAD,VLC,AGP,LCG,SDR,OVD};
    }

    public static ArrayList<String>[] Malaga(){
        ArrayList<String> SVQ = new ArrayList<>();
        SVQ.add("SVQ"); SVQ.add("07:45"); SVQ.add("18:55");SVQ.add("90");

        ArrayList<String> BCN = new ArrayList<>();
        BCN.add("BCN"); BCN.add("07:45"); BCN.add("18:55");BCN.add("90");

        ArrayList<String> MAD = new ArrayList<>();
        MAD.add("MAD"); MAD.add("07:35"); MAD.add("22:00");MAD.add("30");

        ArrayList<String> VLC = new ArrayList<>();
        VLC.add("VLC"); VLC.add("09:15"); VLC.add("19:45");VLC.add("75");

        ArrayList<String> BIO = new ArrayList<>();
        BIO.add("BIO"); BIO.add("08:55"); BIO.add("20:15");BIO.add("85");

        ArrayList<String> LCG = new ArrayList<>();
        LCG.add("LCG"); LCG.add("08:45"); LCG.add("20:00");LCG.add("80");

        ArrayList<String> SDR = new ArrayList<>();
        SDR.add("SDR"); SDR.add("08:35"); SDR.add("20:45");SDR.add("85");

        ArrayList<String> OVD = new ArrayList<>();
        OVD.add("OVD"); OVD.add("08:55"); OVD.add("20:15");OVD.add("85");

        // Devolvemos la lista de valores
        return new ArrayList[] {SVQ,BCN,MAD,VLC,BIO,LCG,SDR,OVD};
    }

    public static ArrayList<String>[] ACoruna(){
        ArrayList<String> SVQ = new ArrayList<>();
        SVQ.add("SVQ"); SVQ.add("07:45"); SVQ.add("18:55");SVQ.add("90");

        ArrayList<String> BCN = new ArrayList<>();
        BCN.add("BCN"); BCN.add("07:45"); BCN.add("18:55");BCN.add("90");

        ArrayList<String> MAD = new ArrayList<>();
        MAD.add("MAD"); MAD.add("07:35"); MAD.add("22:00");MAD.add("30");

        ArrayList<String> VLC = new ArrayList<>();
        VLC.add("VLC"); VLC.add("09:15"); VLC.add("19:45");VLC.add("75");

        ArrayList<String> BIO = new ArrayList<>();
        BIO.add("BIO"); BIO.add("08:55"); BIO.add("20:15");BIO.add("85");

        ArrayList<String> AGP = new ArrayList<>();
        AGP.add("AGP"); AGP.add("08:25"); AGP.add("21:00");AGP.add("60");

        ArrayList<String> SDR = new ArrayList<>();
        SDR.add("SDR"); SDR.add("08:35"); SDR.add("20:45");SDR.add("85");

        ArrayList<String> OVD = new ArrayList<>();
        OVD.add("OVD"); OVD.add("08:55"); OVD.add("20:15");OVD.add("85");

        // Devolvemos la lista de valores
        return new ArrayList[] {SVQ,BCN,MAD,VLC,BIO,AGP,SDR,OVD};
    }
    public static ArrayList<String>[] Santander(){
        ArrayList<String> SVQ = new ArrayList<>();
        SVQ.add("SVQ"); SVQ.add("07:45"); SVQ.add("18:55");SVQ.add("90");

        ArrayList<String> BCN = new ArrayList<>();
        BCN.add("BCN"); BCN.add("07:45"); BCN.add("18:55");BCN.add("90");

        ArrayList<String> MAD = new ArrayList<>();
        MAD.add("MAD"); MAD.add("07:35"); MAD.add("22:00");MAD.add("30");

        ArrayList<String> VLC = new ArrayList<>();
        VLC.add("VLC"); VLC.add("09:15"); VLC.add("19:45");VLC.add("75");

        ArrayList<String> BIO = new ArrayList<>();
        BIO.add("BIO"); BIO.add("08:55"); BIO.add("20:15");BIO.add("85");

        ArrayList<String> AGP = new ArrayList<>();
        AGP.add("AGP"); AGP.add("08:25"); AGP.add("21:00");AGP.add("60");

        ArrayList<String> LCG = new ArrayList<>();
        LCG.add("LCG"); LCG.add("08:45"); LCG.add("20:00");LCG.add("80");

        ArrayList<String> OVD = new ArrayList<>();
        OVD.add("OVD"); OVD.add("08:55"); OVD.add("20:15");OVD.add("85");

        // Devolvemos la lista de valores
        return new ArrayList[] {SVQ,BCN,MAD,VLC,BIO,AGP,LCG,OVD};
    }

    public static ArrayList<String>[] Asturias(){
        ArrayList<String> SVQ = new ArrayList<>();
        SVQ.add("SVQ"); SVQ.add("07:45"); SVQ.add("18:55");SVQ.add("90");

        ArrayList<String> BCN = new ArrayList<>();
        BCN.add("BCN"); BCN.add("07:45"); BCN.add("18:55");BCN.add("90");

        ArrayList<String> MAD = new ArrayList<>();
        MAD.add("MAD"); MAD.add("07:35"); MAD.add("22:00");MAD.add("30");

        ArrayList<String> VLC = new ArrayList<>();
        VLC.add("VLC"); VLC.add("09:15"); VLC.add("19:45");VLC.add("75");

        ArrayList<String> BIO = new ArrayList<>();
        BIO.add("BIO"); BIO.add("08:55"); BIO.add("20:15");BIO.add("85");

        ArrayList<String> AGP = new ArrayList<>();
        AGP.add("AGP"); AGP.add("08:25"); AGP.add("21:00");AGP.add("60");

        ArrayList<String> LCG = new ArrayList<>();
        LCG.add("LCG"); LCG.add("08:45"); LCG.add("20:00");LCG.add("80");

        ArrayList<String> SDR = new ArrayList<>();
        SDR.add("SDR"); SDR.add("08:35"); SDR.add("20:45");SDR.add("85");

        // Devolvemos la lista de valores
        return new ArrayList[] {SVQ,BCN,MAD,VLC,BIO,AGP,LCG,SDR};
    }

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
        tempos.put("SVQ", Sevilla());
        tempos.put("BCN", Barcelona());
        tempos.put("MAD", Madrid());
        tempos.put("VLC", Valencia());
        tempos.put("BIO", Bilbao());
        tempos.put("AGP", Malaga());
        tempos.put("LCG", ACoruna());
        tempos.put("SDR", Santander());
        tempos.put("OVD", Asturias());


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
            mensaje = "La ciudad de origen no ha sido encontrada";
        }

        return mensaje;

    }


    public static String transformaFecha(String[] args) {
//        System.out.println("Opción 1");

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


    public static String gener_hora_llegada() {
        System.out.println("Opción 2");

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


    public static String gener_tabla_nombres() {
        System.out.println("Opción 3");

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
            } else {
                System.out.println("\nMes no válido.");
            }
        }
        return cadena_meses.substring(0, cadena_meses.length() - 2);
    }

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
}