import java.text.NumberFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

public class ApoyoPuntoVenta {


    public static ArrayList<String>[] Sevilla(){
        // Sevilla
        ArrayList<String> BCN = new ArrayList<>();
        BCN.add("BCN"); BCN.add("07:45"); BCN.add("18:55");BCN.add("90");

        ArrayList<String> MAD = new ArrayList<>();
        MAD.add("MAD"); MAD.add("08:25"); MAD.add("21:00");MAD.add("60");

        ArrayList<String> BIO = new ArrayList<>();
        BIO.add("BIO"); BIO.add("08:55"); BIO.add("20:15");BIO.add("85");

        // Devolvemos la lista de valores
        return new ArrayList[] {BCN,MAD,BIO};
    }
    public static ArrayList<String>[] Barcelona(){
        // Barcelona
        ArrayList<String> BCN = new ArrayList<>();
        BCN.add("SVQ"); BCN.add("07:45"); BCN.add("18:55");BCN.add("90");

        ArrayList<String> MAD = new ArrayList<>();
        MAD.add("MAD"); MAD.add("07:35"); MAD.add("22:00");MAD.add("30");

        ArrayList<String> BIO = new ArrayList<>();
        BIO.add("BIO"); BIO.add("08:55"); BIO.add("20:15");BIO.add("85");

        // Devolvemos la lista de valores
        return new ArrayList[] {BCN,MAD,BIO};
    }

    public static String RecoDate(){
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


        Scanner input = new Scanner(System.in);
        System.out.print("Origen: ");
        String Ciudad = input.nextLine();
        System.out.print("Destino: ");
        String CiudadDest = input.nextLine();
        System.out.println();

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
                    NumberFormat formato = NumberFormat.getCurrencyInstance(new Locale("es","ES"));
                    mensaje = Ciudad + "(" + Origen + ")  =>  " + CiudadDest + "(" + Destino + ")\t" + horaSalida + "\t" +
                            horaSalida.plusMinutes(Integer.parseInt(vuelo.get(3))) + "\t" + formato.format(Precio) +"\n";
                    mensaje += Ciudad+ "(" + Origen + ")  =>  " + CiudadDest + "(" + Destino + ")\t" + horaVuelta + "\t" +
                            horaVuelta.plusMinutes(Integer.parseInt(vuelo.get(3)))+ "\t" + formato.format(Precio2);
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
