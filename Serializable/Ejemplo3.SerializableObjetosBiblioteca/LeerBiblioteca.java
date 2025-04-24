package biblioteca;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class LeerBiblioteca {
    public static void main(String[] args) {
        ArrayList<Libro> miBiblioteca;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("biblioteca.ser"));) {
            miBiblioteca = (ArrayList<Libro>) ois.readObject();

            for (Libro l: miBiblioteca) {
                System.out.println(l.toString());
            }

        }catch (IOException  | ClassNotFoundException e) {
            System.out.println("Error de lectura");
        }



    }
}
