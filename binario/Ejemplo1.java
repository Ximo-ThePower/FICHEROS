package binario;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

//ESCRIBIREMOS NÚMEROS DEL 1 AL 5 EN UN FICHERO BINARIO
//LO LEEREMOS Y MOSTRAREMOS EL CONTENIDO

public class Ejemplo1 {
    public static void main(String[] args) {
        //PASO 1 - ESCRIBIMOS EN UN FICHERO
        try (FileOutputStream fos = new FileOutputStream("numeros.dat");) {
            for (int i = 0; i < 5; i++) {
                fos.write(i);
            }
        } catch (IOException ioe) {
            System.out.println("Error al abrir el fichero");
        }

        //PASO 2 - LEEMOS EN UN FICHERO
        try(FileInputStream fis = new FileInputStream("numeros.dat")) {
            int dato;
            while ((dato = fis.read()) != -1) {
                System.out.println("Número leido: " + dato);
            }
        } catch (IOException ioe) {
            System.out.println("Error al abrir el fichero");
        }

    }
}
