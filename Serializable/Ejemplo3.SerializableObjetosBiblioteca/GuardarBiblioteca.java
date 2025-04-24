package biblioteca;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class GuardarBiblioteca {
    public static void main(String[] args) {
        ArrayList<Libro> miBiblioteca = new ArrayList<>();
        miBiblioteca.add(new Libro ("La guardia", "Terry Pratched","MundoDisco"));
        miBiblioteca.add( new Libro ("Elocuent javascript","asdf","asd"));

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("biblioteca.ser"));) {
            oos.writeObject(miBiblioteca);
        }catch (IOException ioe) {
            System.out.println("Error de escritura");
        }
    }
}
