package serializable;


//        Ejercicio: Serialización de Objetos Coche
//        Crea una clase llamada Coche con los siguientes atributos: marca, modelo y matricula.
//        Implementa la interfaz Serializable.
//        Crea 5 objetos de tipo Coche y guárdalos en un ArrayList.
//        Implementa dos métodos:
//        Uno para guardar la lista en un archivo llamado coches.dat.
//        Otro para leer ese archivo y mostrar los coches por consola.


import java.io.*;
import java.util.ArrayList;

public class GestionCoches {

    public static void main(String[] args) {
        ArrayList<Coche> listaCoches = new ArrayList<>();

        // Crear 5 coches de ejemplo
        listaCoches.add(new Coche("Toyota", "Corolla", "1234ABC"));
        listaCoches.add(new Coche("Ford", "Focus", "5678DEF"));
        listaCoches.add(new Coche("Honda", "Civic", "9012GHI"));
        listaCoches.add(new Coche("Renault", "Clio", "3456JKL"));
        listaCoches.add(new Coche("Volkswagen", "Golf", "7890MNO"));

        // Guardar en archivo
        guardarCoches(listaCoches, "coches.ser");

        // Leer del archivo
        ArrayList<Coche> cochesLeidos = leerCoches("coches.ser");

        // Mostrar resultados
        System.out.println("Coches leídos desde archivo:");
        for (Coche c : cochesLeidos) {
            System.out.println(c);
        }
    }

    public static void guardarCoches(ArrayList<Coche> coches, String archivo) {
        //try with resources
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(coches);
            System.out.println(" Lista de coches guardada correctamente.");
        } catch (IOException e) {
            System.out.println(" Error al guardar coches: " + e.getMessage());
        }
    }

    public static ArrayList<Coche> leerCoches(String archivo) {
        ArrayList<Coche> coches = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            coches = (ArrayList<Coche>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(" Error al leer coches: " + e.getMessage());
        }
        return coches;
    }
}

