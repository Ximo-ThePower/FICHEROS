package texto;
//CON BUFFER
import java.io.*;

public class EjemploTres {
    public static void main(String[] args) {
        //ESCRIBIMOS CON BUFFER
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("saludo.txt", true))) {
            bw.write("Hola");
            bw.newLine();
            bw.write("¿Como estáis?");
            bw.newLine();
            bw.write("LAS NOTAS IRAN BIEN***");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        //LEEMOS UN FICHERO CON BUFFER

        try ( BufferedReader br = new BufferedReader(new FileReader("saludo.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
