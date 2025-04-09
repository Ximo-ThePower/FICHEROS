package texto;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//CREAREMOS UN ARCHIVO E INSERTERAMOS UN TEXTO SIMPLE.

public class EjemploUno {
    public static void main(String[] args) {
        //PASO 1 ESCRIBIR ARCHIVO
        try ( FileWriter fw = new FileWriter("texto.txt", false)) {

            fw.write("Hola Mundo\n");
            fw.write("Otra linea\n");
        } catch (IOException ioe) {
            System.out.println("Error al escribir el archivo");
            ioe.printStackTrace();
        }
        //PASO 2 LEER ARCHIVO
        try (FileReader fr = new FileReader("texto.txt")){
            int c;
            while ((c = fr.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (IOException ioe) {
            System.out.println("Error al leer el archivo");
            ioe.printStackTrace();
        }
    }
}