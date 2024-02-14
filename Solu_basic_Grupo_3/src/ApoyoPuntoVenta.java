import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ApoyoPuntoVenta {


    public static void RecoDate(){

        // Diccionario de las abreviaciones
        HashMap<String,String> IATA = new HashMap<>();
        IATA.put("Sevilla", "SVQ"); IATA.put("Madrid", "MAD"); IATA.put("Barcelona", "BCN"); IATA.put("Valencia", "VLC");
        IATA.put("Bilbao", "BIO"); IATA.put("Málaga", "AGP"); IATA.put("A Coruña", "LCG"); IATA.put("Santander", "SDR");
        IATA.put("Asturias", "OVD");

        // Lista de ciudades con respectivas
        ArrayList<String> BCN = new ArrayList<>();
        BCN.add("BCN"); BCN.add("07:45"); BCN.add("18:55");BCN.add("90");

        ArrayList<String> MAD = new ArrayList<>();
        BCN.add("MAD"); BCN.add("08:25"); BCN.add("21:00");BCN.add("60");

        ArrayList<String> BIO = new ArrayList<>();
        BCN.add("BIO"); BCN.add("08:55"); BCN.add("20:15");BCN.add("85");

        ArrayList<ArrayList<String>> TODO = new ArrayList<>();
        TODO.add(BCN);TODO.add(MAD);TODO.add(BIO);

        HashMap<String, ArrayList<ArrayList<String>>> tempos = new HashMap<>();
        tempos.put("SVQ", TODO);

        Scanner input = new Scanner(System.in);
        System.out.print("Origen: ");
        String Origen = input.nextLine();
        System.out.print("Destino: ");
        String Destino = input.nextLine();


    }
}
