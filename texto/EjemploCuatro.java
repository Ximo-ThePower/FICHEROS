package texto;

import java.io.*;

public class EjemploCuatro {
    public static void main(String[] args) {
        try (
                BufferedReader br = new BufferedReader(new FileReader("saludo.txt"));
                BufferedWriter bw = new BufferedWriter(new FileWriter("copiaSaludo.txt", true))
                ) {
                    String linea;

                    while ((linea = br.readLine()) != null) {
                        bw.write(linea);
                        bw.newLine();
                    }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
