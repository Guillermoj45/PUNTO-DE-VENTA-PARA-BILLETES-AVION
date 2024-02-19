import java.util.Scanner;

public class PilotoAPV {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Origen: ");
        String Ciudad = input.nextLine();
        System.out.print("Destino: ");
        String CiudadDest = input.nextLine();
        System.out.println();
        System.out.println(ApoyoPuntoVenta.RecoDate(Ciudad,CiudadDest));
    }
}