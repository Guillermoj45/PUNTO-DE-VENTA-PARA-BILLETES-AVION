import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ApoyoPuntoVenta {


    public static void RecoDate(){
        String mensaje = "";

        // Diccionario de las abreviaciones
        HashMap<String,String> IATA = new HashMap<>();
        IATA.put("Sevilla", "SVQ"); IATA.put("Madrid", "MAD"); IATA.put("Barcelona", "BCN"); IATA.put("Valencia", "VLC");
        IATA.put("Bilbao", "BIO"); IATA.put("Málaga", "AGP"); IATA.put("A Coruña", "LCG"); IATA.put("Santander", "SDR");
        IATA.put("Asturias", "OVD");

        // Lista de ciudades con respectivas
        ArrayList<String> BCN = new ArrayList<>();
        BCN.add("BCN"); BCN.add("07:45"); BCN.add("18:55");BCN.add("90");

        ArrayList<String> MAD = new ArrayList<>();
        MAD.add("MAD"); MAD.add("08:25"); MAD.add("21:00");MAD.add("60");

        ArrayList<String> BIO = new ArrayList<>();
        BIO.add("BIO"); BIO.add("08:55"); BIO.add("20:15");BIO.add("85");

        // Incrustacion de listas en lista principal
        ArrayList<ArrayList<String>> TODO = new ArrayList<>();
        TODO.add(BCN);TODO.add(MAD);TODO.add(BIO);

        // Añadimos la megalista al diccionario
        HashMap<String, ArrayList<ArrayList<String>>> tempos = new HashMap<>();
        tempos.put("SVQ", TODO);

        Scanner input = new Scanner(System.in);
        System.out.print("Origen: ");
        String Ciudad = input.nextLine();
        System.out.print("Destino: ");
        String CiudadDest = input.nextLine();

        String Origen = IATA.get(Ciudad);
        String Destino = IATA.get(CiudadDest);

        ArrayList<ArrayList<String>> VueCiudad = tempos.get(Origen);
        LocalTime horaSalida;
        LocalTime horaVuelta;
        for (ArrayList<String> vuelo : VueCiudad) {
            if (vuelo.getFirst().equals(Destino)){
                horaSalida = LocalTime.parse(vuelo.get(1));
                horaVuelta = LocalTime.parse(vuelo.get(2));
                // Pendiente poner precios
                float Precio = (int) (Math.random()*10);
                mensaje = Ciudad+ "(" + Origen + ")  =>  " + CiudadDest + "(" + Destino + ")\t" + horaSalida + "\t" +
                        horaSalida.plusMinutes(Integer.parseInt(vuelo.get(3))) + Precio +"\n";
                mensaje = mensaje + Ciudad+ "(" + Origen + ")  =>  " + CiudadDest + "(" + Destino + ")\t" + horaVuelta + "\t" +
                        horaVuelta.plusMinutes(Integer.parseInt(vuelo.get(3)));
            }
        }
        System.out.println(mensaje);

    }
}
