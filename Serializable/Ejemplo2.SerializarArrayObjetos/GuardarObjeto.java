package Serializable;

import java.io.*;

public class GuardarObjeto {
    public static void main(String[] args) {

        Persona[] personas = {
                new Persona("Jose", 23),
                new Persona("Ita", 18),
                new Persona("Aihoe", 18)
        };
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("persona.ser"))) {
            oos.writeObject(personas);
            System.out.println("Persona guardado");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }


        //Leemos
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("persona.ser"))) {
            Persona[] p2;
            p2 = (Persona[]) ois.readObject();

        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        for (Persona persona : personas) {
            System.out.println(persona);
        }
    }
}
